package team.redrock.skills;

import team.redrock.base.CureSkill;
import team.redrock.base.DamageSkill;
import team.redrock.base.buff.Shiled;

/**
 * @Description
 * @Author 余歌
 * @Date 2018/10/31
 **/
public class GoldenShiled extends CureSkill implements Shiled {

    private static final String NAME = "金钟罩";
    private static final int CURE = 100;
    private static final int ADD_TIME = 2;

    public GoldenShiled() {
        super(NAME, CURE);
    }

    @Override
    public int getTime() {
        return ADD_TIME;
    }

}