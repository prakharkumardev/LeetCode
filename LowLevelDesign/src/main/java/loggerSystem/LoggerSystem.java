package loggerSystem;

import loggerSystem.enums.LoggerLevel;

public class LoggerSystem {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger();
        logger.info("This is an information message");
        logger.debug("This is a debug message");
        logger.error("This is an error message");

    }



}
