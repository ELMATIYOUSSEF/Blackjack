import Cartes.Carte;
import Service.GameService;

import java.util.ArrayList;
import java.util.Arrays;

import static Cartes.Carte.*;
import static Game.Start_Game.requeststartGame;
import static Service.GameService.CartesReadyToPiocher;

public class Main {
    public static void main(String[] args) {
        // test function nextCards
        int[] myNum = { 5, 2 };
        int[][] nextCards = GetNextCard(myNum);
        System.out.println("+---------------+");
        GameService service = new GameService();
        getBlackandGameList(CartesReadyToPiocher);
        requeststartGame();
    }


}
