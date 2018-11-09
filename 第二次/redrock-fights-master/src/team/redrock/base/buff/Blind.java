package team.redrock.base.buff;

import team.redrock.base.Hero;

/**
 * @Description 致盲的buff
 * @Author 余歌
 * @Date 2018/10/31
 **/
public interface Blind extends Buff {

    /**
     * 眩晕的蓝耗和时间长度有关
     * 眩晕时间没一回合的蓝耗
     */
    int aRoundConsume = 50;

    @Override
    default String getDescription() {
        return "并且致盲了" + getTime() + "回合！";
    }

    @Override
    default void action(Hero hero) {
        hero.setCanDamage(false);
    }

    @Override
    default boolean isDebuff() {
        return true;
    }

    @Override
    default int getConsume() {
        return getTime() * aRoundConsume;
    }
}
