package Cartes;

import Console.CardDesigner;
import Enums.colore;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import Service.GameService.*;


public class Carte {
    static final Random rd = new Random();
    static CardDesigner cardDesigner = new CardDesigner();
    public static ArrayList<ArrayList<Integer>> BlackList ;

    public static   ArrayList<ArrayList<Integer>> gameCartes ;


    public static  ArrayList<ArrayList<Integer>> Cartes = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> getALLcartes() {
        Cartes.clear();
        for (int form = 1; form <= 4; form++) {
            for (int i = 1; i <= 13; i++) {
                ArrayList<Integer> card = new ArrayList<>();
                card.add(i);
                card.add(form);
                Cartes.add(card);
            }
        }
        return Cartes;
    }


    public static Map<String,ArrayList<ArrayList<Integer>>> GetOne_Rest_Carte(ArrayList<ArrayList<Integer>> restCarte){
        ArrayList<ArrayList<Integer>> OneCarte = new ArrayList<>();
        int result = rd.nextInt((52));

        for(int i =0 ; i <restCarte.size(); i++){
            if(i==result){
                OneCarte.add(restCarte.get(result));
                restCarte.remove(result);
                break;
            }
        }

        Map<String, ArrayList<ArrayList<Integer>>> map = new HashMap<>();
        map.put("OneCarte", OneCarte);
        map.put("RestCarte", restCarte);
        return map ;
    }

    public static ArrayList<ArrayList<Integer>> Shuffle_cartes(ArrayList<ArrayList<Integer>> Cartes){
        ArrayList<ArrayList<Integer>> Carteshuffle = new ArrayList<>() ;
        while (!Cartes.isEmpty()) {
            int size = Cartes.size();
            int index = rd.nextInt(size);
            Carteshuffle.add(Cartes.remove(index));
        }
        return Carteshuffle ;
    }



    public static Map<String,ArrayList<ArrayList<Integer>>> Piocher_une_carte(ArrayList<ArrayList<Integer>> cartesforPiocher){
        ArrayList<ArrayList<Integer>> blackList = new ArrayList<>();
        int result = rd.nextInt(10) + 20;

        for(int i =0 ; i <cartesforPiocher.size(); i++){
            if(i<result){
                blackList.add(cartesforPiocher.remove(i));
            }
        }

        Map<String, ArrayList<ArrayList<Integer>>> map = new HashMap<>();
        map.put("BlackList", blackList);
        map.put("GameCartes", cartesforPiocher);
        return map ;
    }


    public static void getBlackandGameList(ArrayList<ArrayList<Integer>> List){
       Map<String,ArrayList<ArrayList<Integer>>> Piocher_une_carte = Piocher_une_carte(List);
        BlackList= Piocher_une_carte.get("BlackList");
        gameCartes = Piocher_une_carte.get("GameCartes");
    }

    public static  ArrayList<ArrayList<Integer>> NewGame(ArrayList<ArrayList<Integer>> blackList,
                                                         ArrayList<ArrayList<Integer>> gameList,
                                                         ArrayList<ArrayList<Integer>> playerList,
                                                         ArrayList<ArrayList<Integer>> dealerList){
        return Stream.concat(
                    Stream.concat(blackList.stream(), gameList.stream()),
                    Stream.concat(playerList.stream(), dealerList.stream())
                ).collect(Collectors.toCollection(ArrayList::new));
    }

    public static String DesingCartes(ArrayList<ArrayList<Integer>> shuffle , boolean Hide) {
        return  cardDesigner.CardDesignList(shuffle,Hide);
    }



    // function getNextCarte(Cartes)
    public static  ArrayList<ArrayList<Integer>> GetNextCarte(ArrayList<Integer> Carte){
        ArrayList<ArrayList<Integer>> RestCarte = new ArrayList<>();
        int character = Carte.get(0) ;
        int Form = Carte.get(1) ;
        for (int form = Form; form <= colore.values().length; form++) {
                for (int i = character+1; i <= 13; i++) {
                    ArrayList<Integer> card = new ArrayList<>();
                    card.add(i);
                    card.add(form);
                    RestCarte.add(card);
                }
            character=0;
        }

        return RestCarte ;
    }

    // disperse Card function
    public static DisperseCard disperseCard(ArrayList<ArrayList<Integer>> GameCarte){
        ArrayList<ArrayList<Integer>> DealerCard = new ArrayList<>();
        ArrayList<ArrayList<Integer>> PlayerCard = new ArrayList<>();
        boolean checkNumberCarte = false ;
        if(CheckTableCard(GameCarte)){
            for(int i=0 ; i<2 ; i++){
                DealerCard.add(disperseTableCard(GameCarte));
                PlayerCard.add(disperseTableCard(GameCarte));
                checkNumberCarte = true ;
            }
        }
        else checkNumberCarte = false ;

        DisperseCard disperse = new DisperseCard(DealerCard ,PlayerCard , checkNumberCarte);
        return disperse ;

    }

    // function disperse Table Card
    public static ArrayList<Integer> disperseTableCard(ArrayList<ArrayList<Integer>> GameCarte){
        return GameCarte.remove(0);
    }


    // check Table card
    public static  boolean CheckTableCard(ArrayList<ArrayList<Integer>> GameCarte){
        return GameCarte.size() - 4 >= 0;
    }

}