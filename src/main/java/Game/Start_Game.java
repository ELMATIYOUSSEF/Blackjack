package Game;

import Cartes.DisperseCard;

import java.util.*;
import java.util.function.Supplier;

import static Cartes.Carte.*;
import static Console.CardDesigner.CardDesignList;
import static Console.Colore.*;

public class Start_Game {

    public static long wallet = 0;
    public static ArrayList<ArrayList<Integer>> usedCard = new ArrayList<>() ;
    public static long RoundAmount=0;
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
                wallet += 1000;
                break;
            case 2:
                wallet +=5000;
                break;
            case 3:
                wallet +=10000;
                break;
            case 4:
                getAutherAmount();
                break;
            case 5:
               System.exit(0);
                break;
            default:
                System.out.println("\n Choix invalide. Veuillez réessayer.");
        }

    }

    public static void getAutherAmount(){
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
    public static void request_Jetton(){
        int choice =0 ;
        do {
            System.out.println(BLEU);
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Wallet => "+ wallet +",00 $");
            System.out.println(RESET);
            System.out.println("Your budge for this round ?");
            System.out.println("1 => 50$");
            System.out.println("2 => 100$");
            System.out.println("3 => 1000$");
            System.out.println("4 => Another amount");
            System.out.println("5 => Quite Game ");
            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println(RED);
                System.out.println("\n Choix invalide. Veuillez réessayer.");
                System.out.println(RESET);
                System.out.print("\nVotre choix : ");
            }
            choice = scanner.nextInt();
        }while (choice<0 || choice>5);


        switch (choice) {
            case 1:
                if(!checkAmount(50)){
                    requestMoney();
                    request_Jetton();
                }
                break;
            case 2:
                if(!checkAmount(100)){
                    requestMoney();
                    request_Jetton();
                }
                break;
            case 3:
                if(!checkAmount(1000)){
                    requestMoney();
                    request_Jetton();
                }
                break;
            case 4:
                getAmount();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println(RED);
                System.out.println("\n Choix invalide. Veuillez réessayer.");
                System.out.println(RESET);
        }
    }

    public static boolean checkAmount(int amount){
        RoundAmount = amount ;
        boolean check = false;
        if (amount <= wallet){
            wallet -= amount ;
            check = true ;
        }

        else {
            System.out.println(RED);
            System.out.println("Votre solde est insuffisant !!");
            System.out.println(RESET);
        }
        return check ;
    }
    public static void getAmount(){
        Boolean check =false;
        do{
            System.out.println(BLEU);
            System.out.println("NB => The Lowest Amount is 50 $ !!");
            System.out.println("Enter the amount : ");
            if (scanner.hasNextInt()) {
             check = checkAmount(scanner.nextInt());
             if(!check){
                 RoundAmount = scanner.nextInt() ;
             }
            }else {
                System.out.println(RED);
                System.out.println("Entre un No character !!");
                System.out.println(RESET);
            }
        }while (check== false);
    }
    
  public static void StartDisgne(){
      System.out.println(GREEN);
      System.out.println("\t\t\t\t\t         :::        ");
      System.out.println("\t\t\t\t\t      :+: :+:      ");
      System.out.println("\t\t\t\t\t       +:+        ");
      System.out.println("\t\t\t\t\t      +#+         ");
      System.out.println("\t\t\t\t\t     +#+          ");
      System.out.println("\t\t\t\t\t    #+#           ");
      System.out.println("\t\t\t\t\t   #######        ");
      System.out.println("                                                   \n");
      _Second_Wait(1);
      System.out.println("                   ");
      System.out.println("\t\t\t\t\t        ::::::::   ");
      System.out.println("\t\t\t\t\t      :+:    :+:   ");
      System.out.println("\t\t\t\t\t           +:+     ");
      System.out.println("\t\t\t\t\t      +#+         ");
      System.out.println("\t\t\t\t\t    +#+           ");
      System.out.println("\t\t\t\t\t  #+#             ");
      System.out.println("\t\t\t\t\t##########        ");
      System.out.println("                   ");
      _Second_Wait(1);
      System.out.println("                   ");
      System.out.println("\t\t\t\t\t      ::::::::     ");
      System.out.println("\t\t\t\t\t    :+:    :+:     ");
      System.out.println("\t\t\t\t\t          +:+       ");
      System.out.println("\t\t\t\t\t      +#++:        ");
      System.out.println("\t\t\t\t\t        +#+         ");
      System.out.println("\t\t\t\t\t#+#    #+#          ");
      System.out.println("\t\t\t\t\t########            ");
      System.out.println("                                               \n");
      _Second_Wait(2);
      System.out.println("      :::::::::       :::            :::     :::   ::: ");
      System.out.println("     :+:    :+:      :+:          :+: :+:   :+:   :+:  ");
      System.out.println("    +:+    +:+      +:+         +:+   +:+   +:+ +:+    ");
      System.out.println("   +#++:++#+       +#+        +#++:++#++:   +#++:      ");
      System.out.println("  +#+             +#+        +#+     +#+    +#+        ");
      System.out.println(" #+#             #+#        #+#     #+#    #+#         ");
      System.out.println("###             ########## ###     ###    ###          ");
      System.out.println("                                               \n");
      _Second_Wait(1);
      System.out.println(RESET);

  }
   public static DisperseCard disperse ;
   public static ArrayList<ArrayList<Integer>> Player = new ArrayList<>();
   public static ArrayList<ArrayList<Integer>>Dealer = new ArrayList<>();
   public static boolean Bool_NbmCarteRest =false ;
    public static void requeststartGame(){
        if (Rules() ==1) {
            requestMoney();
            StartDisgne();
            request_Jetton();
            start();
        } else {
            System.exit(0);
        }
    }
    public static void start(){

        disperse = disperseCard(gameCartes);
        Player=disperse.PlayerCard ;
        Dealer =disperse.DealerCard ;
        Bool_NbmCarteRest  =disperse.checkNumberCarte ;

      while(Bool_NbmCarteRest){
          // calcule total Score of Dealer
          Map<String,Integer> map1 = CalculeTotal(Dealer);
          int CountScoreDealer = map1.get("numbreTotal");
          // calcule total Score of Player
          Map<String,Integer> map = CalculeTotal(Player);
          int countScorePlayer = map.get("numbreTotal");
          int numbreGreaterThan21 = map.get("numbreGreaterThan21");
          // Design list card for Player
            System.out.println(" Your carte : ");
            CardDesignList(Player,false);
          // Rest Card in Game List
            System.out.println("Rest Carte : "+gameCartes.size());
          // Score of Player
            System.out.println("Numbre Total Cartes : "+countScorePlayer);
          // Design list card for dealer
            System.out.println(" Dealer carte : ");
            CardDesignList(Dealer,true);

                if(numbreGreaterThan21 != 1){
                    if(!gameCartes.isEmpty()){
                    HitOrStand() ;
                    }else {
                        System.out.println("Game Card Is Empty !!");
                        _Second_Wait(2);
                        howIswin(countScorePlayer,CountScoreDealer);
                        _Second_Wait(1);
                        playagain();
                    }
                }
                else{
                    _Second_Wait(1);
                    YouLose();
                    CardDesignList(Player,false);
                    System.out.println(BLEU);
                    System.out.println(" Numbre Total  of Your Cartes : " + countScorePlayer);
                    System.out.println(RESET);
                    System.out.println("+------------------------------------------+");
                    CardDesignList(Dealer,false);
                    _Second_Wait(1);
                    request_Jetton();
                    start();
                }

        }
          playagain();
          request_Jetton();
          start();


    }

    public static void HitOrStand(){
        String choice ="" ;
        Scanner scanner1 = new Scanner(System.in);
        if(gameCartes.size()>0) {
            do {
                System.out.print("Do you want to hit or stand? (Type 'hit' or 'stand'): ");
                choice = scanner1.nextLine().toLowerCase();
                if (!choice.equals("hit") && !choice.equals("stand")) {
                    System.out.println(RED);
                    System.out.println("Invalid choice. Please type 'hit' or 'stand'.");
                    System.out.println(RESET);
                }
            } while (!choice.equals("hit") && !choice.equals("stand"));

            if (choice.equals("hit")) {
             Hit(gameCartes, Player);
            } else {
                Stand();
            }
        }else {
                playagain();
            }

        }
    public static void playagain(){
            System.out.println(BLEU);
            System.out.println("\t\t\t\t\t\t\t\t\t\t Wallet => "+ wallet  +",00 $");
            System.out.println(RESET);
            System.out.println("Play again \n 1 - Oui \n 2 - No \n");
            if(scanner.nextInt() == 1 ){
                ArrayList<ArrayList<Integer>> arrayLists = NewGame(BlackList, gameCartes,usedCard);
                getBlackandGameList(arrayLists);
                start();
            }else {
                System.out.println( " By See You later your Wallet => " + wallet  +",00 $");
                _Second_Wait(2);
                System.exit(0);
            }
    }
    public  static  void Hit(ArrayList<ArrayList<Integer>> cards , ArrayList<ArrayList<Integer>> Player){
        ArrayList<Integer> list = disperseTableCard(cards) ;
            usedCard.add(list);
            Player.add(list) ;

    }

    public static void Stand(){

        Map<String,Integer> map = CalculeTotal(Player);
        int scorePlayer = map.get("numbreTotal");
        CardDesignList(Player,false);
        System.out.println(" Numbre Total  of Your Cartes : " + scorePlayer);
        int scoreDealer ;

       do{
           Map<String,Integer> map2 = CalculeTotal(Dealer);
           scoreDealer = map2.get("numbreTotal");
           CardDesignList(Dealer,false);
           System.out.println(" Numbre Total  of Dealer Cartes : " + scoreDealer);
           _Second_Wait(3);
           if(gameCartes.size()>0){
               Hit(gameCartes,Dealer);
           }else break;
           System.out.println("+---------------------------- Dealer ---------------------------+");
       } while (scoreDealer<17 && scoreDealer<=scorePlayer && CheckTableCard(gameCartes));
        howIswin(scorePlayer,scoreDealer);
        request_Jetton();
        start();

    }
    public static Map<String , Integer> CalculeTotal(ArrayList<ArrayList<Integer>> List){
        Map<String , Integer> map = new HashMap<>() ;
        int countNumberOfA = 0 ;
        int totalScore =0 ,Greaterthan21 = 0;
        for (ArrayList<Integer> list: List) {
            if(list.get(0) >10){
                totalScore += 10;
            } else if (list.get(0)==1 ) {
                countNumberOfA++ ;
            }
            else {
                totalScore += list.get(0);
            }
        }
        while (countNumberOfA-- > 0){
            if(totalScore <= 10)
                totalScore += 11 ;
            else totalScore += 1 ;
        }
        if(totalScore>21) Greaterthan21 =1 ;
        map.put("numbreTotal" , totalScore);
        map.put("numbreGreaterThan21" , Greaterthan21);
        return map;
    }

    public static void YouLose(){
        System.out.println(RED);
        System.out.println("   :::   :::       ::::::::      :::    :::           :::        ::::::::       ::::::::       :::::::::: ");
        System.out.println("  :+:   :+:      :+:    :+:     :+:    :+:           :+:       :+:    :+:     :+:    :+:      :+:         ");
        System.out.println("  +:+ +:+       +:+    +:+     +:+    +:+           +:+       +:+    +:+     +:+             +:+          ");
        System.out.println("  +#++:        +#+    +:+     +#+    +:+           +#+       +#+    +:+     +#++:++#++      +#++:++#      ");
        System.out.println("  +#+         +#+    +#+     +#+    +#+           +#+       +#+    +#+            +#+      +#+            ");
        System.out.println(" #+#         #+#    #+#     #+#    #+#           #+#       #+#    #+#     #+#    #+#      #+#             ");
        System.out.println("###          ########       ########            ########## ########       ########       ##########       ");
        System.out.println(RESET);
    }

    public static void YouWin(){
        System.out.println(GREEN);
        System.out.println("   :::   :::       ::::::::      :::    :::         :::       :::       :::::::::::       ::::    ::: ");
        System.out.println("  :+:   :+:      :+:    :+:     :+:    :+:         :+:       :+:           :+:           :+:+:   :+:  ");
        System.out.println("  +:+ +:+       +:+    +:+     +:+    +:+         +:+       +:+           +:+           :+:+:+  +:+   ");
        System.out.println("  +#++:        +#+    +:+     +#+    +:+         +#+  +:+  +#+           +#+           +#+ +:+ +#+    ");
        System.out.println("  +#+         +#+    +#+     +#+    +#+         +#+ +#+#+ +#+           +#+           +#+  +#+#+#     ");
        System.out.println(" #+#         #+#    #+#     #+#    #+#          #+#+# #+#+#            #+#           #+#   #+#+#      ");
        System.out.println("###          ########       ########            ###   ###         ###########       ###    ####       ");
        System.out.println(RESET);
    }
    public static void Draw(){
        System.out.println(BLEU);
        System.out.println("  :::::::::       :::::::::           :::      :::       ::: ");
        System.out.println(" :+:    :+:      :+:    :+:        :+: :+:    :+:       :+:  ");
        System.out.println(" +:+    +:+      +:+    +:+       +:+   +:+   +:+       +:+   ");
        System.out.println(" +#+    +:+      +#++:++#:       +#++:++#++:  +#+  +:+  +#+    ");
        System.out.println(" +#+    +#+      +#+    +#+      +#+     +#+  +#+ +#+#+ +#+     ");
        System.out.println(" #+#    #+#      #+#    #+#      #+#     #+#   #+#+# #+#+#       ");
        System.out.println(" #########       ###    ###      ###     ###    ###   ###         ");
        System.out.println(RESET);
    }

   public static void howIswin(int NumPlayer , int NumDealer){
        if((NumPlayer>NumDealer && NumPlayer<=21 ) ||  NumDealer>21 ){
            wallet = wallet +  (RoundAmount*2) ;
            YouWin();
        } else if (NumDealer == NumPlayer) {
            Draw();
            wallet = wallet + RoundAmount ;
        } else{
            YouLose();
        }
   }


}
