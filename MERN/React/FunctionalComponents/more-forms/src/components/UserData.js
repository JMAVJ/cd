import React from 'react';

const UserData = ({
  firstName,
  lastName,
  email,
  password,
  passwordConfirmation,
}) => {
  return (
    <div>
      <p>First Name: {firstName}</p>
      <p>Last Name: {lastName}</p>
      <p>Email: {email}</p>
      <p>Password: {password}</p>
      <p>Password Confirmation: {passwordConfirmation}</p>
    </div>
  );
};

export default UserData;
