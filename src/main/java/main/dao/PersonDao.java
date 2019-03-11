/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.dao;

import java.util.List;
import main.error.EntityNotFoundException;
import main.models.Person;
import org.springframework.dao.DataIntegrityViolationException;

/**
 *
 * @author Ricardo Morataya
 */

public interface PersonDao {

    Person save(Person person) throws DataIntegrityViolationException;

    Person get(String id) throws EntityNotFoundException;

    List<Person> list();

    Person update(String id, Person person) throws EntityNotFoundException;

    Person delete(String id) throws EntityNotFoundException;

}
