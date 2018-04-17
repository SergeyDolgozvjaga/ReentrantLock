package com.sergeydolzgovvjaga.reentrantlockexample.LaunchThreads;

import com.sergeydolzgovvjaga.reentrantlockexample.AccountOperations.AccountFromTo;
import com.sergeydolzgovvjaga.reentrantlockexample.AccountOperations.AccountTransfer;

import java.util.logging.Logger;

/**
 * Class launch one thread to send money
 * from Account to Account
 * */
public class ThreadFirst implements Runnable {

    private final Logger logger = Logger.getLogger(String.valueOf(ThreadFirst.class));

    private AccountFromTo fromTo;
    private AccountTransfer transfer;

    public ThreadFirst() {
        Init();
    }

    private void Init(){
        fromTo = new AccountFromTo();
        transfer = new AccountTransfer();
    }

    /**
    * Method launch one thread to send money
    * from Account to Account
    * */
    public void run()
    {
        logger.info("start Runnable a");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.warning(e.getMessage());
        }
        transfer.transfer(fromTo.accountFrom(), fromTo.accountTo(), 200);
        System.out.println(Thread.currentThread().getName() + " says : Transfer successful");
        logger.info("exit Runnable a");
    }
}
