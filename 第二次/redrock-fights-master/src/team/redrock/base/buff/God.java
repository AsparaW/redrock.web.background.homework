package team.redrock.base.buff;

import team.redrock.base.Hero;

/**
 * @Description 无敌的buff
 * @Author 余歌
 * @Date 2018/10/31
 **/
public interface God extends Buff {

    /**
     * 眩晕的蓝耗和时间长度有关
     * 眩晕时间没一回合的蓝耗
     */
    int aRoundConsume = 200;

    @Override
    default String getDescription() {
        return "并且获得了无敌" + getTime() + "回合！";
    }

    @Override
    default void action(Hero hero) {
        hero.setIsGod(true);
    }

    @Override
    default boolean isDebuff() {
        return false;
    }

    @Override
    default int getConsume() {
        return getTime() * aRoundConsume;
    }
}
