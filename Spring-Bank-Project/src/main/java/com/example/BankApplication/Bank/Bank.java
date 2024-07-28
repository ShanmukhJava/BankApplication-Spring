package com.example.BankApplication.Bank;

import jakarta.persistence.*;


import java.time.LocalDate;
@Entity
@Table
public class Bank {
    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            initialValue =  1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )
    private Long id;
    private String name;
    private String email;
    @Transient
    LocalDate registrationDate;
    Long phoneNumber;
    Long balance;

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Bank() {
    }
    public Bank(String name, String email, Long phoneNumber) {
        if (phoneNumber < 999999999L || phoneNumber > 10000000000L)throw new IllegalArgumentException("Invalid Number");
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        balance = 0L;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getRegistrationDate() {
        return LocalDate.now();
    }

    public Long getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", registrationDate=" + registrationDate +
                ", phoneNumber=" + phoneNumber +
                ", balance=" + balance +
                '}';
    }
}
