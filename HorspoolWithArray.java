import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HorspoolWithArray {
    
    // horspool
    public static int patternMatch(String text, String pattern) {
        HashMap<Character, Integer> hashMap = getShiftTable(pattern);

        int patternLength = pattern.length();
        int textLength = text.length();

        int i, j;
        Integer shift;
        
        for (i = patternLength - 1; i < textLength; shift =hashMap.get(text.charAt(i)),  i += shift != null? shift: patternLength ) {
            for (j = 0; (j < patternLength) && (text.charAt(i - j) == pattern.charAt(patternLength - 1 - j)); j++) ;
            if (j == patternLength)
                return i - patternLength + 1;
        }
        return -1;
    }

    private static HashMap<Character, Integer> getShiftTable(String pattern) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int len = pattern.length();

        // PERULANGAN INI UNTUK MEMBERIKAN VALUE DARI TIAP-TIAP CHAR YANG ADA DI PATTERN
        // RUMUS
        // VALUE = LEN - INDEX - 1
        for (int i = 0; i < len - 1; i++)
            hashMap.put(pattern.charAt(i), len - 1 - i);
        return hashMap;
    }


    public static void main(String[] args) {
        ArrayList<String> footballers = new ArrayList<>();
        footballers.add("M. Owen");
        footballers.add("S. Gerrard");
        footballers.add("M. Rashford");
        footballers.add("J. Sancho");
        footballers.add("C. Ronaldo");
        footballers.add("Ronaldinho G.");
        footballers.add("Rivaldo");
        footballers.add("Fernando Torres");
        footballers.add("Ronaldo");
        footballers.add("Diego Maradona");

        System.out.print("Cari Pemain : "); 
        String pattern = new Scanner(System.in).nextLine();

        for(int i = 0; i < footballers.size();i++){
            String text = footballers.get(i).toLowerCase();
            int position = patternMatch(text, pattern);

            if (position != -1)
            System.out.println(footballers.get(i));
        }
        
        
    }
}
