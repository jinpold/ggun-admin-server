import React from 'react';
import HomeIcon from '@mui/icons-material/Home'; // ensure you have @mui/icons-material installed
import { useRouter } from 'next/router';
import LinkButton from '@/app/atoms/button/LinkButton';
import Chat from '@/app/component/chats/modul/chat';
import ChatLinkButton from '@/app/atoms/button/ChatLinkButton';

interface HeaderWithChatProps {
  showProfile: boolean;
  linkButtonTitles: { id: string, title: string, path: string }[];
  logoutHandler: () => void;
}

const HeaderWithChat: React.FC<HeaderWithChatProps> = ({ showProfile, linkButtonTitles, logoutHandler }) => {
  const router = useRouter();

  return (
    <nav className="bg-white border-gray-200 dark:bg-gray-900">
      <div className="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
        <HomeIcon fontSize="large" onClick={() => router.push(`/`)} />
        <div className="flex items-center md:order-2 space-x-3 md:space-x-0 rtl:space-x-reverse">
          {showProfile ? (
            <button
              type="button"
              className="flex text-sm bg-gray-800 rounded-full md:me-0 focus:ring-4 focus:ring-gray-300 dark:focus:ring-gray-600"
              id="user-menu-button"
              aria-expanded="false"
              data-dropdown-toggle="user-dropdown"
              data-dropdown-placement="bottom"
            >
              <span className="sr-only">Open user menu</span>
              <img
                className="w-20 h-20 rounded-full"
                src="/img/user/profile.jpg"
                data-popover-target="profile-menu"
                onClick={() => router.push(`/`)}
              />
            </button>
          ) : (
            <button
              type="button"
              onClick={() => router.push(`/pages/users/login`)}
              className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white"
            >
              Login
            </button>
          )}

          {showProfile && (
            <div className="px-4 py-3 visible float-end">
              <ul className="py-2" aria-labelledby="user-menu-button">
                <li>
                  <span
                    onClick={logoutHandler}
                    className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white"
                  >
                    Logout
                  </span>
                </li>
              </ul>
            </div>
          )}
        </div>
        <div
          className="items-center justify-between hidden w-full md:flex md:w-auto md:order-1"
          id="navbar-user"
        >
          <ul className="flex flex-col font-medium p-4 md:p-0 mt-4 border border-gray-100 rounded-lg bg-gray-50 md:space-x-8 rtl:space-x-reverse md:flex-row md:mt-0 md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700">
            {showProfile &&
              linkButtonTitles.map((elem) => (
                <li key={elem.id}>
                  <ChatLinkButton id={elem.id} title={elem.title} path={elem.path} />
                </li>
              ))}
          </ul>
        </div>
      </div>
      <Chat />
    </nav>
  );
};

export default HeaderWithChat;