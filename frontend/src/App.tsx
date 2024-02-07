// src/App.js
import React, { useState } from "react";
import TodoList from "./components/TodoList";
import AddTodo from "./components/AddTodo";

function App() {
  const [todos, setTodos] = useState([
    { id: 1, text: "Learn React", completed: false },
    { id: 2, text: "Build a todo app", completed: false },
    { id: 3, text: "Learn TailwindCSS", completed: false },
  ]);

  const handleAddTodo = (text: string) => {
    const newTodo = {
      id: todos.length + 1,
      text,
      completed: false,
    };
    setTodos([...todos, newTodo]);
  };

  const handleDeleteTodo = (id: number) => {
    setTodos(todos.filter((todo) => todo.id !== id));
  };

  const handleToggleTodo = (id: number) => {
    setTodos(
      todos.map((todo) =>
        todo.id === id ? { ...todo, completed: !todo.completed } : todo
      )
    );
  };

  return (
    <section
      style={{ background: `linear-gradient(90deg, #00d2ff 0%, #3a47d5 100%)` }}
      className="h-screen items-center justify-center flex"
    >
      <div className="p-10 w-1/3 bg-white rounded">
        <h1 className="text-3xl font-bold mb-4">Todo List</h1>
        <AddTodo />
        <TodoList />
      </div>
    </section>
  );
}

export default App;
