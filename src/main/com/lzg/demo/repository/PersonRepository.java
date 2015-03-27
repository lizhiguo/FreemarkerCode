package com.lzg.Demo.repository.impl;

import org.apache.deltaspike.data.api.Repository;

import com.lzg.Demo.model.Person;
import com.lhl.fw.impl.repository.BaseRepository;

@Repository(forEntity = Person.class)
public abstract class PersonRepository extends BaseRepository<Person, String> implements IPersonRepository{

}