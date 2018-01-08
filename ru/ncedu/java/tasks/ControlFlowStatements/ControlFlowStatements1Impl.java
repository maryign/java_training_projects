package ru.ncedu.java.tasks.ControlFlowStatements;

/**
 * Created by Mari on 28.02.2016.
 */

public class ControlFlowStatements1Impl implements ControlFlowStatements1 {
    public ControlFlowStatements1Impl() {
    }

    /**
     * Для данного вещественного x найти значение следующей функции f, принимающей вещественные значения:<br/>
     * <pre>
     *        | 2*sin(x), если x>0,
     *  f(x)= |
     *        | 6-x, если x<=0.
     * </pre>
     *
     * @return значение f.
     */
    @Override
    public float getFunctionValue(float x) {
        float f;
        if (x > 0) {
            f = (float) (2 * Math.sin(x));
        } else
            f = 6 - x;
        return f;
    }

    /**
     * Дано целое число в диапазоне 1–7.
     * Вернуть строку — название дня недели, соответствующее этому числу:<br/>
     * 1 — Monday, 2 — Tuesday, 3 - Wednesday, 4 - Thursday, 5 - Friday, 6 - Saturday, 7 - Sunday.
     *
     * @param weekday
     * @return строковое представление weekday
     */
    @Override
    public String decodeWeekday(int weekday) {
        switch (weekday) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
        }
        return null;
    }

    /**
     * Создать двумерный массив, содержащий 8x5 целочисленных элементов,
     * и присвоить каждому элементу произведение его индексов: array[i][j] = i*j.
     *
     * @return массив.
     */
    @Override
    public int[][] initArray() {
        int[][] array = new int[8][5];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = i * j;
            }
        }
        return array;
    }

    /**
     * Найти минимальный элемент заданного двумерного массива.
     *
     * @param array массив, содержащий как минимум один элемент
     * @return минимальный элемент массива array.
     */

    @Override
    public int getMinValue(int[][] array) {
        //array = new int[8][5];
        int min = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < min)
                    min = array[i][j];
            }
        }
        return min;
    }

    /**
     * Начальный размер вклада в банке равен $1000.
     * По окончанию каждого года размер вклада увеличивается на P процентов (вклад с капитализацией процентов).<br/>
     * По заданному P определить, через сколько лет размер вклада превысит $5000, а также итоговый размер вклада.
     *
     * @param P процент по вкладу
     * @return информация о вкладе (в виде экземпляра класса {@link BankDeposit}) после наступления вышеуказанного условия
     */
    @Override
    public BankDeposit calculateBankDeposit(double P) {
        BankDeposit bd = new BankDeposit();
        bd.years = 0;
        bd.amount = 1000;

        while (bd.amount < 5000) {

            bd.amount = bd.amount + (bd.amount * P) / 100;
            bd.years++;
//            break;
        }

        return bd;
    }

    public static void main(String[] args) {
        ControlFlowStatements1Impl obj = new ControlFlowStatements1Impl();
        int arr[][] = obj.initArray();

        System.out.println(obj.calculateBankDeposit(12.5));
    }
}