import React from 'react';
import { useRouter } from 'next/router';

interface LinkButtonProps {
  id: string;
  title: string;
  path: string;
}

const LinkButton: React.FC<LinkButtonProps> = ({ id, title, path }) => {
  const router = useRouter();

  return (
    <li>
      <button
        id={id}
        onClick={() => router.push(path)}
        className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white"
      >
        {title}
      </button>
    </li>
  );
};

export default LinkButton;