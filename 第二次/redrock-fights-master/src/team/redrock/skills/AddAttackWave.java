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
    private static final int CURE = 100;
    private static final int ADD_TIME = 1;

    public AddAttackWave() {
        super(NAME, CURE);
    }

    @Override
    public int getTime() {
        return ADD_TIME;
    }

}