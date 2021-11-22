package app.bot;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandManager {

    private List<Skills> skills = new ArrayList<>();
    public Robot robot;

    public CommandManager() throws AWTException {
        robot = new Robot();
    }

    public Stream<String> readConfigurations() throws FileNotFoundException {
        FileReader fileReader = new FileReader(new File(System.getProperty("user.dir")+"\\conf.txt"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader.lines();
    }

    public static List<Skills> populateSkills() {
        List<Skills> skills = new ArrayList<>();

        skills.add(new Skills(100, KeyEvent.VK_1,2000));
        skills.add(new Skills(90, KeyEvent.VK_4,1000));
        skills.add(new Skills(5, KeyEvent.VK_2,50));
        skills.add(new Skills(20, KeyEvent.VK_3,50));
        skills.add(new Skills(20, KeyEvent.VK_F1,50));
        skills.add(new Skills(20, KeyEvent.VK_F2,50));
        //skills.add(new Skills(20, KeyEvent.VK_F4,50));
        skills.add(new Skills(0, KeyEvent.VK_QUOTE,50));
        skills.add(new Skills(0, KeyEvent.VK_QUOTE,50));
        skills.add(new Skills(0, KeyEvent.VK_QUOTE,50));
        skills.add(new Skills(0, KeyEvent.VK_QUOTE,50));

        return skills;
    }

    public void setUp() throws IOException, URISyntaxException {
        //this.skills = populateSkills();
        Stream<String> configs = readConfigurations();
        List items = configs.map(x -> x).collect(Collectors.toList());
        for(Object item : items ) {
            populate(item.toString());
        }
    }

    public void populate(String line) {
        String[] items =  line.split(",");
        skills.add(new Skills(Integer.parseInt(items[0]), Integer.parseInt(items[1]),Integer.parseInt(items[2])));
    }

    public void runCommand() {
        for (Skills skill : skills) {
            skill.takeActions(robot);
            System.out.printf("%s \n",skill.toString());
        }
    }
}
