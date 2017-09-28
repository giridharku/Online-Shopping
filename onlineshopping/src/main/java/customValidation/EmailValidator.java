package customValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    @Override
    public void initialize(ValidEmail arg0) {

    }

    @Override
    public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
	return arg0.length() > 5;
    }

}
