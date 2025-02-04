package com.analyticode.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JDemo {
    private static final Logger logger = LoggerFactory.getLogger(SLF4JDemo.class);

    public static void log() {
        logger.info("This is an INFO message");
        logger.warn("This is a WARNING message");
        logger.error("This is an ERROR message");

        int value = 42;
        logger.debug("Debugging value: {}", value); // Parameterized logging
    }
}
