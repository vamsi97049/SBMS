package i.vk.configurations;

import org.springframework.context.annotation.Configuration;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Configuration
public class MultipleOfTenValidator implements ConstraintValidator<MultipleOfTen, Integer> {
@Override
public boolean isValid(Integer value, ConstraintValidatorContext context) {
	if(value==null) {
		return true;
	}
	return value % 10 == 0;
}
}
