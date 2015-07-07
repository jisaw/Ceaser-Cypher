import java.util.*;

public class Main {
    public static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("1) Encode Text\n2) Decode Text");
        int choice = sc.nextInt();
        System.out.println(" ");
        //Ignore remainder of the line
        String ignore = sc.nextLine();

        //Encode Chosen
        if (choice == 1){
            System.out.print("Enter text to be encoded: ");
            String inputText = sc.nextLine();
            char[] text = inputText.toCharArray();
            //System.out.println(text);

            System.out.print("Enter the cypher integer to be used: ");
            int num = sc.nextInt();
            System.out.println(encodeText(text, num));

            //Decode chosen
        } else if (choice ==2){
            System.out.print("Enter the text to be decoded: ");
            char [] text = sc.nextLine().toCharArray();

            System.out.print("Enter the cypher integer used: ");
            int num = sc.nextInt();
            System.out.println(decodeText(text, num));

            //Invalid entry
        } else {
            System.out.println("Please choose either option 1 or option 2");
        }
    }

    //Encodes text using offset num
    public static String encodeText(char[] text, int num) {
        char[] encodedText = new char[text.length];
        for (int i=0; i<text.length; i++){
            if (text[i] == ' ' || text[i] == ',' || text[i] == '.') {
                encodedText[i] = text[i];
            } else {
                for (int j=0; j<alphabet.length; j++){
                    if (alphabet[j] == text[i]){
                        encodedText[i] = alphabet[(j+num)%alphabet.length];
                    }
                }
            }
        }
        String result = new String(encodedText);
        return result;
    }

    //Decodes text using offset num
    public static String decodeText(char[] text, int num) {
        char[] decodedText = new char[text.length];
        for (int i=0; i<text.length; i++){
            if (text[i] == ' ' || text[i] == ',' || text[i] == '.') {
                decodedText[i] = text[i];
            } else {
                for (int j=0; j<alphabet.length; j++){
                    if (alphabet[j] == text[i]){
                        decodedText[i] = alphabet[(j-num)%alphabet.length];
                    }
                }
            }
        }
        String result = new String(decodedText);
        return result;
    }
}
