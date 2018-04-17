package com.sergeydolzgovvjaga.reentrantlockexample.Model;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
* Class describes main fields
* */
public class Account {

    private final Logger logger = Logger.getLogger(String.valueOf(Account.class));

    private ReentrantLock implicitLock;
    private String name;
    private Integer balance;

    public Account() {
        implicitLock= new ReentrantLock();
        balance=10000;
    }

    public ReentrantLock getImplicitLock() {
        return implicitLock;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getBalance() {
        return balance;
    }
    public void setBalance(Integer blance) {
        this.balance = blance;
    }
    public boolean debit(Integer amount)
    {
        logger.info("start debit(..)");
        if(amount > balance)
        {
            System.out.println(Thread.currentThread().getName() + " : " +name + " says :" + amount + " Greater than current balance" );
            return false;
        }
        balance = balance - amount;
        System.out.println(Thread.currentThread().getName() + " : " + name + " says :" + amount + " Debited successfully" );
        logger.info("exit debit(..)");
        return true;
    }
    public void credit(Integer amount)
    {
        logger.info("start credit(..)");
        balance = balance + amount;
        System.out.println(Thread.currentThread().getName() + " : " + name + " says :" + amount + " Credited successfully" );
        logger.info("exit credit(..)");
    }
}

