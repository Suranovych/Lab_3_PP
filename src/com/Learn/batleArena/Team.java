package com.Learn.batleArena;

import com.Learn.droid.Droid;

public class Team {
    public Droid droid1;
    public Droid droid2;

    public Team(Droid droid11, Droid droid22){
        droid1 = droid11;
        droid2 = droid22;
    }

    public boolean isTeamAlive(){
        return droid1.isAlive() | droid2.isAlive();
    }

    public boolean twoAlive(){
        return (droid1.isAlive() & droid2.isAlive());
    }

    public boolean justOneAlive(){
        if((droid1.isAlive()&&(!droid2.isAlive())) | (droid2.isAlive()&(!droid1.isAlive()))){
            return true;
        }
        else{
            return false;
        }
    }
}

