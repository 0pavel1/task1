import java.util.Arrays;

public class task2{
    public static void main(String[] args) {
        System.out.println(duplicateChars("BARACK", "Obama"));
        System.out.println(dividedByThree(new int[] {3, 12, 7, 81, 52}));
        System.out.println(getInitials("simonov sergei evgenievich"));
        System.out.println(Arrays.toString(normalizator(new double[] {3.5, 7.0, 1.5, 9.0, 5.5})));
        System.out.println(Arrays.toString(compressedNums(new double[] {0, 1.6, 0, 212.3, 34.8, 0, 27.5}) ));
        System.out.println(camelToSnake("helloWorld"));
        System.out.println(secondBiggest(new int[] {3, 5, 8, 1, 2, 4}));
        System.out.println(localReverse("ab#cd#ef#gh", '#'));
        System.out.println(equal(8, 1, 8));
        System.out.println(isAnagram("LISTEN", "silent"));
    }
    //1
    public static String duplicateChars(String word1, String word2) {
        String lowWord1 = word1.toLowerCase();
        String lowWord2 = word2.toLowerCase();
        String resultWord = "";
        for(int i=0; i < lowWord1.length(); i++){
            if (!lowWord2.contains(lowWord1.charAt(i) + "")){
                resultWord += word1.charAt(i);
            }
        }

        return resultWord;
    }

    //2
    public static int dividedByThree(int[] numbers){
        int count = 0;
        for (int j = 0; j < numbers.length; j++) {
            if (numbers[j]%2!=0 && numbers[j]%3==0){
                count++;
            }
        }
        return count;
    }

    //3
    public static String getInitials(String FIO){
        String[] massive = new String[3];
        String[] words = FIO.split(" ");
        massive[0] = (words[1].charAt(0) + ".").toUpperCase();
        massive[1] = (words[2].charAt(0) + ".").toUpperCase();
        massive[2] = (words[0].charAt(0) + "").toUpperCase() + words[0].substring(1,words[0].length());
        return String.join("", massive);
    }
    public static double[] normalizator(double[] massive){
        double max = Arrays.stream(massive).max().getAsDouble();
        double min = Arrays.stream(massive).min().getAsDouble();
        for (int i = 0; i < massive.length; i++) {
            massive[i] = (massive[i]-min)/(max-min);
        }         
        return massive;
    }
    
    //5
    public static int[] compressedNums(double[] nums){
        int[] intNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            intNums[i] = (int) nums[i];
        }
        Arrays.sort(intNums);
        int count = 0;
        for (int i : intNums) {
            if (i == 0){
                count++;
            }
            else if(i > 0){
                break;
            }
        }
        return Arrays.copyOfRange(intNums, count, intNums.length);
    }

    //6
    public static String camelToSnake(String str){
        String lowStr = str.toLowerCase();
        String result = new String();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != lowStr.charAt(i)){
                result += "_" + lowStr.charAt(i);
            }
            else{
                result += lowStr.charAt(i);
            }
        }
        return result;
    }

    //7
    public static int secondBiggest(int[] numbers){
        Arrays.sort(numbers);
        return numbers[numbers.length - 2];
    }

    //8
    public static String localReverse(String str, Character symbol){
        String result = "";
        String[] splitS = str.split(symbol+"", -1);
        System.out.println(Arrays.toString(splitS));
        for (int i=0; i<splitS.length; i++) {
            if (i%2==1 && (i!=splitS.length-1 || str.charAt(str.length()-1) == symbol))
                result += new StringBuilder(splitS[i]).reverse();
            else
                result += splitS[i];
            if (i != splitS.length - 1)
                result += symbol;
        }
        return result;
    }

    //9
    public static int equal(int num1, int num2, int num3){
        if (num1 == num2 && num2 == num3)
            return 3;
        if (num1 == num2 || num2 == num3 || num1 == num3) 
            return 2;
        return 0;
    }

    //10
    public static boolean isAnagram(String str1, String str2) {
        str1 = str1.toLowerCase().replaceAll("[^a-z]", "");
        str2 = str2.toLowerCase().replaceAll("[^a-z]", "");
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}