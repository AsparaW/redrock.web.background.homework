package team.redrock.base;

import team.redrock.base.buff.Buff;

import java.util.*;

/**
 * @Description 英雄的基类 你应该继承这个类
 * @Author 余歌
 * @Date 2018/10/31
 **/
public abstract class Hero {

    //力量 血量等于力量*19
    private final int strength;

    //智力 蓝量等于智力*13
    private final int intelligence;

    //敏捷 普攻伤害等于敏捷 敏捷高的一方先行动
    private final int agility;

    //你的名字
    private final String name;

    //你的学号
    private final String stuid;

    //你身上的buff的集合
    private Map<Buff, Integer> buff;

    //能否放技能(沉默)
    private boolean canCast = true;

    //能否普攻
    private boolean canDamage = true;

    //你的血量
    private int hp;

    //你的蓝量
    private int mp;

    //你的普攻伤害
    private int damage;

    //无敌BUFF
    private boolean isGod = false;
    //护盾buff
    private boolean isShiled = false;
    //暴击buff

    private boolean isCritical = false;
    //加攻100
    private boolean isAddAttack = false;
    //减攻100
    private boolean isDeAttack = false;
    //你的技能 最多两个
    private List<Skill> skills;

    /**
     * 构造方法 你的人物里应该调用父类的这个构造方法
     *
     * @param name         你的名字
     * @param stuid        你的学号
     * @param strength     你的力量
     * @param agility      你的敏捷
     * @param intelligence 你的智力
     */
    protected Hero(String name, String stuid, int strength, int agility, int intelligence) {

        if (strength + intelligence + agility > 500) {
            throw new RuntimeException("三维超过了500！");
        }

        this.stuid = stuid;
        this.name = name;
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.hp = strength * 19;
        this.mp = intelligence * 13;
        this.damage = agility;
        skills = new ArrayList<>();
        buff = new HashMap<>();
    }

    //下面九个方法是封装
    public boolean isCanCast() {
        return canCast;
    }

    public void setCanCast(boolean canCast) {
        this.canCast = canCast;
    }

    public boolean isCanDamage() {
        return canDamage;
    }

    public void setCanDamage(boolean canDamage) {
        this.canDamage = canDamage;
    }

    public void setIsGod(boolean isGod) {
        this.isGod = isGod;
    }

    public void setIsShiled(boolean isShiled) {
        this.isShiled = isShiled;
    }

    public void setIsCritical(boolean isCritical) {
        this.isCritical = isCritical;
    }

    public void setIsAddattack(boolean isAddAttack) {
        this.isAddAttack = isAddAttack;
    }

    public void setIsDeAttack(boolean isDeAttack) {
        this.isDeAttack = isDeAttack;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public int getAgi() {
        return agility;
    }

    public int getSkillNum() {
        return skills.size();
    }

    public String getName() {
        return this.name;
    }

    //加buff
    public void addBuff(Buff b) {
        buff.put(b, b.getTime());
    }

    //加技能
    protected void addSkill(Skill skill) {
        if (skills.size() < 2) {
            skills.add(skill);
        } else {
            throw new RuntimeException("技能不能超过两个！");
        }
    }

    //得到一个技能
    public Skill getSkill(int num) {
        if (num >= skills.size()) {
            throw new RuntimeException("拿错啦");
        }
        return skills.get(num);
    }

    //每打完一轮之后 所有英雄回满血蓝
    public void init() {
        this.hp = strength * 19;
        this.mp = intelligence * 13;
        this.buff.clear();
    }

    /**
     * 释放技能
     *
     * @param skill 要释放的技能
     * @param hero  你的对手
     */
    public final void cast(Skill skill, Hero hero) {
        //蓝耗够的情况下
        if (this.mp >= skill.getConsume()) {
            this.mp -= skill.getConsume();


            if (skill.cast(hero)>0){
                System.out.print("【" + this.name + "】" + "对自己使用了【" + skill.getName() + "】恢复了" + skill.getConsume() * 2 + "点生命值");
                this.hp += skill.cast(hero);
            }
                else{

                System.out.print("【" + this.name + "】对【" + hero.getName() + "】使用了【" + skill.getName() + "】造成了" + skill.getConsume() * 2 + "点伤害");
            }
            //如果技能还有buff
            if (skill instanceof Buff) {
                Buff buff = ((Buff) skill);
                System.out.print(buff.getDescription());
                hero.reduceMp(buff.getConsume());
                if (buff.isDebuff()) {
                    hero.addBuff(buff);
                } else {
                    this.addBuff(buff);
                }
            }
            System.out.println();



        } else {
            //不够就只能普攻了
            if (this.isCanDamage()) {
                this.attach(hero);
            } else {
                System.out.println("【" + this.name + "】什么都做不了");
            }
        }
    }

    //掉血
    protected void reduceHp(int num) {
            this.hp -= num;
    }

    //掉蓝
    protected void reduceMp(int num) {
        this.mp -= num;
    }

    //普攻
    public void attach(Hero hero) {
        int damage=this.damage;
        if (this.isAddAttack) {
          damage*=1.2;
        }
        if (this.isDeAttack) {
            damage *=0.8;
        }
        if (hero.isShiled){
            damage *=0.75;
        }
        if (this.isCritical) {
            Random r = new Random();
            double weight = r.nextDouble();
            if (weight > 0.5) {
                System.out.println("暴击！造成3倍伤害！");
                damage*=3;
            } else {
                System.out.println("暴击失败！");
            }
        }
            if (hero.isGod){
                damage=0;
                System.out.println(this.name + "无敌中！");
            }
        hero.reduceHp(damage);
        System.out.println("【" + this.getName() + "】攻击了【" + hero.getName() + "】造成了" + damage + "点伤害！");
    }

    //每回合开始的时候结算buff
    public void turn() {
        this.canCast = true;
        this.canDamage = true;
        this.isGod = false;
        this.isCritical = false;
        this.isDeAttack = false;
        this.isAddAttack = false;
        this.isShiled =false;
        //
        //
        List a=new ArrayList();
        for (Map.Entry<Buff, Integer> entry : buff.entrySet()) {

            if (entry.getValue() == 0) {
                //buff .remove(entry.getKey());
                a.add(entry.getKey());
                continue;
            }
            entry.getKey().action(this);
            entry.setValue(entry.getValue() - 1);
        }

        for (int i=0;i<a.size();i++){
            buff.remove(a.get(i));
        }
/*

        for (Iterator<Map.Entry<Buff, Integer>> it = buff.entrySet().iterator(); it.hasNext();){
            Map.Entry<Buff, Integer> item = it.next();
            if ( == 0) {
                buff .remove(entry.getKey());
                continue;
            }
            entry.getKey().action(this);
            entry.setValue(entry.getValue() - 1);
            it.remove();
        }
*/


    }

    public void poison(int num) {
        reduceHp(num);
        System.out.println(this.name + "中毒了，造成" + num + "伤害");
    }


}
