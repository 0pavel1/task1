import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class task5 {

    // 1
    public static boolean sameLetterPattern(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Character> mapping = new HashMap<>();
        Map<Character, Character> reverseMapping = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (!mapping.containsKey(c1)) {
                if(reverseMapping.containsKey(c2)) return false;
                mapping.put(c1, c2);
                reverseMapping.put(c2,c1);
            } else if (mapping.get(c1) != c2) {
                return false;
            }
        }

        return true;
    }

    // 2
    public static int memeSum(int a, int b) {
        String strA = String.valueOf(a);
        String strB = String.valueOf(b);
        String result = "";

        int lenA = strA.length();
        int lenB = strB.length();
        int maxLen = Math.max(lenA, lenB);

        for (int i = 0; i < maxLen; i++) {
            int digitA = (i < lenA) ? strA.charAt(lenA - 1 - i) - '0' : 0;
            int digitB = (i < lenB) ? strB.charAt(lenB - 1 - i) - '0' : 0;
            result = (digitA + digitB) + result;
        }

        return Integer.parseInt(result);
    }

    // 3
    public static int digitsCount(long n) {
        if (n < 10) {
            return 1;
        } else {
            return 1 + digitsCount(n / 10);
        }
    }

    // 4
    public static int totalPoints(String[] words, String scramble) {
        int score = 0;
        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < scramble.length(); i++) {
            charCount.put(scramble.charAt(i), charCount.getOrDefault(scramble.charAt(i), 0) + 1);
        }

        for (String word : words) {
            boolean flag = true;
            Map<Character, Integer> tempCharCount = new HashMap<>(charCount);

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (tempCharCount.getOrDefault(c, 0) == 0) {
                    flag = false;
                    break;
                }
                tempCharCount.put(c, tempCharCount.get(c) - 1);
            }

            if (flag) {
                int wordLength = word.length();
                if (wordLength == 6) {
                    score+=54;
                }else
                    score += (wordLength > 2)? wordLength-2: 0;
            }
        }
        return score;
    }

    // 5
    public static int longestRun(int[] arr) {
        if (arr.length <= 1) {
            return arr.length;
        }
        int longest = 1;
        int current = 1;
        int sign = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1 && sign >= 0) {
                current++;
                sign = 1;
            } else if (arr[i] == arr[i-1] - 1 && sign <= 0){
                current++;
                sign = -1;
            } else {
                longest = Math.max(longest, current);
                current = 1;
                sign = 0;
            }
        }

        return Math.max(longest, current);
    }

    // 6
    public static String takeDownAverage(String[] scores) {
        double sum = 0;
        for (String score : scores) {
            sum += Double.parseDouble(score.substring(0, score.length() - 1));
        }

        double currentAvg = sum / scores.length;
        double newAvg = currentAvg - 5;
        double newScore = newAvg * (scores.length + 1) - sum;

        return Math.round(newScore) + "%";
    }

    // 7
    public static boolean canMove(String piece, String start, String end) {
        int startRow = 8 - (start.charAt(1) - '0'); 
        int startCol = start.charAt(0) - 'A';
        int endRow = 8 - (end.charAt(1) - '0');
        int endCol = end.charAt(0) - 'A';

        switch (piece.toLowerCase()) {
            case "rook":  // Ладья
                return startRow == endRow || startCol == endCol;
            case "bishop": // Слон
                return Math.abs(startRow - endRow) == Math.abs(startCol - endCol);
            case "queen": // Ферзь
                return startRow == endRow || startCol == endCol || Math.abs(startRow - endRow) == Math.abs(startCol - endCol);
            case "king": // Король
                return Math.abs(startRow - endRow) <= 1 && Math.abs(startCol - endCol) <= 1;
            case "knight": // Конь
                return (Math.abs(startRow - endRow) == 2 && Math.abs(startCol - endCol) == 1) ||
                        (Math.abs(startRow - endRow) == 1 && Math.abs(startCol - endCol) == 2);
            case "pawn": // Пешка
                return startCol == endCol && startRow - endRow == 1;
            default:
                return false;
        }
    }

    // 8
    public static int maxPossible(int n1, int n2) {
        String n1Str = String.valueOf(n1);
        char[] n1Chars = n1Str.toCharArray();
        String n2Str = String.valueOf(n2);

        List<Character> sortedN2 = n2Str.chars()
                .mapToObj(c -> (char) c)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        for (int i = 0; i < n1Chars.length && !sortedN2.isEmpty(); i++) {
            char digitN1 = n1Chars[i];
            Character maxN2 = sortedN2.get(0);

            if (maxN2 > digitN1) {
                n1Chars[i] = maxN2;
                sortedN2.remove(0);
            }
        }
        return Integer.parseInt(new String(n1Chars));
    }

    // 9
    public static String timeDifference(String cityA, String timestamp, String cityB) {
        Map<String, Integer> gmtOffsets = new HashMap<>();
        gmtOffsets.put("Los Angeles", -8 * 60);
        gmtOffsets.put("New York", -5 * 60);
        gmtOffsets.put("Caracas", -4 * 60 - 30);
        gmtOffsets.put("Buenos Aires", -3 * 60);
        gmtOffsets.put("London", 0);
        gmtOffsets.put("Rome", 60);
        gmtOffsets.put("Moscow", 3 * 60);
        gmtOffsets.put("Tehran", 3 * 60 + 30);
        gmtOffsets.put("New Delhi", 5 * 60 + 30);
        gmtOffsets.put("Beijing", 8 * 60);
        gmtOffsets.put("Canberra", 10 * 60);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm", Locale.US);
        LocalDateTime dateTimeA = LocalDateTime.parse(timestamp, formatter);

        ZonedDateTime zonedDateTimeA = ZonedDateTime.of(dateTimeA, ZoneId.of("UTC"));

        int offsetA = gmtOffsets.get(cityA);
        int offsetB = gmtOffsets.get(cityB);

        zonedDateTimeA = zonedDateTimeA.plusMinutes(offsetB - offsetA);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm");

        return zonedDateTimeA.format(outputFormatter);
    }


    // 10
    public static boolean isNew(int n) {
        String nStr = String.valueOf(n);
        char[] digits = nStr.toCharArray();
        Arrays.sort(digits);

        int start = 1;
        for (int i = 1; i < nStr.length(); i++) {
            start *= 10; 
        }

        for (int i = start; i < n; i++) {
            String iStr = String.valueOf(i);
            char[] iDigits = iStr.toCharArray();
            Arrays.sort(iDigits);

            if (Arrays.equals(digits, iDigits)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("//1");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println("//2");
        System.out.println(memeSum(26, 39));  
        System.out.println(memeSum(1222, 30277) );

        System.out.println("//3");
        System.out.println(digitsCount(4666));  
        System.out.println(digitsCount(1289396387328L)); 

        System.out.println("//4");
        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
        System.out.println("//5");
        System.out.println(longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9})); 
        System.out.println(longestRun(new int[]{5, 4, 2, 1})); 

        System.out.println("//6");
        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"})); 
        System.out.println("//7");
        System.out.println(canMove("Rook", "A8", "H8")); 
        System.out.println(canMove("Bishop", "A7", "G1")); 
        System.out.println(canMove("Pawn", "C2", "C1")); 
        System.out.println("//8");
        System.out.println(maxPossible(9328, 456)); 
        System.out.println("//9");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));  
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome")); 
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing") );

        System.out.println("//10");
        System.out.println(isNew(321));
        System.out.println(isNew(123)); 
    }
}