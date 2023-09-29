package Cartes;

import java.util.ArrayList;
import java.util.List;

public class DisperseCard {
   public  ArrayList<ArrayList<Integer>> DealerCard;
   public  ArrayList<ArrayList<Integer>> PlayerCard;
    public  boolean checkNumberCarte = false;

    public  DisperseCard(ArrayList<ArrayList<Integer>> dealerCard, ArrayList<ArrayList<Integer>> playerCard,
                         boolean checkNumberCarte) {
        DealerCard = dealerCard;
        PlayerCard = playerCard;
        this.checkNumberCarte = checkNumberCarte;
    }


}
