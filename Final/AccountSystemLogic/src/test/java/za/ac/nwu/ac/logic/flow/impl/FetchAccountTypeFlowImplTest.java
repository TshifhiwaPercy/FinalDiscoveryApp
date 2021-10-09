package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FetchAccountTypeFlowImplTest {
    FetchAccountTypeFlowImpl classTest;
    @Before
    public void setUp() throws Exception {
        classTest = new FetchAccountTypeFlowImpl(null);
    }

    @After
    public void tearDown() throws Exception {
        classTest=null;
    }

    @Test
    public void methodTest() {
        assertTrue(classTest.methodTest());
    }
}