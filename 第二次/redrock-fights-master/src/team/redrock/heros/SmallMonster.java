package team.redrock.heros;

import team.redrock.base.DamageSkill;
import team.redrock.base.Hero;
import team.redrock.base.Skill;

/**
 * @Description
 * @Author 余歌
 * @Date 2018/11/1
 **/
public class SmallMonster extends Hero {
    public final static int EXP = 1000;
    private final static String NAME = "小怪";//你的名字
    private final static String STUID = "123456";//学号
    private final static int STR = 20;//力量
    private final static int INT = 10;//智力
    private final static int AGI = 5;//敏捷

    public SmallMonster() {
        //在构造方法里第一行写上调用父类的构造方法
        //第一个参数是你的名字，第二个是学号，后面依次是力量、敏捷、智力。
        super(NAME, STUID, STR, AGI, INT);
        super.giveExperience = EXP;
        super.setSmall(true);
        //自己搞两个技能
        Skill xg = new DamageSkill("重击", 10);
        super.addSkill(xg);
    }
}
