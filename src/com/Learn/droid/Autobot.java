package com.Learn.droid;

import com.Learn.droid.Gun.Glock;
import com.Learn.droid.Gun.Gun;

public class Autobot extends Droid {
    private int powerhit;
    public Autobot(String name, int gun){
        this.name = name;
        d = getTypeOfGun(gun);
        damage = d.getDamage();
        healthpoint = 150;
        powerhit = 2;
        ;
    }
    @Override
    public int getDamage(){
        return this.damage*powerhit;
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
        System.out.println("Powerhit = "+powerhit);
    }
}
