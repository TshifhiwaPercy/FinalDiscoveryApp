package za.ac.nwu.ac.translator.translator;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.util.List;

public interface AccountTypeTranslator {
    List<AccountTypeDto> getAllAccountTypes();
    AccountTypeDto create(AccountTypeDto accountTypeDto);
    AccountTypeDto save(AccountType accountType);
    AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic);
    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);
    AccountType getAccountTypeDbEntityByMnemonic(String mnemonic);
    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);
    void delete(AccountType accountType);
    void someMethod();

}
