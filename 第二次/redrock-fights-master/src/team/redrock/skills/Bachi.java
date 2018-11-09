package team.redrock.skills;

import team.redrock.base.DamageSkill;
import team.redrock.base.buff.Dizzy;

/**
 * @Description
 * @Author 余歌
 * @Date 2018/10/31
 **/
public class Bachi extends DamageSkill implements Dizzy {

    private static final String NAME = "八极拳";
    private static final String ARROW = "--->";
    private static final int DAMAGE = 200;
    private static final int abilityUp[] = {70, 30, 20, 10, 10, 5, 5, 5};
    private static final int timeUp[] = {1, 0, 1, 0, 1, 0, 1, 0};
    private static int dizzy_time = 1;

    public Bachi() {
        super(NAME, DAMAGE);
        super.setSpecial(true);
    }

    public void levelUp() {
        int tempAbilityUp = abilityUp[super.getLevel()];
        int tempTimeUp = timeUp[super.getLevel()];

        System.out.println("伤害值" + (super.getDamage() + super.getAddDamage()) + ARROW + (super.getDamage() + super.getAddDamage() + tempAbilityUp));
        System.out.println("持续时间" + getTime() + ARROW + (tempTimeUp + tempTimeUp));
        dizzy_time += tempTimeUp;
        super.plusAddDamage(tempAbilityUp);

        super.levelUp();
    }

    @Override
    public int getTime() {
        return dizzy_time;
    }

}