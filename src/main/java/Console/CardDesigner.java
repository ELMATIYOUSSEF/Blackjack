package Console;

public class CardDesigner {

        public String CardDesign(String c, String f) {
            String[] cardDesign = {
                    "╔══════════╗",
                    "║ " + c + "       ║",
                    "║   " + f + "      ║",
                    "║          ║",
                    "║      " + f + "   ║",
                    "║       " + c + " ║",
                    "╚══════════╝"
            };

            StringBuilder card = new StringBuilder();
            for (String line : cardDesign) {
                card.append(line).append("\n");
            }

            return card.toString();
        }

}
