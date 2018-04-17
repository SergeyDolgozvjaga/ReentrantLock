package com.sergeydolzgovvjaga.reentrantlockexample.AccountOperations;

import com.sergeydolzgovvjaga.reentrantlockexample.Model.Account;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * Class describes relations
 * about transfer money
 * from one Account to another
 * */
public class AccountTransfer {

    private final Logger logger = Logger.getLogger(String.valueOf(AccountTransfer.class));
    private ReentrantLock lock= new ReentrantLock();

    /**
    * Method describes relations
    * about transfer money
    * from one Account to another
    * */
    public void transfer(Account from, Account to, Integer amount)
    {
        logger.info("start transfer(..)");
        boolean transfer = false;
        try
        {
            if(lock.tryLock())
            {
                System.out.println(Thread.currentThread().getName() + " says acquire lock");
                boolean flag = from.debit(amount);
                if(flag)
                {
                    to.credit(amount);
                }
                System.out.println(Thread.currentThread().getName()+ " : " + from.getName() + " says : now balance is " + from.getBalance());
                System.out.println(Thread.currentThread().getName()+ " : " + to.getName() + " says : now balance is " + to.getBalance());
                transfer = true;
            }
            else
            {
                System.out.println(Thread.currentThread().getName() + " says fail to acquire both lock Try again");
                transfer(from,to,amount);  //try again
            }
        }
        catch(Exception ex)
        {
           logger.warning(ex.getMessage());
        }
        finally
        {
            if(transfer)
            {
                lock.unlock();
            }
        }
        logger.info("exit transfer(..)");
    }
}
