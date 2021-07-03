import React from 'react';

const RegisterForm = ({ user, setUser }) => {
  const handleOnChange = ({ target: { name, value } }) => {
    const newUser = { ...Object.assign(user, { [name]: value }) };
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
      </div>
      <div>
        <label htmlFor="lastName">Last Name</label>
        <input
          onChange={handleOnChange}
          type="text"
          name="lastName"
          id="lastName"
        />
      </div>
      <div>
        <label htmlFor="email">Email</label>
        <input onChange={handleOnChange} type="email" name="email" id="email" />
      </div>
      <div>
        <label htmlFor="password">Password</label>
        <input
          onChange={handleOnChange}
          type="password"
          name="password"
          id="password"
        />
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
