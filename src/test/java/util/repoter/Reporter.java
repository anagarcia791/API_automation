package util.repoter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reporter class for information and errors.
 *
 * @author am.garcia
 */
public class Reporter {
    /**
     * Constructor method for reporter
     */
    public Reporter() {
    }

    /**
     * The log
     *
     * @return logger.
     * @author am.garcia
     */
    private static Logger getLogger() {
        return LoggerFactory.getLogger(Reporter.class);
    }

    /**
     * Log info
     *
     * @author am.garcia
     */
    public static void info(String text) {
        getLogger().info(text);
    }

    /**
     * Log error
     *
     * @author am.garcia
     */
    public static void error(String text) {
        getLogger().error(text);
    }
}
