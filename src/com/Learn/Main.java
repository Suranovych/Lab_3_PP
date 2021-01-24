package com.Learn;

import com.Learn.batleArena.BattleArena;
import com.Learn.droid.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

        static public ArrayList<Droid> droids = new ArrayList<>();

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            BattleArena Brawl = new BattleArena();
            int Continue1=1;
            int input;
            while(Continue1 != 0) {
                System.out.println("\nSelect a command:" +
                        "\n 1. Сreate a droid" +
                        "\n 2. List of droid" +
                        "\n 3. Fight 1vs1" +
                        "\n 4. TeamFight "+
                        "\n 5. Quit ");
                input = scan.nextInt();
                switch (input) {
                    case 1:
                        do {
                            createDroid();
                            System.out.println("Do you want to continue?" +
                                    "\nPress '1' to continue and '0' to stop -> ");
                            input = scan.nextInt();
                        } while (input == 1);
                        break;
                    case 2:
                        if (droids.isEmpty()) {
                            System.out.println("The list of droids is empty");
                            break;
                        }
                        listDroids();
                        break;
                    case 3:
                        if (droids.size() < 2) {
                            System.out.println("You can't start a battle because you haven't created enough droids");
                            break;
                        }
                        System.out.println("Select 2 droids you want to use in a battle");
                        int one, two;
                        one = scan.nextInt();
                        System.out.println();
                        do {
                            two = scan.nextInt();
                            if (two==one)
                                System.out.println("You can't choose the same bot bro");
                        }while(two==one);
                        Brawl.Batle( droids.get(one-1), droids.get(two-1));
                        System.out.println("Finish the program? \n Press '1' to continue and '0' to stop ->");
                        Continue1 = scan.nextInt();
                        break;
                    case 4:
                        if (droids.size() < 3) {
                            System.out.println("You can't start a battle because you haven't created enough droids");
                            break;
                        }
                        System.out.println("Select 4 droids you want to use in a battle");
                        int one1, two1, three, four;
                        one1 = scan.nextInt();
                        two1 = scan.nextInt();
                        three = scan.nextInt();
                        four = scan.nextInt();
                        Brawl.BattleTwo( droids.get(one1-1), droids.get(two1-1),droids.get(three-1),droids.get(four-1));
                        break;
                    case 5:
                        return;
                }
            }
        }

        //1st Task
        public static void createDroid(){
            Scanner inp = new Scanner(System.in);
            System.out.print("What's the name of the droid? - ");
            String name = inp.nextLine();
            System.out.println("Choose your droid type:");
            System.out.println("1. Autobot \t\t 2. Medic \t\t 3. Scout \t\t 4. Robot");
            int type = inp.nextInt();
            System.out.println("Choose your droid gun type:");
            System.out.println("1. Glock \t\t 2. M16 \t\t 3. Bazuka \t\t 4. Knife");
            int gun = inp.nextInt();
            switch(type){
                case 1:
                    droids.add(new Autobot(name, gun));
                    break;
                case 2:
                    droids.add(new Medic(name, gun));
                    break;
                case 3:
                    droids.add(new Scout(name, gun));
                    break;
                case 4:
                    droids.add(new Robot(name, gun));
                    break;
                default:
                    System.out.println("The input was incorrect");
                    System.exit(0);
            }
        }

        // 2nd task
        public static void listDroids(){
            System.out.println("The list of existing droids");
            for(int i = 0; i < droids.size(); i++){
                System.out.println((i+1) + ". ");
                droids.get(i).info();
            }
        }


}

