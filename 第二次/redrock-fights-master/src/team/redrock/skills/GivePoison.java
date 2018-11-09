package team.redrock.skills;

import team.redrock.base.DamageSkill;
import team.redrock.base.buff.Poison;

/**
 * @Description
 * @Author 余歌
 * @Date 2018/10/31
 **/
public class GivePoison extends DamageSkill implements Poison {

    private static final String NAME = "投毒";
    private static final String ARROW = "--->";
    private static final int DAMAGE = 100;
    private static final int abilityUp[] = {40, 30, 20, 20, 10, 5, 5, 5};
    private static final int timeUp[] = {1, 0, 1, 0, 1, 0, 1, 0};
    private int time = 4;

    public GivePoison() {
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