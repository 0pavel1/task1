import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task3 {
    public static void main(String[] args) {
        System.out.println("1. " + isStrangePair("lox", "xoookjl"));
        System.out.println("2.");
        List<Object[]> products = Arrays.asList(new Object[]{"Laptop", 124200}, new Object[]{"Phone", 51450}, new Object[]{"Headphones", 13800});
        for(Object[] product : sale(products, 25))
            System.out.println(Arrays.toString(product));
        System.out.println("3. " + sucsessShoot(0, 0, 5, 3,3 ));
        System.out.println("4. " + parityAnalysis(243));
        System.out.println("5. " + rps("paper", "paper"));
        System.out.println("6. " + bugger(4));
        List<Object[]> items = Arrays.asList(new Object[] {"Скакалка", 550, 8}, new Object[] {"Шлем", 3750, 4},new Object[] {"Мяч", 2900, 10});
        System.out.println("7. " + mostExpensive(items));
        System.out.println("8. " + longestUnique("bbb"));
        System.out.println("9. " + isPrefix("retrospect", "retro-") + " " + isSuffix("vocation", "-tion"));
        System.out.println("10. " + doesBrickFit(1, 2, 2, 1, 1));
    }

    //1
    public static boolean isStrangePair(String str1, String str2){
        return (str1.length() == 0 && str2.length() == 0) ||
               (str1.length() >= 1 && str2.length() >= 1 
               && str1.charAt(0) == str2.charAt(str2.length() - 1) 
               && str2.charAt(0) == str1.charAt(str1.length() - 1));
    }

    //2
    public static List<Object[]> sale(List<Object[]> massive, int num){
        List<Object[]> result = new ArrayList<>();
        for (Object[] product : massive) {
            int newPrice = (int) Math.round((int) product[1] * (1 - num / 100.0));

            newPrice = Math.max(newPrice, 1);
            result.add(new Object[]{product[0], newPrice});
        }
        return result;
    }

    //3
    public static boolean sucsessShoot(int x0, int y0, int r, int x, int y){
        return Math.sqrt(Math.pow((x - x0), 2) + Math.pow((y - y0), 2)) < r;
    }

    //4
    public static boolean parityAnalysis(int num){
        int sum = 0; 
        int temp = num;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return num % 2 == sum % 2;
    }

    //5
    public static String rps(String player1, String player2){
        if (player1.equals(player2))
            return "Tie";
        if (player1.equals("rock") && player2.equals("scissors") 
            || player1.equals("paper") && player2.equals("rock") 
            || player1.equals("scissors") && player2.equals("paper"))
            return "Player 1 wins";
        return "Player 2 wins";
    }

    //6
    public static int bugger(int num){
        int count = 0;
        while (num >= 10){
            int temp = num;
            num = 1;
            while (temp > 0){
                num *= temp%10;
                temp /= 10;
            }
            count++;
        }
        return count;
    }

    //7
    public static String mostExpensive(List<Object[]> massive){
        int maxV = 0;
        String item = "";
        for (Object[] object : massive) {
            int value = (int) object[2] * (int) object[1];
            if(value > maxV){
                maxV = value;
                item = (String) object[0];
            }
        }
        return "Наиб. общ. стоимость у предмета " + item + " - " + maxV;
    }

    //8
    public static String longestUnique(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            String temp = "";
            for (int j = i; j < str.length(); j++) {
                String c = str.charAt(j) + "";
                if (temp.contains(c)) break;
                temp += c;
            }
            if (temp.length() > result.length()) {
                result = temp;
            }
        }
        return result;
    }

    //9
    public static boolean isPrefix(String str, String prefix) {
        return str.startsWith(prefix.substring(0, prefix.length() - 1));
    }
    public static boolean isSuffix(String str, String suffix) {
        return str.endsWith(suffix.substring(1));
    }

    //10
    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return (a <= w && b <= h) || (b <= w && a <= h) ||
               (a <= w && c <= h) || (c <= w && a <= h) ||
               (b <= w && c <= h) || (c <= w && b <= h);
    }
}
