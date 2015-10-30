public class ReverseStringWithoutTempStrings{

    public static void main(String[] args) {
        String allTheStringThings = "?gnihtemos ro yadrutas ot yadsruht txen kcoc ym gnilgguns tuoba leef uoy od woh oS";
        int stringLength = allTheStringThings.length() - 1;
        char charAtEnd;
        for (int currentChar = 0; currentChar < stringLength; currentChar++) {
            charAtEnd = allTheStringThings.charAt(stringLength);
            allTheStringThings = removeLastCharacter(allTheStringThings);
            allTheStringThings = allTheStringThings.substring(0, currentChar) + charAtEnd + allTheStringThings.substring(currentChar, stringLength);
        }
        System.out.println(allTheStringThings);
    }

    public static String removeLastCharacter (String stringToEdit) {
        return stringToEdit.substring(0, stringToEdit.length() - 1); 
    }
   
}
