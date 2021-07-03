import React, { useState } from 'react';
import { Button, TextField } from '@material-ui/core';
import AddIcon from '@material-ui/icons/Add';

const TaskForm = ({ tasks, setTasks }) => {
  const [currentTask, setCurrentTask] = useState('');

  const examples = [
    'Code a to-do list',
    'Feed the dogs',
    'Drink tea',
    'Make noodles',
  ];

  const handleOnChange = ({ target: { value } }) => {
    setCurrentTask(value);
  };

  const handleOnClick = () => {
    if (currentTask.length < 1) {
      return;
    }
    const newTask = {
      task: currentTask,
      checked: false,
    };
    setTasks([...tasks, newTask]);
    setCurrentTask('');
  };

  const handleKeyDown = ({ key }) => {
    if (key === 'Enter') {
      handleOnClick();
    }
  };

  return (
    <div className="form-container">
      <TextField
        onChange={handleOnChange}
        onKeyDown={handleKeyDown}
        value={currentTask}
        label={`e.g ${examples[Math.floor(Math.random() * examples.length)]}`}
        InputLabelProps={{ className: 'input-label' }}
      />
      <Button onClick={handleOnClick} color="default">
        <AddIcon />
      </Button>
    </div>
  );
};

export default TaskForm;
