import Cartes.Carte;
import Service.GameService;

import static Cartes.Carte.getBlackandGameList;
import static Game.Start_Game.requeststartGame;
import static Service.GameService.CartesReadyToPiocher;

public class Main {
    public static void main(String[] args) {
        GameService service = new GameService();
        getBlackandGameList(CartesReadyToPiocher);
        requeststartGame();
    }


}
