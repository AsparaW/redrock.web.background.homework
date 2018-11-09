package team.redrock.base;

/**
 * @Description 伤害类技能
 * @Author 余歌
 * @Date 2018/10/31
 **/
public class DamageSkill extends Skill {

    private static final int abilityUp[] = {10, 20, 30, 30, 20, 10, 5, 5};
    private static final String ARROW = "--->";
    private int damage;
    private int addDamage = 0;

    public DamageSkill(String name, int damage) {
        super(name, damage / 2);
        this.damage = damage;
    }

    public int getAddDamage() {
        return addDamage;
    }

    public int getDamage() {
        return damage;
    }

    public void addLevel(int level) {

        System.out.println("伤害值" + (damage + addDamage) + ARROW + (damage + addDamage + abilityUp[super.getLevel()]));
        addDamage += abilityUp[super.getLevel()];
        super.setConsume((damage + addDamage) / 2);
        super.addLevel(1);
    }

    public void plusAddDamage(int addDamage) {
        this.addDamage = this.addDamage + addDamage;
        super.setConsume((damage + this.addDamage) / 2);
    }

    @Override
    public int cast(Hero hero) {
        hero.reduceHp(damage + addDamage);
        return 0;
    }


}
