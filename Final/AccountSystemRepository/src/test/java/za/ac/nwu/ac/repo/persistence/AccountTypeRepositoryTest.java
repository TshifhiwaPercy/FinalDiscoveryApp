package za.ac.nwu.ac.repo.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.config.RepositoryConfigTest;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {RepositoryConfigTest.class})
@Ignore
public class AccountTypeRepositoryTest {

    @Autowired
    AccountTypeRepository repository;
    @Before
    public void setUp() throws Exception {
        // What happens before each test
    }
    @After
    public void tearDown() throws Exception {
        // What happens after each test
    }
    @Test
    public void getAccountTypeByMnemonicNativeQueryMiles() {
        // Write a test here
        AccountType miles = repository.getAccountTypeByMnemonicNativeQuery("MILES");
        Assertions.assertNotNull(miles);
        Assertions.assertEquals("MILES",miles.getMnemonic());
    }
    @Test
    public void getAccountTypeByMnemonicNativeQuery() {
        // Write a test here
        AccountType miles = repository.getAccountTypeByMnemonicNativeQuery("MILESS");
        Assertions.assertNotNull(miles);
        //Assertions.assertEquals("MILES",miles.getMnemonic());
    }
    @Test
    public void getAccountTypeByMnemonicMiles() {
        // Write a test here
        AccountType miles = repository.getAccountTypeByMnemonicNativeQuery("MILES");
        Assertions.assertNotNull(miles);
        Assertions.assertEquals("MILES",miles.getMnemonic());
    }
    @Test
    public void getAccountTypeByMnemonicPlay() {
        // Write a test here
        AccountType miles = repository.getAccountTypeByMnemonicNativeQuery("PLAY");
        Assertions.assertNotNull(miles);
        Assertions.assertEquals("PLAY",miles.getMnemonic());
    }
    @Test
    public void getAccountTypeDtoByMnemonicMiles() {
        // Write a test here
        AccountType miles = repository.getAccountTypeByMnemonicNativeQuery("MILES");
        Assertions.assertNotNull(miles);
        //Assertions.assertEquals("MILES",miles.getMnemonic());
    }
}