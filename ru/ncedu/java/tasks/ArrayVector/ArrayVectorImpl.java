package ru.ncedu.java.tasks.ArrayVector;

import java.util.Arrays;

/**
 * Created by Mari on 26.02.2016.
 */
public class ArrayVectorImpl implements ArrayVector {

    private double vector[];

    public ArrayVectorImpl() {
    }
    public ArrayVectorImpl(double vector[]) {
        this.vector = vector;
    }

    @Override
    public void set(double... elements) {
        this.vector = elements;

    }

    @Override
    public double[] get() {
        return vector;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < vector.length; i++) {
            str += vector[i] + " ";
        }
        return str;
    }

    @Override
    public ArrayVector clone() {
        double[] copiedElems = new double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            copiedElems[i] = vector[i];
        }
        ArrayVector copiedOne = new ArrayVectorImpl(copiedElems);
        return copiedOne;
    }

    @Override
    public int getSize() {
        int size = vector.length;
        return size;
    }

    @Override
    public void set(int index, double value) {

        if(index>0&index<vector.length){
            vector[index] = value;
        }
        else if(index<0){}
        else if(index>=this.getSize()){
            double vector1[] = this.vector;
            vector = new double[index+1];
            for(int i=0;i<vector1.length;i++){
                vector[i] =vector1[i];
            }
            vector[index] = value;
        }
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        double x = vector[index];
        return x;
    }

    @Override
    public double getMax() {
        double max = vector[0];
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] > max)
                max = vector[i];
        }
        return max;
    }

    @Override
    public double getMin() {
        double min = vector[0];
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] < min)
                min = vector[i];
        }
        return min;
    }

    public void sortAscending() {
        double temp;
        for (int j = 0; j < get().length; j++) {
            for (int i = 0; i < get().length - j - 1; i++) {
                if (get()[i] > get()[i + 1]) {
                    temp = get()[i];
                    get()[i] = get()[i + 1];
                    get()[i + 1] = temp;

                }
            }
        }
    }

    @Override
    public void mult(double factor) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = vector[i] * factor;
        }
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {

        for (int i = 0; i < this.getSize(); i++) {
            if (this.getSize() == anotherVector.getSize()) {
                this.set(i, this.get(i) + anotherVector.get(i));
            } else if (this.getSize() > anotherVector.getSize() & i > this.getSize()) {
                this.set(i, this.get(i));
            }
        }
        return this;
    }


    @Override
    public double scalarMult(ArrayVector anotherVector) {
        double scalarMult = 0;
        if (this.getSize() == anotherVector.getSize()) {
            for (int i = 0; i < this.getSize(); i++) {
                scalarMult += this.get(i) * anotherVector.get(i);
            }
        }

        return scalarMult;
    }


    @Override
    public double getNorm() {
        double norm = 0;
        double a = 0;
        for (int i = 0; i < this.getSize(); i++) {
            a += Math.pow(this.get(i), 2);
            norm = Math.sqrt(a);
        }
        return norm;
    }




    public static void main(String[] args) {
        double elem[] = {3.4, 5.6, 1.3, 6, 5};
        ArrayVectorImpl v = new ArrayVectorImpl();
        v.set(elem);
        ArrayVectorImpl v1 = new ArrayVectorImpl();
        v1.set(elem);

        System.out.println(Arrays.toString(v.get()));
//        System.out.println(Arrays.toString(v1.get()));
//        System.out.println(v.hashCode());
//        System.out.println(Arrays.toString(v));
        System.out.println(v.clone());
//        System.out.println("size" + v.getSize());
        v.set(3,4.5);
        System.out.println(Arrays.toString(v.get()));
        v.set(7,4.5);
        System.out.println(Arrays.toString(v.get()));
//        v.set(-2, 4.5);
//        System.out.println(Arrays.toString(v.get()));
        System.out.println(v.get(0));
//        System.out.println(v.get(4)();
//        System.out.println(v.get(-2));
////        System.out.println(v.getMin());
////        System.out.println(v.getMax());
//        v.mult(5.5);
//        System.out.println(Arrays.toString(v.get()));
//        System.out.println();
//        System.out.println( v.scalarMult(v1));
//        System.out.println(v.sum(v1));
//        System.out.println(v.getNorm());

//        System.out.println();

    }
}

//        package ru.ncedu.java.tasks.ArrayVector;
//
//
//        import java.util.Arrays;
//
//public class ArrayVectorImpl implements ArrayVector {
//
//    private double[] array = {};
//
//    public ArrayVectorImpl() {
//
//    }
//
//    public ArrayVectorImpl(int size) {
//        if (size >= 0) {
//            array = new double[size];
//        } else {
//            throw new IllegalArgumentException();
//        }
//    }
//
//    @Override
//    public void set(double... elements) {
//        if (elements.length != 0) {
//            array = new double[elements.length];
//            System.arraycopy(elements, 0, array, 0, elements.length);
//        }
//    }
//
//    @Override
//    public double[] get() {
//        return array;
//    }
//
//    @Override
//    public ArrayVector clone() {
//        ArrayVector cloneVector = new ArrayVectorImpl();
//
//        cloneVector.set(array.clone());
//
//        return cloneVector;
//    }
//
//    @Override
//    public int getSize() {
//        return array.length;
//    }
//
//    @Override
//    public void set(int index, double value) {
//        if (index >= 0) {
//            if (index < array.length) {
//                array[index] = value;
//            } else {
//                double[] tem = new double[array.length + 1];
//                System.arraycopy(array, 0, tem, 0, array.length);
//                array = tem;
//
//                array[array.length - 1] = value;
//            }
//        }
//    }
//
//    @Override
//    public double get(int index) throws ArrayIndexOutOfBoundsException {
//
//        return array[index];
//    }
//
//    @Override
//    public double getMax() {
//        double[] tem = array.clone();
//
//        Arrays.sort(tem);
//
//        return tem[array.length - 1];
//    }
//
//    @Override
//    public double getMin() {
//        double[] tem = array.clone();
//
//        Arrays.sort(tem);
//
//        return tem[0];
//    }
//
//    @Override
//    public void sortAscending() {
//        Arrays.sort(array);
//    }
//
//    @Override
//    public void mult(double factor) {
//        for (int i = 0; i < array.length; i++) {
//            array[i] *= factor;
//        }
//    }
//
//    @Override
//    public ArrayVector sum(ArrayVector anotherVector) {
//
//        if (anotherVector != null) {
//            for (int i = 0; i < array.length; i++) {
//                if (anotherVector.get().length <= i) {
//                    break;
//                }
//                this.array[i] += anotherVector.get(i);
//            }
//        }
//
//        return this;
//    }
//
//    @Override
//    public double scalarMult(ArrayVector anotherVector) {
//        double scalar = 0;
//        if (anotherVector != null) {
//            int length;
//            if (this.array.length <= anotherVector.getSize()) {
//                length = this.array.length;
//            } else {
//                length = anotherVector.getSize();
//            }
//
//            for (int i = 0; i < length; i++) {
//                scalar += (this.array[i] * anotherVector.get(i));
//            }
//        }
//        return scalar;
//    }
//
//    @Override
//    public double getNorm() {
//        return Math.sqrt(this.scalarMult(this));
//    }
//}













