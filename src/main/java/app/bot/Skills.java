package app.bot;

import java.awt.*;

public class Skills {

    private int skillTime;
    private int countSkillTime = 0;
    private int key;
    private int delay = 0;

    public Skills(int time, int key, int delay) {
        this.skillTime = time;
        this.key = key;
        this.delay = delay;
    }
    public boolean takeActions(Robot robot) {
        if(countSkillTime <= 0) {
            countSkillTime = skillTime;
            robot.keyPress(key);
            robot.delay(100);
            robot.keyRelease(key);
            robot.delay(delay);
            return true;
        }
        decrese();
        return false;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "skillTime=" + skillTime +
                ", countSkillTime=" + countSkillTime +
                ", key=" + key +
                '}';
    }

    private void decrese() {
        countSkillTime--;
    }
}
