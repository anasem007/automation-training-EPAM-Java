package by.bsu.anasem.lab_unit_testing;

public class CheckTriangle {

    public static boolean checkTriangleFormed(double a, double b, double c){

        if (a <= 0 || b <= 0 || c <= 0) return false;
        return (check(a, b, c) && check(a, c, b) && check(b, c, a));

    }

    private static boolean check(double x, double y, double z){
        return ((x+y)>z);
    }
}
