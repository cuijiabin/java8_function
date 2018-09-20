package com.function.log;

import org.apache.log4j.Logger;

/**
 * @author cuijiabin
 */
public class LogDemo {

    private static Logger logger = Logger.getLogger(LogDemo.class);

    /**
     * @param args
     */
    public static void main(String[] args) {

        logger.debug("This is debug message.");
        logger.info("This is info message.");
        logger.error("This is error message.");
    }

}
