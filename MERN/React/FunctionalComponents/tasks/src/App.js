import { useState, useEffect } from 'react';
import './App.css';
import TaskForm from './components/TaskForm';
import Task from './components/Task';

function App() {
  const [tasks, setTasks] = useState(
    JSON.parse(localStorage.getItem('tasks')) || []
  );

  useEffect(() => {
    localStorage.setItem('tasks', JSON.stringify(tasks));
  }, [tasks]);

  return (
    <div className="App">
      <h1>To-Do</h1>
      <TaskForm tasks={tasks} setTasks={setTasks} />
      <div className="tasks-container">
        {tasks.map((task, index) => (
          <Task
            key={index}
            index={index}
            task={task}
            tasks={tasks}
            setTasks={setTasks}
          />
        ))}
      </div>
    </div>
  );
}

export default App;
