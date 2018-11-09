package team.redrock.base.buff;

import team.redrock.base.Hero;

/**
 * @Description 眩晕的buff
 * @Author 余歌
 * @Date 2018/10/31
 **/
public interface AddAttack extends Buff {

    /**
     * 眩晕的蓝耗和时间长度有关
     * 眩晕时间没一回合的蓝耗
     */
    int aRoundConsume = 70;

    @Override
    default String getDescription() {
        return "并且获得了120%攻击力" + getTime() + "回合！";
    }

    @Override
    default void action(Hero hero) {
        hero.setIsAddattack(true);
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
