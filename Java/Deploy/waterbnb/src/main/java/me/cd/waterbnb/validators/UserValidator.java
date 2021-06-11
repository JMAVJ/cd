package me.cd.waterbnb.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import me.cd.waterbnb.models.User;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports (Class<?> c) {
        return User.class.equals(c);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User u = (User) target;
        
        if (!u.getPasswordConfirmation().equals(u.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match");
        }
    }
}
