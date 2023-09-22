package Cartes;

import Console.CardDesigner;

import java.util.*;

import static Console.forms.choixForm;
import static Console.forms.choixchar;

public class carte {
    private static final Random rd = new Random();
    static CardDesigner cardDesigner = new CardDesigner();


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


    public static Map<String,ArrayList<ArrayList<Integer>>> tirer_une_carte(ArrayList<ArrayList<Integer>> restCarte){
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

    public static ArrayList<ArrayList<Integer>> makeCarteUpOfREstCartes(ArrayList<ArrayList<Integer>> cartes , ArrayList<ArrayList<Integer>> carte){
        ArrayList<ArrayList<Integer>> ListTemp = new ArrayList<>();
        ListTemp.add(carte.get(0));
        ListTemp.addAll(cartes);
        return ListTemp ;
    }


    public static Map<String,ArrayList<ArrayList<Integer>>> Piocher_une_carte(ArrayList<ArrayList<Integer>> cartesforPiocher){
        ArrayList<ArrayList<Integer>> blackList = new ArrayList<>();
        int result = rd.nextInt(10) + 20;

        for(int i =0 ; i <cartesforPiocher.size(); i++){
            if(i>result){
                blackList.add(cartesforPiocher.get(result));
                cartesforPiocher.remove(result);
                break;
            }
        }

        Map<String, ArrayList<ArrayList<Integer>>> map = new HashMap<>();
        map.put("BlackList", blackList);
        map.put("GameCartes", cartesforPiocher);
        return map ;
    }

    public static  ArrayList<ArrayList<Integer>> NewGame(ArrayList<ArrayList<Integer>> BlackList , ArrayList<ArrayList<Integer>> TableList ,ArrayList<ArrayList<Integer>> ResTGameList ,ArrayList<ArrayList<Integer>> usesCarte){
        ArrayList<ArrayList<Integer>> Lift_for_new_Game =new ArrayList<>() ;
        Lift_for_new_Game.addAll(BlackList);
        Lift_for_new_Game.addAll(TableList);
        Lift_for_new_Game.addAll(ResTGameList);
        Lift_for_new_Game.addAll(usesCarte);
        return Lift_for_new_Game ;
    }

    public static String DesingCartes(ArrayList<ArrayList<Integer>> shuffle){
        String design ="";
        for (ArrayList<Integer> card : shuffle) {
             design = cardDesigner.CardDesign(choixchar(card.get(0)), choixForm(card.get(1)));
        }
        return design ;
    }

    public static String DesignCarte(ArrayList<Integer> shuffle){
        return cardDesigner.CardDesign(choixchar(shuffle.get(0)), choixForm(shuffle.get(1)));
    }



    // function getNextCarte(Cartes)
    public static  ArrayList<ArrayList<Integer>> GetNextCarte(ArrayList<ArrayList<Integer>> Cartes){
        ArrayList<ArrayList<Integer>> RestCarte = new ArrayList<>();

        return RestCarte ;
    }

}