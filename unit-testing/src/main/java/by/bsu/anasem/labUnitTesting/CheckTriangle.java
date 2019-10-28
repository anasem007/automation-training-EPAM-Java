package by.bsu.anasem.labUnitTesting;

import by.bsu.anasem.labUnitTesting.exception.TriangleException;

public class CheckTriangle {

    public static boolean checkTriangleFormed(double a, double b, double c){

        if(a <= 0 || b <= 0 || c <= 0){ throw new TriangleException("Negative length side passed"); }

        if(a == 0.0 || b == 0.0 || c == 0.0){ throw new TriangleException("Zero side passed"); }

        if(a == Double.NEGATIVE_INFINITY || b == Double.NEGATIVE_INFINITY || c == Double.NEGATIVE_INFINITY){ throw new TriangleException(""); }

        if(Double.compare(a, Double.NaN) * Double.compare(b, Double.NaN) * Double.compare(c, Double.NaN) == 0){ throw new TriangleException(""); }

        if(a == Double.POSITIVE_INFINITY || b == Double.POSITIVE_INFINITY || c == Double.POSITIVE_INFINITY){ throw new TriangleException(""); }

        return check(a, b, c) && check(a, c, b) && check(b, c, a);
    }

    private static boolean check(double x, double y, double z){
        return ((x+y)>z);
    }
}
