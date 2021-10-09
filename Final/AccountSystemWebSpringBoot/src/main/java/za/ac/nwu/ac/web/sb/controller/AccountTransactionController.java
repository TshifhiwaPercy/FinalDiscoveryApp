

package za.ac.nwu.ac.web.sb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionFlow;


import java.util.List;


import za.ac.nwu.ac.logic.flow.impl.CreateAccountTransactionFlowImpl;

import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;


@RestController
@Component
@RequestMapping("account-transaction")
public class AccountTransactionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTransactionFlowImpl.class);

    private final CreateAccountTransactionFlow createAccountTransactionFlow;
    private final FetchAccountTransactionFlow fetchAccountTransactionFlow;


    @Autowired
    public AccountTransactionController(CreateAccountTransactionFlow createAccountTransactionFlow,FetchAccountTransactionFlow fetchAccountTransactionFlow) {
        this.createAccountTransactionFlow = createAccountTransactionFlow;
        this.fetchAccountTransactionFlow = fetchAccountTransactionFlow;
    }
    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account types.", notes = "Returns a list of account types.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Account types returned.", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<AccountTransactionDto>>> getAll() {
        List<AccountTransactionDto> AccountTransactions = fetchAccountTransactionFlow.getAllAccountTransactions();
        GeneralResponse<List<AccountTransactionDto>> response = new GeneralResponse<>(true, AccountTransactions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountTransaction.", notes = "Creates a new AccountTransaction in the DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountTransaction was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> create(@ApiParam(value = "Request body to create a new AccountTransaction", required = true) @RequestBody AccountTransactionDto AccountTransaction) {

        AccountTransactionDto AccountTransactionResponse = createAccountTransactionFlow.create(AccountTransaction);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransactionResponse);
        Long startTime = System.nanoTime();
        LOGGER.debug("Create a new AccountTransaction");
        //AccountTransactionDto AccountTransactionResponse = createAccountTransactionFlow.create(AccountTransaction);
        //GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransactionResponse);
        LOGGER.info("Response time{}",((System.nanoTime() - startTime)/1000000L));

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }




    @GetMapping("/{transactionId}")
    @ApiOperation(value = "Fetches the specified AccountTransaction", notes = "Fetches the AccountTransaction corresponding to the given transaction id")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "AccountTransaction record found.", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAccountTransactions(@ApiParam(value = "The transactionId that uniquely identifies the AccountTransaction", example = "50002", name="transactionId", required = true) @PathVariable("transactionId") final Long transactionId){
        AccountTransactionDto AccountTransaction = fetchAccountTransactionFlow.getAccountTransactionById(transactionId);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransaction);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}

