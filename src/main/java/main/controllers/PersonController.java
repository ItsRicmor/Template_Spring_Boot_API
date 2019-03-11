package main.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.persistence.NoResultException;
import main.dto.PersonDTO;
import main.error.EntityNotFoundException;
import main.models.Person;
import main.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ricardo Morataya
 */
@RestController
@CrossOrigin
@Api(value = "Person Controller")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    @ApiOperation(value = "Crea una persona", response = ResponseEntity.class, notes = "Retorna la person añadida")
    public ResponseEntity<PersonDTO> savePerson(
            @ApiParam(value = "Un objeto Person tipo Json", required = true) @RequestBody PersonDTO personDTO)
            throws DataIntegrityViolationException {
        
        PersonDTO personDTOResponse = personService.save(personDTO);
        return ResponseEntity.ok().body(personDTOResponse);
    }

    @GetMapping("/person/{id}")
    @ApiOperation(value = "Busca una persona", response = Person.class, notes = "Retorna una persona por ID")
    public ResponseEntity<PersonDTO> getPerson(@ApiParam(value = "El ID de la persona a buscar", required = true) @PathVariable("id") String id)
            throws EntityNotFoundException {

        try {
            PersonDTO personDTOResponse = personService.get(id);
            return ResponseEntity.ok().body(personDTOResponse);
        } catch (NoResultException e) {

        }
        return null;
    }

    @GetMapping("/person")
    @ApiOperation(value = "Busca todas personas", response = List.class, notes = "Retorna una lista de objetos Person")
    public ResponseEntity<List<PersonDTO>> listPerson() {
        List<PersonDTO> personsDTOResponse = personService.list();
        return ResponseEntity.ok().body(personsDTOResponse);
    }

    @PutMapping("/person/{id}")
    @ApiOperation(value = "Actualiza una persona", response = ResponseEntity.class, notes = "Restorna la persona actualizada")
    @ApiResponses({
        @ApiResponse(code = 500, message = "The person does not exist")})
    public ResponseEntity<PersonDTO> updatePerson(@ApiParam(value = "El ID de la persona a actualizar", required = true) @PathVariable("id") String id,
            @ApiParam(value = "Un objeto Person tipo Json", required = true) @RequestBody PersonDTO personDTO)
            throws EntityNotFoundException {

        PersonDTO personDTOUpdatedResponse = personService.update(id, personDTO);
        return ResponseEntity.ok().body(personDTOUpdatedResponse);
    }

    @DeleteMapping("/person/{id}")
    @ApiOperation(value = "Elimina una persona", response = ResponseEntity.class, notes = "Retorna una respuesta OK")
    @ApiResponses({
        @ApiResponse(code = 500, message = "The person does not exist")})
    public ResponseEntity<PersonDTO> deletePerson(
            @ApiParam(value = "El ID de la persona a eliminar", required = true) @PathVariable("id") String id)
            throws EntityNotFoundException {

        PersonDTO personDTODeletedResponse = personService.delete(id);
        return ResponseEntity.ok().body(personDTODeletedResponse);
    }
}
