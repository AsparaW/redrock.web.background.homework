package team.redrock.base.buff;

import team.redrock.base.Hero;

/**
 * @Description 眩晕的buff
 * @Author 余歌
 * @Date 2018/10/31
 **/
public interface DecreaseAttack extends Buff {

    /**
     * 眩晕的蓝耗和时间长度有关
     * 眩晕时间没一回合的蓝耗
     */
    int aRoundConsume = 70;

    @Override
    default String getDescription() {
        return "并且减攻20%了" + getTime() + "回合！";
    }

    @Override
    default void action(Hero hero) {
        hero.setIsDeAttack(true);
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
