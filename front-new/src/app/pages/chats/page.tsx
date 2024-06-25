'use client';
import { useEffect, useState, useRef } from 'react';
import axios from 'axios';
import SockJS from 'sockjs-client';
import { Client } from '@stomp/stompjs';
import '@/app/styles/chat.css';

interface Message {
  type: string;
  sender: string;
  message: string;
}

interface ChatRoom {
  roomId: string;
  name: string;
}

const Home = () => {
  const [messages, setMessages] = useState<Message[]>([]);
  const [inputValue, setInputValue] = useState('');
  const [chatRooms, setChatRooms] = useState<ChatRoom[]>([]);
  const [selectedRoom, setSelectedRoom] = useState<ChatRoom | null>(null);
  const [username, setUsername] = useState(localStorage.getItem('wschat.sender') || '');
  const stompClient = useRef<Client | null>(null);

  useEffect(() => {
    fetchChatRooms();
    if (username) {
      connectWebSocket();
    }
    return () => disconnectWebSocket();
  }, [username, selectedRoom]);

  const fetchChatRooms = async () => {
    try {
      const response = await axios.get<ChatRoom[]>('http://localhost:8080/api/chat/rooms');
      setChatRooms(response.data);
    } catch (error) {
      console.error('Failed to fetch chat rooms', error);
    }
  };

  const connectWebSocket = () => {
    const socket = new SockJS('http://localhost:8080/ws-stomp');
    stompClient.current = new Client({
      webSocketFactory: () => socket,
      debug: (str) => console.log(str),
    });

    stompClient.current.onConnect = () => {
      if (selectedRoom) {
        stompClient.current?.subscribe(`/sub/chat/room/${selectedRoom.roomId}`, (message) => {
          const newMessage = JSON.parse(message.body) as Message;
          setMessages((prevMessages) => [...prevMessages, newMessage]);
        });

        if (stompClient.current) {
          stompClient.current.publish({
            destination: '/pub/message',
            body: JSON.stringify({
              type: 'ENTER',
              roomId: selectedRoom.roomId,
              sender: username,
            }),
          });
        }
      }
    };

    stompClient.current.onStompError = (frame) => {
      console.error('Broker reported error: ' + frame.headers['message']);
      console.error('Additional details: ' + frame.body);
    };

    stompClient.current.activate();
  };

  const disconnectWebSocket = () => {
    if (stompClient.current) {
      stompClient.current.deactivate();
    }
  };

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setInputValue(event.target.value);
  };

  const handleUsernameChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setUsername(event.target.value);
  };

  const saveUsername = () => {
    localStorage.setItem('wschat.sender', username);
    connectWebSocket();
  };

  const sendMessage = () => {
    if (stompClient.current && inputValue && selectedRoom) {
      const body = {
        type: 'TALK',
        roomId: selectedRoom.roomId,
        sender: username,
        message: inputValue,
      };
      stompClient.current.publish({
        destination: '/pub/message',
        body: JSON.stringify(body),
      });
      setInputValue('');
    }
  };

  const selectRoom = (room: ChatRoom) => {
    setSelectedRoom(room);
    setMessages([]);
  };

  return (
    <div className="container">
      {!username && (
        <div>
          <h2>대화명을 입력하세요</h2>
          <input type="text" value={username} onChange={handleUsernameChange} />
          <button onClick={saveUsername}>저장</button>
        </div>
      )}
      {username && (
        <>
          <h1>채팅방</h1>
          <div>
            <input
              type="text"
              value={inputValue}
              onChange={handleInputChange}
              placeholder="메시지를 입력하세요"
            />
            <button onClick={sendMessage}>보내기</button>
          </div>
          <ul>
            {messages.map((msg, index) => (
              <li key={index} className="message">
                {msg.sender}: {msg.message}
              </li>
            ))}
          </ul>
          <h2>채팅방 목록</h2>
          <ul>
            {chatRooms.map((room) => (
              <li key={room.roomId} className="chatRoom" onClick={() => selectRoom(room)}>
                {room.name}
              </li>
            ))}
          </ul>
        </>
      )}
    </div>
  );
};

export default Home;
