/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.services;

import java.util.List;
import main.dto.PersonDTO;
import main.error.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;

/**
 *
 * @author Ricardo Morataya
 */
public interface PersonService {

    PersonDTO save(PersonDTO personDTO) throws DataIntegrityViolationException;

    PersonDTO get(String id) throws EntityNotFoundException;

    List<PersonDTO> list();

    PersonDTO update(String id, PersonDTO personDTO) throws EntityNotFoundException;

    PersonDTO delete(String id) throws EntityNotFoundException;

}
