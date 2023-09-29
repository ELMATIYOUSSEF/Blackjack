package Console;

import java.util.ArrayList;

import static Console.forms.choixForm;
import static Console.forms.choixchar;

public class CardDesigner {


    public static String CardDesignList(ArrayList<ArrayList<Integer>> List , boolean dealercarteHide) {

        String Design ="", DesignA ="" , DesignB ="", DesignC= "", DesignD ="", DesignE ="", DesignF ="", DesignG ="" ,c ,f ;
        for (int i = 0; i < List.size(); i++) {
            if(dealercarteHide == true && i == 0){
                c = choixchar(14);   f=choixForm(5);
                DesignA += "╔══════════╗    ";
                DesignB += "║ " + c + "       ║    ";
                DesignC += "║   " + f + "      ║    ";
                DesignD += "║          ║    ";
                DesignE += "║      " + f + "   ║    ";
                DesignF += "║       " + c + " ║    ";
                DesignG += "╚══════════╝    ";

            }else{
                 c = choixchar(List.get(i).get(0));   f=choixForm(List.get(i).get(1));


             DesignA += "╔══════════╗    ";
             DesignB += "║ " + c + "       ║    ";
             DesignC += "║   " + f + "      ║    ";
             DesignD += "║          ║    ";
             DesignE += "║      " + f + "   ║    ";
             DesignF += "║       " + c + " ║    ";
             DesignG += "╚══════════╝    ";
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
        return Design;
    }


}
