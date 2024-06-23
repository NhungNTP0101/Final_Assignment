package com.vmo.demoWebShop.helper;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.qameta.allure.Allure.step;

public class Log {
    private static Logger logger = LogManager.getLogger(Log.class);

    public static void info(String message) {
        logger.info(message);
    }

    public static void info(String message, String... value) {
        logger.info(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void error(String message) {
        logger.error(message);
    }


    public static void allure(String message, String... value) {
        if (value.length == 0) {
            info(message);
            step(message);
        } else {
            info(String.format(message, (Object[]) value));
            step(String.format(message, (Object[]) value));
        }
    }

    @Step("{message}")
    private static void step(String message) {

    }
}
