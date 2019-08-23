/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Employee;

/**
 *
 * @author ahmed
 */
public class EmployeeDTO {
    
    private int id;
    private String name;
    private String address;

    public EmployeeDTO(Employee emp) {
        this.id = emp.getId().intValue();
        this.name = emp.getName();
        this.address = emp.getAddress();
    }

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
    
    
}
