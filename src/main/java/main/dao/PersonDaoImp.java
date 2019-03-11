/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import main.error.EntityNotFoundException;
import main.models.Person;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ricardo Morataya
 */
@Repository
public class PersonDaoImp implements PersonDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Person save(Person person) throws DataIntegrityViolationException {
        entityManager.persist(person);
        return person;
    }

    @Override
    public Person get(String id) throws EntityNotFoundException{
        Person person = entityManager.find(Person.class, id);
        if(person == null){
            throw new EntityNotFoundException(Person.class, "id", id);
        }
        return person;
    }

    @Override
    public List<Person> list() {
        List<Person> persons = entityManager.createQuery("FROM Person", Person.class).getResultList();
        return persons;
    }

    @Override
    @Transactional
    public Person update(String id, Person personRequest) throws EntityNotFoundException{
        Person person = this.get(id);
        person.setName(personRequest.getName());
        person.setLastName(personRequest.getLastName());
        person.setAge(personRequest.getAge());
        entityManager.merge(person);
        return person;
    }

    @Override
    @Transactional
    public Person delete(String id) throws EntityNotFoundException{
        Person person = this.get(id);
        entityManager.remove(person);
        return person;
    }

}
