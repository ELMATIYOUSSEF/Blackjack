
import java.util.ArrayList;
import java.util.Map;

import static Cartes.carte.*;
import static Game.Start_Game.startGame;

public class Main {
    public static void main(String[] args) {

        Map<String,ArrayList<ArrayList<Integer>>> OneandRestCarte = tirer_une_carte(getALLcartes());

        ArrayList<ArrayList<Integer>> OneCarte =OneandRestCarte.get("OneCarte");
        ArrayList<ArrayList<Integer>> RestCarte =OneandRestCarte.get("RestCarte");
        for(ArrayList<Integer> carte :RestCarte){
            System.out.println(DesignCarte(carte));
        }

        ArrayList<ArrayList<Integer>> Shuffle_cartes = Shuffle_cartes( RestCarte);

        ArrayList<ArrayList<Integer>> CartesReadyToPiocher = makeCarteUpOfREstCartes(Shuffle_cartes ,OneCarte);

        Map<String,ArrayList<ArrayList<Integer>>> PiocherCarte = Piocher_une_carte(CartesReadyToPiocher);

        ArrayList<ArrayList<Integer>> BlackList =PiocherCarte.get("BlackList");
        ArrayList<ArrayList<Integer>> GameCartes =PiocherCarte.get("GameCartes");


        startGame();
    }


}
