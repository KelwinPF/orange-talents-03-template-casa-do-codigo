package com.example.demo.configuraton.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.demo.dto.ClienteDTO;

public class IsCountryStateValidator implements ConstraintValidator<IsCountryState,ClienteDTO>{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
    public void initialize(IsCountryState is) {
	}

	@Override
	public boolean isValid(ClienteDTO dto, ConstraintValidatorContext context){
		Boolean is_empty = true;
		try {
			is_empty = manager.createNativeQuery(
				    " SELECT e.pais_id FROM estados as e WHERE e.id = "+ dto.getEstado().toString() +
				    " AND e.pais_id = " + dto.getPais().toString())
					.getResultList().isEmpty();
		}catch(Exception e) {}
		return !is_empty;
	}

}
