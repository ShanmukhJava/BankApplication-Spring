package com.example.BankApplication.Bank;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BankService {
    private final BankRepository bankRepository;
    @Autowired
    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }
    public List<Bank> getAccounts() {
        return bankRepository.findAll();
    }

    public void addAccountService(Bank bank) {
        Optional<Bank> optionalEmail = bankRepository.findByEmail(bank.getEmail());
        Optional<Bank> optionalPhoneNumber = bankRepository.findByPhoneNumber(bank.getPhoneNumber());
        if (optionalEmail.isPresent() || optionalPhoneNumber.isPresent()) {
            throw new IllegalArgumentException("Email or phone number already exists.");
        } else {
            if (bank.getPhoneNumber() < 999999999L || bank.getPhoneNumber() > 10000000000L)
                throw new IllegalArgumentException("Invalid Number");
            bank.setBalance(0L);
            bankRepository.save(bank);
        }
    }

    @Transactional
    public void updateEmailAndPhoneNumber(Long id, String email, Long phoneNumber) {
        Optional<Bank> optionalBankUsingId = bankRepository.findById(id);
        Bank bankAccount;
        if (optionalBankUsingId.isPresent()) {
            bankAccount = optionalBankUsingId.get();
        } else {
            throw new NoSuchElementException("id : " + id + ". does not exist.");
        }

        if (email != null && email.length() > 0 && !Objects.equals(bankAccount.getEmail(), email)) {
            Optional<Bank> optionalBankUsingEmail = bankRepository.findByEmail(email);
            if (!optionalBankUsingEmail.isPresent()) {
                bankAccount.setEmail(email);
            } else {
                throw new IllegalArgumentException(email + " is already taken.");
            }
        }

        if (phoneNumber != null && phoneNumber > 999999999 && phoneNumber < 99999999999L && !Objects.equals(bankAccount.phoneNumber, phoneNumber)) {
            Optional<Bank> optionalBankUsingPhoneNumber = bankRepository.findByPhoneNumber(phoneNumber);
            if (!optionalBankUsingPhoneNumber.isPresent()) {
                bankAccount.setPhoneNumber(phoneNumber);
            } else {
                throw new IllegalArgumentException(phoneNumber + " is already taken");
            }

        }
    }

    @Transactional
    public void addMoney(Long id, Long money) {
        if (money <= 0)throw new IllegalArgumentException("Money to add must be more than 0.");
        Optional<Bank> optionalIdCheck = bankRepository.findById(id);
        Bank bankAccount;
        if (!optionalIdCheck.isPresent()) {
            throw new NoSuchElementException("No such account exists with " + id + " id");
        } else {
            bankAccount = optionalIdCheck.get();
        }
        bankAccount.setBalance(bankAccount.getBalance() + money);
    }
    @Transactional
    public void withdrawMoney(Long id, Long money) {
        if (money <= 0)throw new IllegalArgumentException("Money to withdraw must be more than 0");
        Optional<Bank> optionalIdCheck = bankRepository.findById(id);
        Bank bankAccount;
        if (!optionalIdCheck.isPresent()) {
            throw new NoSuchElementException("No such account exists with " + id + " id");
        } else {
            bankAccount = optionalIdCheck.get();
        }
        if (!(bankAccount.getBalance() > money)) {
            throw new IllegalArgumentException("Invalid transaction your account has " + bankAccount.getBalance() + "Rs and you want to withdraw " + money + "Rs. ");
        } else {
            bankAccount.setBalance(bankAccount.getBalance() - money);
        }
    }
}
