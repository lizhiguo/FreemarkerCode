package com.lzg.${project}.repository.impl;

import org.apache.deltaspike.data.api.Repository;

import com.lzg.${project}.model.${Name};
import com.lhl.fw.impl.repository.BaseRepository;

@Repository(forEntity = ${Name}.class)
public abstract class ${Name}Repository extends BaseRepository<${Name}, ${Type}> implements I${Name}Repository{

}