/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Ricardo Morataya
 */

@Entity
@ApiModel("Persona")
public class Person {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @ApiModelProperty(value = "EL ID de la persona", notes = "Es obligatoria por que la persona necesita un ID", required = true)
    private String id;

    @Column(name = "first_name", nullable = false)
    @ApiModelProperty(value = "EL nombre de la persona", notes = "Es obligatoria por que la persona necesita un nombre", required = true)
    private String name;

    @Column(name = "last_name", nullable = false)
    @ApiModelProperty(value = "El apellido de la persona", notes = "Es obligatoria prque la persona necesita un apellido", required = true)
    private String lastName;

    @Column(name = "age", nullable = false)
    @ApiModelProperty(value = "La edad de la persona", notes = "Es obligatoria por que la persona necesita una edad", required = true)
    private int age;

    public Person(String id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
