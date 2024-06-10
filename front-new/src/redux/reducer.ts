import { combineReducers } from "@reduxjs/toolkit";
import { persistReducer } from "redux-persist";
import createWebStorage from "redux-persist/lib/storage/createWebStorage";
import articleReducer from "@/app/component/articles/service/article.slice";
import userReducer from "@/app/component/users/service/user.slice";
import boardReducer from "@/app/component/boards/service/board.slice";
import adminReducer from "@/app/component/admins/service/admin.slice";
import transactionReducer from "@/app/component/transactions/service/transaction.slice";

const createNoopStorage = () => {
  return {
    getItem() {
      return Promise.resolve(null);
    },
    setItem(_key: string, value: number) {
      return Promise.resolve(value);
    },
    removeItem() {
      return Promise.resolve();
    },
  };
};

const storage =
  typeof window !== "undefined"
    ? createWebStorage("local")
    : createNoopStorage();


const articlePersistConfig = {
  key: "article",
  storage,
  whitelist: ["articleState"],
};
const userPersistConfig = {
  key: "user",
  storage,
  whitelist: ["userState"],
};
const boardPersistConfig = {
  key: "board",
  storage,
  whitelist: ["boardState"],
};

const adminPersistConfig = {
  key: "admin",
  storage,
  whitelist: ["adminState"],
};

const transactionPersistConfig = {
  key: "transaction",
  storage,
  whitelist: ["transactionState"],
};

const persistedArticleReducer = persistReducer(articlePersistConfig, articleReducer);
const persistedUserReducer = persistReducer(userPersistConfig, userReducer);
const persistedBoardReducer = persistReducer(boardPersistConfig, boardReducer);
const persistedAdminReducer = persistReducer(adminPersistConfig, adminReducer);
const persistedTransactionReducer = persistReducer(transactionPersistConfig, transactionReducer);

export const rootReducer = combineReducers({
  article: persistedArticleReducer,
  user: persistedUserReducer,
  board: persistedBoardReducer,
  admin: persistedAdminReducer,
  transaction: persistedTransactionReducer,
});