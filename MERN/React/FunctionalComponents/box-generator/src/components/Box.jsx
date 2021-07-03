import React from 'react';

const Box = ({ color = '#000000', width = 10, height = 10 }) => {
  const boxStyle = {
    backgroundColor: color,
    width: `${width}rem`,
    height: `${height}rem`,
    marginBottom: '1rem',
  };

  return <div style={boxStyle}></div>;
};

export default Box;
