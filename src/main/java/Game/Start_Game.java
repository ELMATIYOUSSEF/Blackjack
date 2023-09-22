package Game;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Supplier;

import static java.lang.Thread.*;

public class Start_Game {

    public static long wallet ;
    private static final  Scanner scanner = new Scanner(System.in);

    public static  int Rules(){
        System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                      Blackjack Rules                                        ║");
        System.out.println("╠═════════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 1 _ Starting to the left of the dealer, each player is given  a chance to draw more cards.  ║");
        System.out.println("║                                                                                             ║");
        System.out.println("║ 2 _ The players can either 'hit' or 'stand'.                                                ║");
        System.out.println("║                                                                                             ║");
        System.out.println("║ 3 _ If the player calls out 'HIT',they are given an extra card.                             ║");
        System.out.println("║                                                                                             ║");
        System.out.println("║ 4 _ They can then either call  out 'HIT' again, or 'STAND' if they do not wish to draw      ║");
        System.out.println("║     any more cards.                                                                         ║");
        System.out.println("║                                                                                             ║");
        System.out.println("║ 5 _ The player can 'HIT' as many times as they wish, but have to aim not to 'bust'          ║");
        System.out.println("║     (exceed a total of 21).                                                                 ║");
        System.out.println("║                                                                                             ║");
        System.out.println("║ 6 _ All number cards (2-10)score the value indicated on them.                               ║");
        System.out.println("║                                                                                             ║");
        System.out.println("║ 7 _ The face cards Jack,Queen,King score 10 points,and Ace can either be treated as 1 or 11.║");
        System.out.println("║                                                                                             ║");
        System.out.println("║═════════════════════════════════════════════════════════════════════════════════════════════║");


        int choix =0;
       do{
           System.out.println("╔════════════════════════════════╗");
           System.out.println("║        1 => Start Game         ║ ");
           System.out.println("║        2 => Quit game          ║");
           System.out.println("║════════════════════════════════║");

           while (!scanner.hasNextInt()) {
               scanner.nextLine();
               System.out.println("\n Choix invalide. Veuillez réessayer.");
               System.out.print("\nVotre choix : ");
           }
           choix = scanner.nextInt();
       }while(choix<0||choix>2);

       return choix;

    }

    //function request how much money

    public static void requestMoney(){
        int choice =0 ;
        do {
        System.out.println("How much do you want to gamble ?");
        System.out.println("1 => 1000$");
        System.out.println("2 => 5000$");
        System.out.println("3 => 10000$");
        System.out.println("4 => Another amount");
        System.out.println("5 => Sorry i don't have this amount");
            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("\n Choix invalide. Veuillez réessayer.");
                System.out.print("\nVotre choix : ");
            }
            choice = scanner.nextInt();
        }while (choice<0 || choice>5);



        switch (choice) {
            case 1:
                wallet = 1000;
                break;
            case 2:
                wallet =5000;
                break;
            case 3:
                wallet =10000;
                break;
            case 4:
                getautherAmount();
                break;
            case 5:
               System.exit(0);
                break;
            default:
                System.out.println("\n Choix invalide. Veuillez réessayer.");
        }

    }
    public static void startGame(){
        if (Rules() ==1) {
            requestMoney();
        } else {
            System.exit(0);
        }
    }

    public static void getautherAmount(){
        int check =0;
        do{
            System.out.println("NB => The Lowest Amount is 1000 $ !!");
            System.out.println("Enter the amount : ");
            if (scanner.hasNextInt()) {
                check = scanner.nextInt();
                if (check < 1000) System.out.println(" NB The Lowest Amount is 1000 $ ");
                else wallet = check;
            }else System.out.println("Entre un  No character  !!");
        }while (check < 1000);
    }

    public static void _Second_Wait(int num){
        try{
            int second = num *1000;
            Thread.sleep(second);
        } catch(Exception e){
            Supplier<String> runnable = () -> e.getMessage();
            System.out.println(runnable.get());
        }


    }
}
