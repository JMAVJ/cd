import React from 'react';
import { capitalize } from '../utils';

const Data = ({ data }) => {
  return (
    <div>
      <h4>{data.name || data.title}</h4>
      <ul>
        {Object.keys(data)
          .splice(1, 4)
          .map((key) => (
            <li>
              {capitalize(key)}: {data[key]}
            </li>
          ))}
      </ul>
    </div>
  );
};

export default Data;
