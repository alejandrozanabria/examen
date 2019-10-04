package com.baufest.examen.dto;

import java.util.List;

public class Person {
    
    private Integer personId;
    private String name;
    private String lastName;
    private String personType;
    private List<Contract> contracts = null;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [personId=" + personId + ", name=" + name + ", lastName=" + lastName + ", personType="
                + personType + ", contracts=" + contracts + "]";
    }
    
    
    
}
