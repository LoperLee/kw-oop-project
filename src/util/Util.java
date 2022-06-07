package util;

public class Util {
    // 더블이 Integer로 변환이 가능한지 확인하는 메소드
    public static boolean isInteger(double a) {
        return a == (int)a;
    }

    // 더블을 소수점 3자리까지 나오는 String 혹은 소수점이 없는 String으로 만들어주는 메소드
    public static String convertNumberToString(double a) {
        // Integer면 소수점 없이!
        if (isInteger(a))
            return String.valueOf((int)a);
        // double 이면 소수점 3자리 까지만!
        return String.format("%.3f", a);
    }
}
