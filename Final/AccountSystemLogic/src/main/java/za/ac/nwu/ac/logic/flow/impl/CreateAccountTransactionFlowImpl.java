package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountTransactionDetails;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.translator.translator.AccountTransactionDetailsTranslator;
import za.ac.nwu.ac.translator.translator.AccountTransactionTranslator;
@Transactional
@Component
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow{
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTransactionFlowImpl.class);

    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final AccountTransactionDetailsTranslator accountTransactionDetailsTranslator;
    private final AccountTransactionTranslator accountTransactionTranslator;
    @Autowired
    public CreateAccountTransactionFlowImpl(FetchAccountTypeFlow fetchAccountTypeFlow, AccountTransactionTranslator accountTransactionTranslator, AccountTransactionDetailsTranslator accountTransactionDetailsTranslator){
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.accountTransactionDetailsTranslator = accountTransactionDetailsTranslator;
        this.accountTransactionTranslator = accountTransactionTranslator;
    }
    @Override
    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto){
        if(LOGGER.isInfoEnabled()){
            String outputForLogging = "null";
            if(null!=accountTransactionDto&& (null!=accountTransactionDto.getDetails())){
                outputForLogging = accountTransactionDto.getDetails().toString();
            }
            LOGGER.info("The input object was {} and the Details is {}", accountTransactionDto,outputForLogging);

        }
        accountTransactionDto.setTransactionId(null);

        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountTransactionDto.getAccountTypeMnemonic());

        //AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountTransactionDto.getAccountTypeMnemonic());
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Got AccountType for {} adn the AccountTypeID is {}",accountTransactionDto.getAccountTypeMnemonic(),accountType.getAccountTypeId());
        }

        AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType);
        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);
        if(null!=accountTransactionDto.getDetails()){
            AccountTransactionDetails accountTransactionDetails = accountTransactionDto.getDetails().buildAccountTransactionDetails(createdAccountTransaction);
            accountTransactionDetailsTranslator.save(accountTransactionDetails);
        }
        AccountTransactionDto results = new AccountTransactionDto(createdAccountTransaction);
        LOGGER.info("The input object was {}",results);
        return new AccountTransactionDto(createdAccountTransaction);
    }
}
