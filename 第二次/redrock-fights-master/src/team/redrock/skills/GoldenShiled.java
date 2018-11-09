package team.redrock.skills;

import team.redrock.base.CureSkill;
import team.redrock.base.buff.Shiled;

/**
 * @Description
 * @Author 余歌
 * @Date 2018/10/31
 **/
public class GoldenShiled extends CureSkill implements Shiled {

    private static final String NAME = "金钟罩";
    private static final String ARROW = "--->";
    private static final int CURE = 100;
    private static final int abilityUp[] = {100, 200, 50, 50, 50, 50, 50, 50};
    private static final int timeUp[] = {1, 0, 1, 0, 1, 0, 1, 0};
    private int time = 2;

    public GoldenShiled() {
        super(NAME, CURE);
        super.setSpecial(true);
    }

    public void levelUp() {
        int tempAbilityUp = abilityUp[super.getLevel()];
        int tempTimeUp = timeUp[super.getLevel()];


        System.out.println("治疗值" + (super.getCure() + super.getAddCure()) + ARROW + (super.getCure() + super.getAddCure() + tempAbilityUp));
        System.out.println("持续时间" + getTime() + ARROW + (getTime() + tempTimeUp));
        super.plusAddCure(tempAbilityUp);
        time += tempTimeUp;
        super.levelUp();
    }

    @Override
    public int getTime() {
        return time;
    }

}