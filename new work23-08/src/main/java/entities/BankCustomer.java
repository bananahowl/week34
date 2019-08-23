package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class BankCustomer implements Serializable {
    
    private String firstName;
    private String lastName;
    private String accountNumber;
    private double balance;
    private int customerRank;
    private String internalInfo;
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public BankCustomer() {
    }

    public BankCustomer(String firstName, String lastName, String accountNumber, double balance, int customerRank, String internalInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerRank = customerRank;
        this.internalInfo = internalInfo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCustomerRank() {
        return customerRank;
    }

    public void setCustomerRank(int customerRank) {
        this.customerRank = customerRank;
    }

    public String getInternalInfo() {
        return internalInfo;
    }

    public void setInternalInfo(String internalInfo) {
        this.internalInfo = internalInfo;
    }
    
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BankCustomer{" + "firstName=" + firstName + ", lastName=" + lastName + ", accountNumber=" + accountNumber + ", balance=" + balance + ", customerRank=" + customerRank + ", internalInfo=" + internalInfo + ", id=" + id + '}';
    }
    
    
}
