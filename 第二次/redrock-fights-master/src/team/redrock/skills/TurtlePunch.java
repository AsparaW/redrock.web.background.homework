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
    private static final int DAMAGE = 500;
    private static final int ADD_TIME = 1;

    public TurtlePunch() {
        super(NAME, DAMAGE);
    }

    @Override
    public int getTime() {
        return ADD_TIME;
    }

}