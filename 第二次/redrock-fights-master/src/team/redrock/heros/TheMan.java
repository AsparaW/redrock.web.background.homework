package team.redrock.heros;

import team.redrock.base.DamageSkill;
import team.redrock.base.Hero;
import team.redrock.base.Skill;
import team.redrock.skills.CriticalPunch;

/**
 * @Description
 * @Author 余歌
 * @Date 2018/11/1
 **/
public class TheMan extends Hero {
    public final static int EXP = 10000;
    private final static String NAME = "钟明翰";//你的名字
    private final static String STUID = "2017212030";//学号
    private final static int STR = 299;//力量
    private final static int INT = 0;//智力
    private final static int AGI = 201;//敏捷

    public TheMan() {
        //在构造方法里第一行写上调用父类的构造方法
        //第一个参数是你的名字，第二个是学号，后面依次是力量、敏捷、智力。
        super(NAME, STUID, STR, AGI, INT);
        super.giveExperience = EXP;
        //自己搞两个技能
        Skill yeQiuPunch = new DamageSkill("真·野球拳", 10000000);
        Skill yeQiuPunch2 = new CriticalPunch();
        super.addSkill(yeQiuPunch);
        super.addSkill(yeQiuPunch2);
    }
}
