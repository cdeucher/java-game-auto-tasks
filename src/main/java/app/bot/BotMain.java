package app.bot;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class BotMain {

    public static final int DESIRED_FPS = 1;
    public static final double TIME_REFRESH = 1000;
    public static Robot act = null;
    public static CommandManager cm;

    public static void main(String[] args) throws AWTException, IOException, URISyntaxException {
        act = new Robot();
        cm  = new CommandManager();
        cm.setUp();

        sleep(2000);

        game();
    }

    public static void game() {
        long usedTime;

        while(true) {
            long startTime = System.currentTimeMillis();

            cm.runCommand();

            usedTime = System.currentTimeMillis() - startTime;

            if (usedTime == 0) usedTime = 1;
            int timeDiff = (int) ((TIME_REFRESH/DESIRED_FPS) - usedTime);

            if (timeDiff > 0) {
                sleep(timeDiff);
            }
        }
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
