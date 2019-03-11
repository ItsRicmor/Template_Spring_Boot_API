/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.services;

import java.util.ArrayList;
import java.util.List;
import main.dao.PersonDao;
import main.dto.ApiDTOBuilder;
import main.dto.PersonDTO;
import main.error.EntityNotFoundException;
import main.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ricardo Morataya
 */
@Service
@Transactional(readOnly = true)
public class PersonServiceImp implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    @Transactional
    public PersonDTO save(PersonDTO personDTO) throws DataIntegrityViolationException{
        Person person = personDao.save(ApiDTOBuilder.personDTOToPerson(personDTO));
        return ApiDTOBuilder.personToPersonDTO(person);
    }

    @Override
    public PersonDTO get(String id) throws EntityNotFoundException {
        Person person = personDao.get(id);
        return ApiDTOBuilder.personToPersonDTO(person);
    }

    @Override
    public List<PersonDTO> list() {
        List<Person> persons = personDao.list();
        List<PersonDTO> personsDTO =  new ArrayList<>();
        persons.stream().forEach(person -> {
            PersonDTO personDTO =  ApiDTOBuilder.personToPersonDTO(person);
            personsDTO.add(personDTO);
        });
        return personsDTO;
    }

    @Override
    @Transactional
    public PersonDTO update(String id, PersonDTO personDTO) throws EntityNotFoundException{
        Person person = personDao.update(id, ApiDTOBuilder.personDTOToPerson(personDTO));
        return ApiDTOBuilder.personToPersonDTO(person);
    }

    @Override
    @Transactional
    public PersonDTO delete(String id) throws EntityNotFoundException{
        Person person = personDao.delete(id);
        return ApiDTOBuilder.personToPersonDTO(person);
    }

}
