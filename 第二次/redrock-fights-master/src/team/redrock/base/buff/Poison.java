package team.redrock.base.buff;

import team.redrock.base.Hero;

/**
 * @Description 中毒的buff
 * @Author zmh
 * @Date 2018/11/7
 **/
public interface Poison extends Buff {

    int aRoundConsume = 100;


    @Override
    default String getDescription() {
        return "并且使其中毒了" + getTime() + "回合！";
    }

    @Override
    default void action(Hero hero) {
        hero.poison(100);
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