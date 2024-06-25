import React, { useEffect, useState, useRef } from 'react';
import { IChat } from '../model/chat.model';


const Chat: React.FC = () => {
  const [messages, setMessages] = useState<IChat[]>([]);
  const [message, setMessage] = useState('');
  const username = 'userName';
  const websocket = useRef<WebSocket | null>(null);

  useEffect(() => {
    websocket.current = new WebSocket('/localhost:8080/chat');

    websocket.current.onopen = () => {
      const str = `${username}: 님이 입장하셨습니다.`;
      websocket.current?.send(str);
    };

    websocket.current.onclose = () => {
      const str = `${username}: 님이 방을 나가셨습니다.`;
      websocket.current?.send(str);
    };

    websocket.current.onmessage = (msg) => {
      const data = msg.data.split(':');
      const sessionId = data[0];
      const message = data[1];
      setMessages((prevMessages) => [
        ...prevMessages,
        { sessionId, message },
      ]);
    };

    return () => {
      websocket.current?.close();
    };
  }, []);

  const sendMessage = () => {
    const msg = `${username}:${message}`;
    websocket.current?.send(msg);
    setMessage('');
  };

  return (
    <div className="container mt-4">
      <div className="col-6">
        <label><b>채팅방</b></label>
      </div>
      <div>
        <div id="msgArea" className="col">
          {messages.map((msg, index) => (
            <div key={index} className="col-6">
              <div className={`alert ${msg.sessionId === username ? 'alert-secondary' : 'alert-warning'}`}>
                <b>{msg.sessionId} : {msg.message}</b>
              </div>
            </div>
          ))}
        </div>
        <div className="col-6">
          <div className="input-group mb-3">
            <input
              type="text"
              value={message}
              onChange={(e) => setMessage(e.target.value)}
              className="form-control"
              aria-label="Recipient's username"
              aria-describedby="button-addon2"
            />
            <div className="input-group-append">
              <button
                className="btn btn-outline-secondary"
                type="button"
                id="button-send"
                onClick={sendMessage}
              >
                전송
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Chat;