package team.redrock.skills;

import team.redrock.base.DamageSkill;
import team.redrock.base.buff.Blind;

/**
 * @Description
 * @Author 余歌
 * @Date 2018/10/31
 **/
public class GiveSand extends DamageSkill implements Blind {

    private static final String NAME = "抛沙";
    private static final int DAMAGE = 10;
    private static final int ADD_TIME = 3;

    public GiveSand() {
        super(NAME, DAMAGE);
    }

    @Override
    public int getTime() {
        return ADD_TIME;
    }

}