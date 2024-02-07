// src/components/AddTodo.tsx
import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { addTodo } from "../store/todoSlice";

const AddTodo: React.FC = () => {
  const [text, setText] = useState("");
  const dispatch = useDispatch();

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setText(e.target.value);
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (!text.trim()) return;
    dispatch(
      addTodo({
        id: Date.now(),
        text,
        completed: false,
      })
    );
    setText("");
  };

  return (
    <form onSubmit={handleSubmit} className="mt-4">
      <input
        type="text"
        value={text}
        onChange={handleChange}
        placeholder="Add new todo"
        className="py-2 px-4 border"
      />
      <button type="submit" className="ml-2 py-2 px-4 bg-blue-500 text-white">
        Add
      </button>
    </form>
  );
};

export default AddTodo;
