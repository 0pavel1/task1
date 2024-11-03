import java.util.*;

public class task4 {

    // 1
    public static String nonRepeat(String str) {
        Map<Character, Integer> charCounts = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (char c : str.toLowerCase().toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        for (char c : str.toCharArray()) {
            if (charCounts.get(Character.toLowerCase(c)) <= 3) {
                result.append(c);
            }
        }

        return result.toString();
    }

    // 2
    public static List<String> bruteForce(int n, int k) {
        List<String> result = new ArrayList<>();
        
        generateCombinations(n, k, "", result);
        return result;
    }

    private static void generateCombinations(int n, int k, String current, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        for (int i = 0; i < k; i++) {
            if (!current.contains(i + "")) {
                generateCombinations(n, k, current + i, result);
            }
        }
    }


    // 3
    public static String encode(int[] nums, String key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i<key.length(); i++) {
            result.append((char) (nums[i] ^ key.charAt(i)));
        }
        return result.toString();
    }

    public static int[] decode(String ciphertext, String key) {
        int[] result = new int[ciphertext.length()];
        for (int i = 0; i<key.length(); i++) {
            result[i] = (ciphertext.charAt(i) ^ key.charAt(i));
        }
        return result;
    }


    // 4
    public static List<String> split(String str) {
        List<String> result = new ArrayList<>();
        int balance = 0;
        int start = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                balance++;
            } else if (str.charAt(i) == ')') {
                balance--;
            }

            if (balance == 0) {
                result.add(str.substring(start, i + 1));
                start = i + 1;
            }
        }

        return result;
    }

    // 5
    public static String shortHand(String str) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                result.append(str.charAt(i));
                if (count > 1) {
                    result.append("*").append(count);
                }
                count = 1;
            }
        }

        return result.toString();
    }

    // 6
    public static String convertToRome(int num) {
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }

    // 7
    public static String uniqueSubstring(String str) {
        Map<Character, Integer> charCounts1 = new HashMap<>();
        Map<Character, Integer> charCounts2 = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                charCounts1.put(str.charAt(i), charCounts1.getOrDefault(str.charAt(i), 0) + 1);
            } else {
                charCounts2.put(str.charAt(i), charCounts2.getOrDefault(str.charAt(i), 0) + 1);
            }
        }

        int maxCount1 = 0;
        char maxChar1 = ' ';
        for (char c : charCounts1.keySet()) {
            if (charCounts1.get(c) > maxCount1) {
                maxCount1 = charCounts1.get(c);
                maxChar1 = c;
            }
        }

        int maxCount2 = 0;
        char maxChar2 = ' ';
        for (char c : charCounts2.keySet()) {
            if (charCounts2.get(c) > maxCount2) {
                maxCount2 = charCounts2.get(c);
                maxChar2 = c;
            }
        }

        if (maxCount1 > maxCount2)
            return "нечет";
        else if(maxCount1 < maxCount2)
            return "чет";
        else
            return str.indexOf(maxChar1) < str.indexOf(maxChar2) ? "чет" : "нечет";
    }

    // 8
    public static List<String> labirint(int[][] maze) {
        String[] result = new String[] {"", Integer.MAX_VALUE + ""};
        findWay(maze, 0, 0, new StringBuilder(maze[0][0]+""), maze[0][0], result);
        return result[0].isEmpty()?List.of("Прохода нет"):List.of(result[0], result[1]);
    }
    private static void findWay(int[][] maze, int i, int j, StringBuilder path, int dist, String[] result) {
        if (i == maze.length - 1 && j == maze.length - 1) {
            if (dist < Integer.parseInt(result[1])){
                result[0] = path.reverse().toString(); 
                result[1] = dist + "";
            }
            return;
        }
        if (i < maze.length - 1 && maze[i + 1][j] > 0) {
            path.append("-" + maze[i + 1][j]);
            findWay(maze, i + 1, j, path, dist + maze[i + 1][j], result);
            path.delete(path.length() - ("-" + maze[i + 1][j]).length(), path.length());
        }
        if (j < maze.length - 1 && maze[i][j + 1] > 0) {
            path.append("-" + maze[i][j + 1] + "");
            findWay(maze, i, j + 1, path, dist + maze[i][j + 1], result);
            path.delete(path.length() - ("-" + maze[i][j+1]).length(), path.length());
        }
    }


    // 9
    public static String numericOrder(String str) {
        String[] words = str.split(" ");
        String[] orderedWords = new String[words.length];

        for (String word : words) {
            int num = Integer.parseInt(word.replaceAll("[^0-9]", "")) - 1;
            orderedWords[num] = word.replaceAll("[0-9]", "");
        }

        return String.join(" ", orderedWords);
    }

    // 10
    public static boolean fibString(String str) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : str.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        boolean flag = false;
        for (int val : counts.values()) {
            if (val != 1 && !isFibonacci(val)) {
                return false;
            }
            else if (val != 1) {
                flag = true;
            }
        }

        return flag;

    }

    private static boolean isFibonacci(int n) {
        int a = 0;
        int b = 1;
        while (b < n) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b == n;
    }



    public static void main(String[] args) {
        System.out.println(nonRepeat("abracadabra")); 
        System.out.println(nonRepeat("abababcac")); 



        System.out.println(bruteForce(1,5)); 
        System.out.println(bruteForce(2,2)); 
        System.out.println(bruteForce(5,2)); 


        System.out.println(encode(new int[]{0, 31, 28, 10, 29}, "MKIIT")); 
        System.out.println(Arrays.toString(decode("MTUCI", "MKIIT"))); 

        System.out.println(split("()()()")); 
        System.out.println(split("((()))")); 
        System.out.println(split("((()))(())()()(()())")); 


        System.out.println(shortHand("abbc"));  
        System.out.println(shortHand("vvvvaajaaaaa"));

        System.out.println(convertToRome(8));   
        System.out.println(convertToRome(1234)); 

        System.out.println(uniqueSubstring("31312131")); 
        System.out.println(uniqueSubstring("211212")); 



        System.out.println(labirint(new int[][]{{1, 3, 1}, {1, -1, 1}, {4, 2, 1}}));  
        System.out.println(labirint(new int[][]{{2, -7, 3}, {-4, -1, 8}, {4, 5, 9}})); 

        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng")); 
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat")); 

        System.out.println(fibString("CCCABDD")); 
        System.out.println(fibString("ABC"));   
    }
}