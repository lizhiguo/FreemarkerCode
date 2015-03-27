package com.lhl.${project}.service.impl;

import java.io.Serializable;

import javax.inject.Inject;

import org.apache.deltaspike.jpa.api.transaction.Transactional;

import com.lhl.${project}.model.${Name};
import com.lhl.fw.api.service.IBaseService;

@Transactional
public abstract class ${Name}Service extends BaseService<${Name}, ${Type}> implements I${Name}Service,Serializable{

    private static final long serialVersionUID = 1L;
    
    @Inject
	private I${Name}Repository repository;
	
    @Override
	protected IBaseRepository<${Name}, ${Type}> getBaseRepository() {
		return repository;
	}
}