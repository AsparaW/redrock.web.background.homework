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
    private static final int DAMAGE = 100;
    private static final int ADD_TIME = 4;

    public GivePoison() {
        super(NAME, DAMAGE);
    }

    @Override
    public int getTime() {
        return ADD_TIME;
    }

}