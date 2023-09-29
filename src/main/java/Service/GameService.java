package Service;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static Cartes.Carte.*;

public class GameService {

    //  Generate OneCarte and RestCarte
   public static Map<String, ArrayList<ArrayList<Integer>>> OneandRestCarte = GetOne_Rest_Carte(getALLcartes());
  public  static ArrayList<ArrayList<Integer>> OneCarte = OneandRestCarte.get("OneCarte");
   public static ArrayList<ArrayList<Integer>> RestCarte = OneandRestCarte.get("RestCarte");


    //  Shuffle RestCarte
   public static ArrayList<ArrayList<Integer>> Shuffle_cartes = Shuffle_cartes(RestCarte);

    //  Create CartesReadyToPiocher by combining Shuffle_cartes and OneCarte
   public static ArrayList<ArrayList<Integer>> CartesReadyToPiocher = Stream.concat(OneCarte.stream(), Shuffle_cartes.stream())
            .collect(Collectors.toCollection(ArrayList::new));
    //  PiocherCarte
 //  public static Map<String, ArrayList<ArrayList<Integer>>> PiocherCarte = Piocher_une_carte(CartesReadyToPiocher);


}
