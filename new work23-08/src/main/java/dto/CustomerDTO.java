/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.BankCustomer;

/**
 *
 * @author ahmed
 */
public class CustomerDTO {
    
    private int customerID;
    private String fullName;
    private String accountNumber;
    private double balance;

    public CustomerDTO(BankCustomer bankCustomer) {
        this.customerID = bankCustomer.getId().intValue();  //customerID;
        this.fullName = bankCustomer.getFirstName() + " " + bankCustomer.getLastName();//fullName;
        this.accountNumber = bankCustomer.getAccountNumber();//accountNumber;
        this.balance = bankCustomer.getBalance();//balance;
    }
    
    
    
}
