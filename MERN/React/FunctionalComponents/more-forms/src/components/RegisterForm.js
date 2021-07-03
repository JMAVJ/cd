import React, { useState } from 'react';
import validateForm from '../utils/validateForm';

const RegisterForm = ({ user, setUser }) => {
  const [errors, setErrors] = useState();

  const handleOnChange = ({ target: { name, value } }) => {
    const newUser = { ...Object.assign(user, { [name]: value }) };
    setErrors(validateForm(newUser));
    setUser(newUser);
  };

  return (
    <form>
      <div>
        <label htmlFor="firstName">First Name</label>
        <input
          onChange={handleOnChange}
          type="text"
          name="firstName"
          id="firstName"
        />
        {errors ? errors.firstName : ''}
      </div>
      <div>
        <label htmlFor="lastName">Last Name</label>
        <input
          onChange={handleOnChange}
          type="text"
          name="lastName"
          id="lastName"
        />
        {errors ? errors.lastName : ''}
      </div>
      <div>
        <label htmlFor="email">Email</label>
        <input onChange={handleOnChange} type="email" name="email" id="email" />
        {errors ? errors.email : ''}
      </div>
      <div>
        <label htmlFor="password">Password</label>
        <input
          onChange={handleOnChange}
          type="password"
          name="password"
          id="password"
        />
        {errors ? errors.password : ''}
      </div>
      <div>
        <label htmlFor="passwordConfirmation">Confirm Password</label>
        <input
          onChange={handleOnChange}
          type="password"
          name="passwordConfirmation"
          id="passwordConfirmation"
        />
      </div>
    </form>
  );
};

export default RegisterForm;
