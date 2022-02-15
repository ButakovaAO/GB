package org.example;

public class FormulaSquareTriangle {

    public static int triangleSquare(int a, int b, int c) {

        if ((a==0) | (b==0) | (c==0)) throw new NullPointerException();
        if ((a<0) | (b<0) | (c<0)) throw new NullPointerException();
        if ((a + b < c) | (a + c < b) | (b + c < a)) throw new NullPointerException();

        int p = (a + b + c)/2;
        int s = (int) Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return s;
    }

}
