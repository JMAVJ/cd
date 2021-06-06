package md.cd.events.validators;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import md.cd.events.models.Event;

@Component
public class EventValidator implements Validator {
    @Override
    public boolean supports(Class<?> c) {
        return Event.class.equals(c);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Event e = (Event) target;

        if (e.getDate().compareTo(new Date()) < 1) {
            errors.rejectValue("date", "ValidData");
        }
    }
}
