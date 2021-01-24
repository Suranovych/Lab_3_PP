package com.Learn.droid;

import com.Learn.droid.Gun.Glock;

public class Robot extends Droid{
    private int shield;
    public Robot(String name, int gun){
        this.name = name;
        d = getTypeOfGun(gun);
        damage = d.getDamage();
        healthpoint = 150;
        shield = 100;

    }
    @Override
    public int getDamage(){
        return this.damage;
    }
    @Override
    public void setHP(int dam){
        shield -= dam;
        if(shield < 0){
            this.healthpoint -=(-1)*shield;
        }
    }
    @Override
    public void info(){
        System.out.println(name);
        System.out.println("Damage = "+damage);
        System.out.println("HP = "+healthpoint);
        System.out.println("Shield = "+shield);
    }
}
