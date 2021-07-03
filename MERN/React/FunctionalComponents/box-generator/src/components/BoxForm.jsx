import React, { useState } from 'react';

const BoxForm = ({ boxes, setBoxes }) => {
  const [box, setBox] = useState({});

  const handleOnChange = ({ target: { name, value } }) => {
    const boxData = { ...Object.assign(box, { [name]: value }) };
    setBox(boxData);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setBoxes([...boxes, box]);
  };

  return (
    <form onSubmit={handleSubmit}>
      <label htmlFor="color">Color: </label>
      <input type="color" onChange={handleOnChange} name="color" id="color" />
      <label htmlFor="height">Height: </label>
      <input
        type="number"
        onChange={handleOnChange}
        name="height"
        id="height"
      />
      <label htmlFor="width">Width: </label>
      <input type="number" onChange={handleOnChange} name="width" id="width" />
      <input type="submit" value="Add" />
    </form>
  );
};

export default BoxForm;
