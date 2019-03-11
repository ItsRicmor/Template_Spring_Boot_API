package main.dto;


import main.models.Person;

public class ApiDTOBuilder {
	public static PersonDTO personToPersonDTO(Person person) {
		return new PersonDTO(person.getId(), person.getName(), person.getLastName(), person.getAge());
	}
	public static Person personDTOToPerson(PersonDTO personDTO) {
		return new Person(personDTO.getId(), personDTO.getName(), personDTO.getLastName(), personDTO.getAge());
	}
}
