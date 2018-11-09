package team.redrock.skills;

import team.redrock.base.DamageSkill;
import team.redrock.base.buff.DecreaseAttack;

/**
 * @Description
 * @Author 余歌
 * @Date 2018/10/31
 **/
public class DeAttackWave extends DamageSkill implements DecreaseAttack {

    private static final String NAME = "减攻光波";
    private static final int DAMAGE = 50;
    private static final int DE_TIME = 1;

    public DeAttackWave() {
        super(NAME, DAMAGE);
    }

    @Override
    public int getTime() {
        return DE_TIME;
    }

}