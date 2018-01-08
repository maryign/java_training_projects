package ru.ncedu.java.tasks.ControlFlowStatements;

/**
 * Created by Mari on 05.03.2016.
 */
public class ControlFlowStatements3Impl implements ControlFlowStatements3 {
    public ControlFlowStatements3Impl() {
    }

    @Override
    public double getFunctionValue(double x) {
        double f;
        if (x <= 0)
            f = -x;
        else if (x > 0 && x < 2)
            f = Math.pow(x, 2);
        else f = 4;
        return f;
    }

    @Override
    public String decodeSeason(int monthNumber) {
        if (monthNumber < 1 | monthNumber > 12)
            return "Error";
        int i = 4;
        String Season[] = {"Winter", "Spring", "Summer", "Autumn"};
        switch (monthNumber) {
            case 1:
                return Season[0];
            case 2:
                return Season[0];
            case 3:
                return Season[1];
            case 4:
                return Season[1];
            case 5:
                return Season[1];
            case 6:
                return Season[2];
            case 7:
                return Season[2];
            case 8:
                return Season[2];
            case 9:
                return Season[3];
            case 10:
                return Season[3];
            case 11:
                return Season[3];
            case 12:
                return Season[0];

        }
        return String.valueOf(monthNumber);
    }

    @Override
    public long[][] initArray() {
        long[][] arr = new long[8][5];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = (long) Math.pow((Math.abs(i - j)), 5);
            }
        }

        return arr;
    }

    @Override
    public int getMaxProductIndex(long[][] array) {
        int index = 0;
        long res = 0;
        long mult = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (i + 1) * (j + 1);
//            }
//            for (int j = 0; j <  array[i].length; j++) {
                mult *= Math.abs(array[i][j]);

                if (mult > res) {
                    res = mult;
                }
                index = i;
            }
        }
        return index;
    }

    @Override
    public float calculateLineSegment(float A, float B) {

        float line = A - B;
        while (line >= B) {
            line = line - B;
        }

        return line;
    }

    public static void main(String[] args) {
        ControlFlowStatements3Impl imp = new ControlFlowStatements3Impl();
        long arr[][] = new long[3][10];
        System.out.println(imp.calculateLineSegment(10.5f, 3.5f));

        System.out.println(imp.decodeSeason(1));
        System.out.println(imp.getFunctionValue(5.6));
        System.out.println(imp.initArray());
        System.out.println(imp.getMaxProductIndex(arr));

    }
}