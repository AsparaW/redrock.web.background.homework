package team.redrock.heros;

import team.redrock.base.Hero;
import team.redrock.base.Skill;
import team.redrock.skills.AddAttackWave;
import team.redrock.skills.DeAttackWave;

/**
 * @Description
 * @Author 余歌
 * @Date 2018/11/1
 **/
public class Wizard extends Hero {
    public final static int EXP = 10000;
    private final static String NAME = "法师";//你的名字
    private final static String STUID = "123456";//学号
    private final static int STR = 100;//力量
    private final static int INT = 100;//智力
    private final static int AGI = 100;//敏捷

    public Wizard() {
        //在构造方法里第一行写上调用父类的构造方法
        //第一个参数是你的名字，第二个是学号，后面依次是力量、敏捷、智力。
        super(NAME, STUID, STR, AGI, INT);
        super.giveExperience = EXP;
        //自己搞两个技能
        Skill addAtk = new AddAttackWave();
        Skill deAtk = new DeAttackWave();
        super.addSkill(addAtk);
        super.addSkill(deAtk);
    }
}
