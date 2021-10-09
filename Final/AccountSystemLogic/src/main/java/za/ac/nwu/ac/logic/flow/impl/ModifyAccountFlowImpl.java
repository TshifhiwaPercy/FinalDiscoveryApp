package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.ModifyAccountTypeFlow;

import java.time.LocalDate;

@Component
@Transactional
public class ModifyAccountFlowImpl implements ModifyAccountTypeFlow {

    @Override
    public AccountTypeDto deleteAccountType(String mnemonic)
    {
        return null;
    }
    @Override
   public AccountTypeDto updateAccountType(String mnemonic, String newAccountTypeName, LocalDate newCreationDate){
        return null;
    }

}
