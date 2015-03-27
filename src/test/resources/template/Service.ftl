package com.lzg.${project}.service.impl;

import java.io.Serializable;

import javax.inject.Inject;

import com.lzg.${project}.model.${Name};
import com.lhl.${project}.repo.I${Name}Repository;
import com.lhl.fw.api.repository.IBaseRepository;

import com.lhl.fw.impl.service.BaseService;

public class I${Name}Service extends BaseService<${Name}, ${Type}> implements I${Name}Service,Serializable {
 
   private static final long serialVersionUID = 1L;
   @Inject
   private I${Name}Repository ${className}Repository;
   
    @Override
	protected IBaseRepository<${Name}, ${Type}> getBaseRepository() {
		return ${className}Repository;
	}
}