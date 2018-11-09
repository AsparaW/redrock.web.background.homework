package team.redrock.skills;

import team.redrock.base.DamageSkill;
import team.redrock.base.buff.Critical;

/**
 * @Description
 * @Author 余歌
 * @Date 2018/10/31
 **/
public class CriticalPunch extends DamageSkill implements Critical {

    private static final String NAME = "野球拳";
    private static final int DAMAGE = 50;
    private static final int ADD_TIME = 1;

    public CriticalPunch() {
        super(NAME, DAMAGE);
    }

    @Override
    public int getTime() {
        return ADD_TIME;
    }

}