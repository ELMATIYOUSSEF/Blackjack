package Console;

public class forms {

    public static String choixForm(int choixForm){
        String suitSymbol="" ;
        switch (choixForm){
            case 1: suitSymbol = "♣"; break;
            case 2: suitSymbol = "♦"; break;
            case 3: suitSymbol = "♥"; break;
            case 4: suitSymbol = "♠"; break;
        }
        return suitSymbol ;
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
        }
        return suitSymbol ;
    }
    
}