package Console;

import java.util.ArrayList;
import java.util.Map;

import static Console.Colore.*;
import static Console.forms.choixForm;
import static Console.forms.choixchar;

public class CardDesigner {


    public static String CardDesignList(ArrayList<ArrayList<Integer>> List , boolean dealercarteHide) {

        String Design ="", DesignA ="" , DesignB ="", DesignC= "", DesignD ="", DesignE ="", DesignF ="", DesignG ="" ,
                c ,f, color ;
        for (int i = 0; i < List.size(); i++) {
            if(dealercarteHide == true && i == 0){
                c = choixchar(14);
                Map<String, String> result = choixForm(5);
                f = result.get("symbol");
                color = result.get("color");
                DesignA += color + "╔══════════╗    " + RESET;
                DesignB += color + "║ " + c + "       ║    "+ RESET;
                DesignC += color + "║   " + f + "      ║    "+ RESET;
                DesignD += color + "║          ║    "+ RESET;
                DesignE += color + "║      " + f + "   ║    "+ RESET;
                DesignF += color + "║       " + c + " ║    "+ RESET;
                DesignG += color + "╚══════════╝    " + RESET;

            }else{
                 c = choixchar(List.get(i).get(0));
                Map<String, String> res = choixForm(List.get(i).get(1));
                f = res.get("symbol");
                color = res.get("color");
                DesignA += color + "╔══════════╗    " + RESET;
                DesignB += color + "║ " + c + "       ║    "+ RESET;
                DesignC += color + "║   " + f + "      ║    "+ RESET;
                DesignD += color + "║          ║    "+ RESET;
                DesignE += color + "║      " + f + "   ║    "+ RESET;
                DesignF += color + "║       " + c + " ║    "+ RESET;
                DesignG += color + "╚══════════╝    " + RESET;
            }
        }

        Design = DesignA+"\n"+
                 DesignB+"\n"+
                 DesignC+"\n"+
                 DesignD+"\n"+
                 DesignE+"\n"+
                 DesignF+"\n"+
                 DesignG+"\n" ;
        System.out.print(
                Design
        );
        System.out.println(RESET);
        return Design;
    }


}
