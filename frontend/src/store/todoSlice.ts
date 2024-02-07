// src/store/todoSlice.ts
import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { Todo } from "../types";

interface TodoState {
  todos: Todo[];
}

const initialState: TodoState = {
  todos: [
    { id: 1, text: "Learn React", completed: false },
    { id: 2, text: "Build a todo app", completed: false },
    { id: 3, text: "Learn TailwindCSS", completed: false },
  ],
};

const todoSlice = createSlice({
  name: "todos",
  initialState,
  reducers: {
    addTodo: (state, action: PayloadAction<Todo>) => {
      state.todos.push(action.payload);
    },
    deleteTodo: (state, action: PayloadAction<number>) => {
      state.todos = state.todos.filter((todo) => todo.id !== action.payload);
    },
    toggleTodo: (state, action: PayloadAction<number>) => {
      const todo = state.todos.find((todo) => todo.id === action.payload);
      if (todo) {
        todo.completed = !todo.completed;
      }
    },
  },
});

export const { addTodo, deleteTodo, toggleTodo } = todoSlice.actions;

export default todoSlice.reducer;
