package me.logjava.army2.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ASD
 * @maintain Hoàng Nguyên
 */

public class SerArmy {

    public static final Logger logger = LoggerFactory.getLogger(SerArmy.class);

    public static void main(String args[]) {
//        System.out.println("Start server!");
        logger.info("Start server!");
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
//                System.out.println("Shutdown Server!");
                logger.error("Shutdown Server!");
                ServerManager.stop();
            }
        }));
        ServerManager.init();
        ServerManager.start();
    }
}
