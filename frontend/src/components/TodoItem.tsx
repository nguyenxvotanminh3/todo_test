// src/components/TodoItem.tsx
import React from "react";
import { useDispatch } from "react-redux";
import { deleteTodo, toggleTodo } from "../store/todoSlice";
import { Todo } from "../types";

interface TodoItemProps {
  todo: Todo;
}

const TodoItem: React.FC<TodoItemProps> = ({ todo }) => {
  const dispatch = useDispatch();

  const handleDelete = () => {
    dispatch(deleteTodo(todo.id));
  };

  const handleToggle = () => {
    dispatch(toggleTodo(todo.id));
  };

  return (
    <div className="flex items-center justify-between py-2 px-4 border-b">
      <span
        className={`cursor-pointer ${todo.completed ? "line-through" : ""}`}
        onClick={handleToggle}
      >
        {todo.text}
      </span>
      <button
        className="text-red-500 hover:text-red-700"
        onClick={handleDelete}
      >
        X
      </button>
    </div>
  );
};

export default TodoItem;
