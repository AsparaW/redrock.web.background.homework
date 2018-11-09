package team.redrock.skills;

import team.redrock.base.DamageSkill;
import team.redrock.base.buff.God;

/**
 * @Description
 * @Author 余歌
 * @Date 2018/10/31
 **/
public class TurtlePunch extends DamageSkill implements God {

    private static final String NAME = "王八拳";
    private static final String ARROW = "--->";
    private static final int DAMAGE = 500;
    private static final int abilityUp[] = {100, 50, 50, 50, 50, 50, 50, 50};
    private static final int timeUp[] = {1, 0, 1, 0, 1, 0, 1, 0};
    private int time = 1;

    public TurtlePunch() {
        super(NAME, DAMAGE);
        super.setSpecial(true);
    }

    public void levelUp() {
        int tempAbilityUp = abilityUp[super.getLevel()];
        int tempTimeUp = timeUp[super.getLevel()];

        System.out.println("伤害值" + (super.getDamage() + super.getAddDamage()) + ARROW + (super.getDamage() + super.getAddDamage() + tempAbilityUp));
        System.out.println("持续时间" + getTime() + ARROW + (tempTimeUp + tempTimeUp));
        time += tempTimeUp;
        super.plusAddDamage(tempAbilityUp);
        super.levelUp();
    }

    @Override
    public int getTime() {
        return time;
    }

}