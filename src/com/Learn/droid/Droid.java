package com.Learn.droid;

import com.Learn.droid.Gun.*;

public abstract class Droid {
    protected int healthpoint;
    protected int damage;
    protected String name;
    protected Gun d;

    public String getName() {
        return name;
    }
    public abstract void info();
    public abstract void setHP(int dam);
    public abstract int getDamage();
    public Gun getTypeOfGun(int num){
        Gun res;
        switch (num){
            case 1:
                res = new Glock();
                break;
            case 2:
                res = new M16();
                break;
            case 3:
                res = new Bazuka();
                break;
            default:
                res = new Knife();
                break;
        }
        return res;
    }
    public Boolean isAlive(){
        if(healthpoint > 0){
            return true;
        }
        else{
            return false;
        }
    }
}
