package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.translator.translator.AccountTypeTranslator;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component("createAccountTypeFlowName")
@Transactional
public class CreateAccountTypeFlowImpl implements CreateAccountTypeFlow {
    private final AccountTypeTranslator accountTypeTranslator;
    @Autowired
    public CreateAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator = accountTypeTranslator;
    }
    @Override
    public AccountTypeDto create(AccountTypeDto accountType){
        if(null == accountType.getCreationDate()){
            accountType.setCreationDate(LocalDate.now());
        }
        accountTypeTranslator.someMethod();
        return accountTypeTranslator.create(accountType);
    }
}
