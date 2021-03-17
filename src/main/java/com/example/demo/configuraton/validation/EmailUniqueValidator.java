package com.example.demo.configuraton.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.demo.repository.AutorRepository;

public class EmailUniqueValidator implements ConstraintValidator<EmailUnique,String>{
	
	AutorRepository repo;
	
	public EmailUniqueValidator(AutorRepository repository) {
		this.repo = repository;
	}
	
	@Override
    public void initialize(EmailUnique email) {
    
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Integer test = repo.countByEmail(value);
		if(test>0) {
			return false;
		}
		return true;
	}

}
