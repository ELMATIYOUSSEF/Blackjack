package Console;

import java.util.HashMap;
import java.util.Map;

import static Console.Colore.*;

public class forms {

public static Map<String, String> choixForm(int choixForm){
        String suitSymbol="" ;
        String color  = "";
        switch (choixForm){
            case 1:
                color = BLEU; suitSymbol = "♣"; break;
            case 2:
                color = RED; suitSymbol = "♦"; break;
            case 3:
                color = RED; suitSymbol = "♥";break;
            case 4:
                color = BLEU; suitSymbol = "♠"; break;
            case 5:
                color = Yellow;suitSymbol = "*"; break;
        }
        Map <String, String> result = new HashMap<>();
        result.put("color", color);
        result.put("symbol", suitSymbol);
    return result ;
    }
    public static String choixchar(int choix){
        String suitSymbol="" ;
        switch (choix){
            case 1: suitSymbol = " A"; break;
            case 2: suitSymbol = " 2"; break;
            case 3: suitSymbol = " 3"; break;
            case 4: suitSymbol = " 4"; break;
            case 5: suitSymbol = " 5"; break;
            case 6: suitSymbol = " 6"; break;
            case 7: suitSymbol = " 7"; break;
            case 8: suitSymbol = " 8"; break;
            case 9: suitSymbol = " 9"; break;
            case 10: suitSymbol = "10"; break;
            case 11: suitSymbol = " J"; break;
            case 12: suitSymbol = " Q"; break;
            case 13: suitSymbol = " K"; break;
            case 14: suitSymbol = " *"; break;
        }
        return suitSymbol ;
    }
    
}
