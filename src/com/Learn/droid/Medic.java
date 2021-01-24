package com.Learn.droid;

import com.Learn.droid.Gun.Glock;

public class Medic extends Droid {
    private int reinc;
    public Medic(String name, int gun){
        this.name = name;
        d = getTypeOfGun(gun);
        damage = d.getDamage();
        healthpoint = 150;
        reinc = 40;

    }
    @Override
    public int getDamage(){
        this.healthpoint += reinc;
        return this.damage;

    }
    @Override
    public void setHP(int dam){
        this.healthpoint -= dam;
    }
    @Override
    public void info(){
        System.out.println(name);
        System.out.println("Damage = "+damage);
        System.out.println("HP = "+healthpoint);
        System.out.println("Reincarnation = "+reinc);
    }
}
