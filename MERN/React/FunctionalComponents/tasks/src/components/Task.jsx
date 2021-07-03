import { Button } from '@material-ui/core';
import ButtonGroup from '@material-ui/core/ButtonGroup';
import CheckIcon from '@material-ui/icons/Check';
import CloseIcon from '@material-ui/icons/Close';

const Task = ({ task: { task, checked }, tasks, index, setTasks }) => {
  const checkTask = () => {
    const checkedTask = {
      task,
      checked: true,
    };
    let updatedTasks = tasks;
    updatedTasks[index] = checkedTask;
    setTasks([...updatedTasks]);
  };

  const deleteTask = () => {
    const newTasks = tasks.filter((t) => t.task !== task);
    setTasks(newTasks);
  };

  return (
    <div className="card">
      <h4>{checked ? <s>{task}</s> : task}</h4>
      <ButtonGroup>
        <Button onClick={checkTask} disabled={checked}>
          <CheckIcon />
        </Button>
        <Button onClick={deleteTask}>
          <CloseIcon />
        </Button>
      </ButtonGroup>
    </div>
  );
};

export default Task;
