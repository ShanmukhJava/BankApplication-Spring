package com.example.BankApplication.Bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Bank")
public class BankController {
    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }
    @GetMapping
    public String Welcome() {
        return "Welcome user.";
    }

    @GetMapping(path = "/accounts")
    public List<Bank> totalAccounts() {
        return bankService.getAccounts();
    }
    @PostMapping(path = "/accounts/add")
    public void addAccount(@RequestBody Bank account) {
        bankService.addAccountService(account);
    }

    @PutMapping(path = "{bankId}/update")
    public void updateAccount(@PathVariable("bankId") Long id,
                              @RequestParam(required = false) String email,
                              @RequestParam(required = false) Long phoneNumber) {
        bankService.updateEmailAndPhoneNumber(id, email, phoneNumber);
    }
    @PutMapping(path = "{bankId}/add-money")
    public void addMoneyToAccount(@PathVariable("bankId") Long id,
                                  @RequestParam(required = true) Long money) {
        bankService.addMoney(id, money);
    }

    @PutMapping(path = "{bankId}/withdraw")
    public void withdrawFromAccount(@PathVariable("bankId") Long id,
                                  @RequestParam(required = true) Long money) {
        bankService.withdrawMoney(id, money);
    }
}
