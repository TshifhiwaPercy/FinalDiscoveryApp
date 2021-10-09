package za.ac.nwu.ac.translator.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.ac.domain.dto.AccountTransactionDetailsDto;
import za.ac.nwu.ac.domain.persistence.AccountTransactionDetails;
import za.ac.nwu.ac.repo.persistence.AccountTransactionDetailsRepository;
import za.ac.nwu.ac.translator.translator.AccountTransactionDetailsTranslator;
@Component
@Transactional
public class AccountTransactionDetailsTranslatorImpl implements AccountTransactionDetailsTranslator {
    private final AccountTransactionDetailsRepository repo;

    @Autowired
    public AccountTransactionDetailsTranslatorImpl(AccountTransactionDetailsRepository accountTransactionDetailsRepository){
        repo = accountTransactionDetailsRepository;
    }
    @Override
    public AccountTransactionDetails save(AccountTransactionDetails accountTransactionDetails){
        try{
            return repo.save(accountTransactionDetails);
        }
        catch(Exception ex){
            throw new RuntimeException("Unable to save to the DB",ex);
        }
    }
}
