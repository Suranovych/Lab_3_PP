package com.Learn.droid;

import com.Learn.droid.Gun.Glock;

public class Scout extends Droid{
    private int lowk;
    public Scout(String name, int gun){
        this.name = name;
        d = getTypeOfGun(gun);
        damage = d.getDamage();
        healthpoint = 150;
        lowk = 60;

    }
        @Override
        public int getDamage(){
            return this.damage;
    }
        @Override
        public void setHP(int dam){
            double prob = Math.random()*100;
            if(lowk >= prob){
                dam = 0;
            }
            healthpoint -= dam;
    }
    @Override
    public void info(){
        System.out.println(name);
        System.out.println("Damage = "+damage);
        System.out.println("HP = "+healthpoint);
        System.out.println("Lowk = "+lowk);
    }
}
