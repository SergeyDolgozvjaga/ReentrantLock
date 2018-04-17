package com.sergeydolzgovvjaga.reentrantlockexample;

import com.sergeydolzgovvjaga.reentrantlockexample.LaunchThreads.ThreadFirst;
import com.sergeydolzgovvjaga.reentrantlockexample.LaunchThreads.ThreadSecond;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
* @Author Dolgozvjaga Sergey 27.03.18
*
* */
public class Main {

    private static final Logger logger = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) {

        logger.info("start App");

        ExecutorService service = Executors.newFixedThreadPool(3);
        for(int i=0;i<4;i++)
        {
            service.submit(new ThreadFirst());
            service.submit(new ThreadSecond());
        }

        logger.info("exit App");
    }
}
