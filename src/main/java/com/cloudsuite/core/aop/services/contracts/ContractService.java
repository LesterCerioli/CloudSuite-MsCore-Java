package com.cloudsuite.core.app.services.contracts;

public interface ContractService {
    void recordAccountCreation(String accountId, double initialBalance);

    void recordPayment(String fromAccount, String toAccount, double amount);

}