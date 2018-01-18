package com.lsq.service.java8;

public class LambdaService {

    public static void main(String[] args) {
        LambdaService l = new LambdaService();

        MathOperation mathOperation = (a, b) -> {
            return a + b;
        };

        int re = l.operate(1, 2, mathOperation);
        System.out.println(re);
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
