// src/components/TodoList.tsx
import React from "react";
import { useSelector } from "react-redux";
import { RootState } from "../store/store";
import TodoItem from "./TodoItem";

const TodoList: React.FC = () => {
  const todos = useSelector((state: RootState) => state.todos.todos);

  return (
    <div className="mt-4">
      {todos.map((todo) => (
        <TodoItem key={todo.id} todo={todo} />
      ))}
    </div>
  );
};

export default TodoList;
