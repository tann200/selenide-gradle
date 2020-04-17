package helpers;

import io.qameta.allure.Allure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllureLogger {
        private static Logger logger = LoggerFactory.getLogger(AllureLogger.class);

        // If you want to add a log to your allure report just use this function wherever you need
        public static void putLogAllure(String name, String log) {
            logger.info(log);
            Allure.addAttachment(name, log);
        }
}
