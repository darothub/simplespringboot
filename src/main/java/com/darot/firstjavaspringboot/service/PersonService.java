package com.darot.firstjavaspringboot.service;

import com.darot.firstjavaspringboot.dao.PersonDao;
import com.darot.firstjavaspringboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class PersonService {
    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    private final PersonDao personDao;
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPersons(){
        return personDao.selectAllPerson();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }
    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }
    public int update(UUID id, Person newPerson){
        return personDao.updatePersonById(id, newPerson);
    }
}
