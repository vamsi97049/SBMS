package i.vk.configurations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Configuration;

import jakarta.validation.Constraint;

@Configuration
@Constraint(validatedBy = MultipleOfTenValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MultipleOfTen {
	String message() default "Value should be multiple of 10";
	Class<?>[] groups() default {};
    Class<?>[] payload() default {}; 
}
