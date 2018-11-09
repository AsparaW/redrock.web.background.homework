package team.redrock.skills;

import team.redrock.base.CureSkill;
import team.redrock.base.buff.AddAttack;

/**
 * @Description
 * @Author 余歌
 * @Date 2018/10/31
 **/
public class AddAttackWave extends CureSkill implements AddAttack {

    private static final String NAME = "加攻光波";
    private static final String ARROW = "--->";
    private static final int CURE = 100;
    private static final int abilityUp[] = {10, 20, 30, 20, 10, 5, 5, 5};
    private static final int timeUp[] = {1, 0, 1, 0, 1, 0, 1, 0};
    private int time = 1;

    public AddAttackWave() {
        super(NAME, CURE);
        super.setSpecial(true);
    }

    public void levelUp() {
        int tempAbilityUp = abilityUp[super.getLevel()];
        int tempTimeUp = timeUp[super.getLevel()];


        System.out.println("治疗值" + (super.getCure() + super.getAddCure()) + ARROW + (super.getCure() + super.getAddCure() + tempAbilityUp));
        System.out.println("持续时间" + getTime() + ARROW + (getTime() + tempTimeUp));
        time += tempTimeUp;
        super.plusAddCure(tempAbilityUp);
        super.levelUp();

    }

    @Override
    public int getTime() {
        return time;
    }


}