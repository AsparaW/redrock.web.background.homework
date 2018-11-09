package team.redrock.skills;

import team.redrock.base.DamageSkill;
import team.redrock.base.buff.Silence;

/**
 * @Description
 * @Author 余歌
 * @Date 2018/10/31
 **/
public class SilenceWave extends DamageSkill implements Silence {

    private static final String NAME = "沉默光波";
    private static final int DAMAGE = 50;
    private static final int ADD_TIME = 2;

    public SilenceWave() {
        super(NAME, DAMAGE);
    }

    @Override
    public int getTime() {
        return ADD_TIME;
    }

}