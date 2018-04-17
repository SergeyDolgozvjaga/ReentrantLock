package com.sergeydolzgovvjaga.reentrantlockexample.AccountOperations;

import com.sergeydolzgovvjaga.reentrantlockexample.Model.Account;

import java.util.logging.Logger;

/**
* Class helps set values
* for Accounts
* (who sender and receiver money )
*
* */
public class AccountFromTo {

    private final Logger logger = Logger.getLogger(String.valueOf(AccountFromTo.class));

    public Account accountFrom(){
        return accountFromPrivate();
    }

    public Account accountTo(){
        return accountToPrivate();
    }

    /**
    * Method set values for Account
    * from send money
    *
    * @return Account with set values for money send
    * */
    private Account accountFromPrivate(){
        logger.info("start accountFromPrivate()");
        Account from = new Account();
        from.setBalance(20000);
        from.setName("Dow Jones");
        logger.info("exit accountFromPrivate()");
        return from;
    }

    /**
    * Method set values for Account
    * that receive money
    *
    * @return Account with values (to receive money)
    * */
    private Account accountToPrivate(){
        logger.info("start accountTo()");
        Account to = new Account();
        to.setName("Don Pedro");
        logger.info("exit accountTo()");
        return to;
    }
}
