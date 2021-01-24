package com.Learn.batleArena;

import com.Learn.droid.*;

import java.util.Random;

public class BattleArena {

    public void Batle(Droid droid1, Droid droid2){
        Droid winner;
        int round = 1;
        do{
            roundInfo(round);
            round(droid1, droid2);

            round++;
        }while(droid1.isAlive() && droid2.isAlive());
        if(droid1.isAlive()){
            OneWinner(droid1);
        }
        else {
            OneWinner(droid2);
        }

    }
    public void BattleTwo(Droid droid11,Droid droid12,Droid droid21,Droid droid22){
        Team team1 = new Team(droid11, droid12);
        Team team2 = new Team(droid21, droid22);
        int round = 1;
        do {
            while(team1.twoAlive() & team2.twoAlive()){
                roundInfo(round);
                roundTwo(team1, team2);
                round++;
            }
            while((team1.twoAlive() & (team2.justOneAlive())) | (team2.twoAlive() & (team1.justOneAlive()))){
                roundInfo(round);
                TwoAgainOne(team1,team2);
                round++;
            }
            while (team1.justOneAlive() || team2.justOneAlive()){
                roundInfo(round);
                OneAgainOne(team1, team2);
                round++;
            }

        }while(team1.isTeamAlive() & team2.isTeamAlive());

        if(team1.isTeamAlive()){
            twoWinner(team1);
        }else{
            twoWinner(team2);
        }

    }
    private void roundTwo(Team t1, Team t2){
        if (new Random().nextBoolean()) {
            round(t1.droid1, t2.droid1);
            round(t1.droid2, t2.droid2);
        } else {
            round(t1.droid1, t2.droid2);
            round(t1.droid2, t2.droid1);
        }
    }
    private void twoVsOne (Droid dr1, Droid dt1, Droid dt2){
        if (new Random().nextBoolean()) {
            dr1.setHP(dt1.getDamage() + dt2.getDamage());
            hitInfoTwo(dr1, dt1, dt2);
        } else {
            dt1.setHP(dr1.getDamage()/2);
            dt2.setHP(dr1.getDamage()/2);
            hitInfoOne(dr1, dt1, dt2);
        }
    }
    private void TwoAgainOne (Team team1, Team team2){
        if(team1.twoAlive()){
            if(team2.droid1.isAlive()) {
                twoVsOne(team2.droid1, team1.droid1, team1.droid2);
            }
            else{
                twoVsOne(team2.droid2, team1.droid1, team1.droid2);
            }
        }
        else{
            if(team1.droid1.isAlive()) {
                twoVsOne(team1.droid1, team2.droid1, team2.droid2);
            }
            else{
                twoVsOne(team1.droid2, team2.droid1, team2.droid2);
            }
        }
    }
    private void OneAgainOne(Team team1, Team team2){
        if(team1.droid1.isAlive()){
            if(team2.droid1.isAlive()){
                round(team1.droid1, team2.droid1);
            }else{
                round(team1.droid1, team2.droid2);
            }
        }
        else{
            if(team2.droid1.isAlive()){
                round(team1.droid2, team2.droid1);
            }else{
                round(team1.droid2, team2.droid2);
            }
        }
    }

    public void round(Droid dr1, Droid dr2) {
        if (new Random().nextBoolean()) {
            dr1.setHP(dr2.getDamage());
            System.out.println(dr2.getName()+" hit "+dr1.getName());
        } else {
            dr2.setHP(dr1.getDamage());
            System.out.println(dr1.getName()+" hit "+dr2.getName());
        }
    }

    private void roundInfo(int r){
        System.out.println("_______ Round "+r+" _______");
    }

    private void twoWinner(Team team){
        System.out.println("\n ----------------------");
        System.out.println(team.droid1.getName()+" and "+team.droid2.getName()+ " WIN");
    }

    private void OneWinner(Droid droid){
        System.out.println("\n ----------------------");
        System.out.println("And the new WBO champion is - "+ droid.getName());
    }

    private void hitInfoTwo(Droid d1, Droid d21, Droid d22){
        System.out.println(d21.getName()+" and "+d22.getName()+ " hit "+ d1.getName());
    }

    private void hitInfoOne(Droid d1, Droid d21, Droid d22){
        System.out.println( d1.getName()+ " hit "+ d21.getName()+" and "+d22.getName());
}
}