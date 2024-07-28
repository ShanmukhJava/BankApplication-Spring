package com.example.BankApplication.Logging;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

//    @Before("execution(public * com.example.BankApplication.Bank.BankController.totalAccounts())")
//    public void logBefore() {
//        LOGGER.info("totalAccounts method called from aspect");
//    }

    @After("execution(public * com.example.BankApplication.Bank.BankController.totalAccounts())")
    public void logAfter() {
        LOGGER.info("totalAccounts() method executed.");
    }
    @AfterReturning("execution(public * com.example.BankApplication.Bank.BankController.totalAccounts())")
    public void logAfterReturning() {
        LOGGER.info("totalAccounts() method executed, returned a value.");
    }
    @AfterThrowing("execution(public * com.example.BankApplication.Bank.BankController.totalAccounts())")
    public void logAfterThrowing() {
        LOGGER.info("totalAccounts() method threw an exception.");
    }
}
