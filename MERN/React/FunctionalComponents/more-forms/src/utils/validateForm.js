const validateForm = (input) => {
  let errors = {};
  if (input.firstName && input.firstName.length < 2) {
    errors.firstName = 'The first name must be at least 2 characters long';
  }
  if (input.lastName && input.lastName.length < 2) {
    errors.lastName = 'The last name must be at least 2 characters long';
  }
  if (input.email && input.email.length < 5) {
    errors.email = 'The email must be at least 5 characters long';
  }
  if (input.password && input.password.length < 8) {
    errors.password = 'The password must be at least 8 characters long';
  }
  if (input.password && input.password !== input.passwordConfirmation) {
    errors.password = 'The password must be the same as the confirmation';
  }
  return errors;
};

export default validateForm;
