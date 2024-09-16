public class Task {
    public static void main(String[] args) {
        System.out.println(tables(11, 2));
    }
    // 1
    public static double convert(int num) {
        return 3.785 * num;
    }

    // 2
    public static int fitCalc(int min, int level) {
        return min * level;
    }

    // 3
    public static int containers(int boxes, int bags, int barrels) {
        return boxes * 20 + bags * 50 + barrels * 100;
    }

    // 4
    public static String triangleType(int x, int y, int z) {
        if (x + y < z || x + z < y || z + y < x) {
            return "Это не треугольник";
        }
        if (x == y && y == z) {
            return "Это равностороний треугольник";
        }
        if (x == y || y == z || z == x) {
            return "Это равнобедренный треугольник";
        }
        return "Это треугольник";
    }

    // 5
    public static int ternaryEvaluation(int a, int b) {
        return a > b ? a : b;
    }

    // 6
    public static int howManyItems(int S, double h, double w) {
        return (int) (S / (h * w * 2));
    }

    // 7
    public static int factorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    // 8
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 9
    public static long ticketSaler(int num, int price) {
        double fee = 0.72;
        return Math.round(fee * num * price);
    }

    // 10
    public static int tables(int students, int numTables) {
        students -= (2*numTables);
        if (students <= 0) {
            return 0;
        }
        return (int) Math.ceil((double)students/2);
    }
}
