package team.redrock.base;

/**
 * @Description 治疗类技能
 * @Author 余歌
 * @Date 2018/10/31
 **/
public class CureSkill extends Skill {
    private static final int abilityUp[] = {10, 20, 30, 30, 20, 10, 5, 5};
    private static final String ARROW = "--->";
    private int cure;
    private int addCure = 0;

    public CureSkill(String name, int cure) {
        super(name, cure / 2);
        this.cure = cure;
    }

    public int getCure() {
        return cure;
    }

    public int getAddCure() {
        return addCure;
    }

    //为啥有些技能是直接继承CureSkill类 有些又要单独写，在这里改的地方太多了
    public void addLevel(int level) {

        System.out.println("治疗值" + (cure + addCure) + ARROW + (cure + addCure + abilityUp[super.getLevel()]));
        addCure += abilityUp[super.getLevel()];
        super.setConsume((cure + addCure) / 2);
        super.addLevel(1);
    }

    public void plusAddCure(int addCure) {
        this.addCure += addCure;
        super.setConsume((addCure + addCure) / 2);
    }

    @Override
    public final int cast(Hero hero) {
        return cure;
    }
}
