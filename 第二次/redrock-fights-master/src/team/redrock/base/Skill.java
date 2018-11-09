package team.redrock.base;

/**
 * @Description
 * @Author 余歌
 * @Date 2018/10/31
 **/
public abstract class Skill {

    private final String name;
    private int consume;//蓝耗
    private int level;
    private boolean isSpecial = false;

    protected Skill(String name, int consume) {
        this.name = name;
        this.consume = consume;
        level = 0;
    }

    public void addLevel(int level) {
        this.level += level;
    }

    public int getConsume() {
        return consume;
    }

    public void setConsume(int consume) {
        this.consume = consume;
    }

    public String getName() {
        return this.name;
    }

    //返回值是对释放者的血量加减
    public abstract int cast(Hero hero);

    public boolean getSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        this.level++;
    }
}
