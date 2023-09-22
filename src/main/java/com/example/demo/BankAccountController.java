package com.example.demo;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {
	@Autowired
    private BankAccountService bankAccountService;

    @PostMapping
    public void createBankAccount(@Valid@RequestBody BankAccount bankAccount) {
        BankAccount createdAccount = bankAccountService.createBankAccount(bankAccount);
        System.out.println("Account created" +" " + bankAccount.getOwnerName());
    }

    @GetMapping
    public Iterable<BankAccount> getAllBankAccounts() {
        return (Iterable<BankAccount>) bankAccountService.getAllBankAccounts();
        
    }

	@GetMapping("/{accountId}")
    public ResponseEntity<BankAccount> getBankAccountById(@PathVariable Long accountId) {
        Optional<BankAccount> account = bankAccountService.getBankAccountById(accountId);

        if (account.isPresent()) {
            return new ResponseEntity<>(account.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

        @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteBankAccount(@PathVariable Long accountId) {
        boolean deleted = bankAccountService.deleteBankAccount(accountId);
        System.out.println("Account deleted" +" "+accountId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
