package ru.lebedev.se.Homework6.lesson6;

import org.apache.log4j.Logger;

import java.io.IOException;

public class MainClass {

  //  private static final Logger logger = Logger.getLogger("");

    public static void main(String[] args) throws IOException {

        Logger admin = Logger.getLogger("admin");

        admin.info("This is info");
        admin.warn("This is warn");
        admin.error("This is error");
        admin.fatal("This is fatal");

        Logger file = Logger.getLogger("file");

        file.info("This is info");
        file.warn("This is warn");
        file.error("This is error");
        file.fatal("This is fatal");
    }



//    private static final Logger logger = Logger.getLogger("");
//           LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
//
//        logger.setLevel(Level.FINE);
//        logger.getHandlers()[0].setLevel(Level.FINE);
//
//        logger.getHandlers()[0].setFormatter(new Formatter() {
//        @Override
//        public String format(LogRecord record) {
//            return record.getLevel() + "\t" + record.getMessage() + "\t" + record.getMillis() + "\n";
//        }
//    });
//
//        logger.getHandlers()[0].setFilter(new Filter() {
//        @Override
//        public boolean isLoggable(LogRecord record) {
//            return record.getMessage().startsWith("Error");
//        }
//    });
//
//    Handler handler = new FileHandler("mylog.log");
//        handler.setLevel(Level.ALL);
//        handler.setFormatter(new SimpleFormatter());
//        logger.addHandler(handler);
//
//        logger.log(Level.SEVERE, "Error1");
//        logger.log(Level.INFO, "Hello World");
//        logger.log(Level.CONFIG, "Error3");

    // - OFF
    // - SEVERE
    // - WARNING
    // - INFO
    // - CONFIG
    // - FINE
    // - FINER
    // - FINEST
    // - ALL
}
