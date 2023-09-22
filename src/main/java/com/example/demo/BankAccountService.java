package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public BankAccount createBankAccount(BankAccount bankAccount) {
        // Implement logic for creating a bank account (e.g., setting createdDate)
        return bankAccountRepository.save(bankAccount);
    }

    public Iterable<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    public Optional<BankAccount> getBankAccountById(Long accountId) {
        return bankAccountRepository.findById(accountId);
    }
    public boolean deleteBankAccount(Long accountId) {
        Optional<BankAccount> existingAccount = bankAccountRepository.findById(accountId);
        if (existingAccount.isPresent()) {
            bankAccountRepository.deleteById(accountId);
            return true;
        } else {
            return false;
        }

    }
}