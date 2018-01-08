package ru.ncedu.java.tasks.StringFilter;


import java.util.*;


/**
 * Created by Mari on 28.03.2016.
 */


public class StringFilterImpl implements StringFilter {
    List list = new ArrayList<String>();

    public StringFilterImpl() {
    }

    @Override
    public Iterator<String> getStringsByPattern(final String pattern) {
        return new Filter() {
            @Override
            public Iterator<String> check(List list) {
                ArrayList<String> resultOfChecking = new ArrayList();
                Iterator<String> iterator = list.iterator();
                if (pattern == null) {
                    return list.iterator();
                }
                if (pattern.isEmpty()) {
                    return list.iterator();
                }
                int a1 = pattern.indexOf("*");
                int a2 = pattern.lastIndexOf("*");
                while (iterator.hasNext()) {
                    String elem = iterator.next();
                    boolean a, b, c;
                    try {
                        if (a1 == a2) {
                            if (a1 == 0) {
                                a = elem.regionMatches(elem.length() - pattern.length() + 1, pattern, 1, pattern.length() - 1);
                                if (a == true) {
                                    resultOfChecking.add(elem);
                                }
                            }
                            if (a1 == pattern.length() - 1) {
                                a = elem.regionMatches(0, pattern, 0, pattern.length() - 1);
                                if (a == true) {
                                    resultOfChecking.add(elem);
                                }
                            } else {
                                a = elem.regionMatches(0, pattern, 0, a1);
                                b = elem.regionMatches(elem.length() - pattern.length() + a1 + 1, pattern, a1 + 1, pattern.length() - a1 - 1);
                                if (a == true & b == true) {
                                    resultOfChecking.add(elem);
                                }
                            }
                        } else {
                            if (a1 == 0 & a2 == pattern.length() - 1) {
                                if (elem.contains(pattern.substring(1, pattern.length() - 1))) {
                                    resultOfChecking.add(elem);
                                }

                            }
                            if (a1 == 0 & a2 != pattern.length() - 1) {
                                if ((elem.substring(0, elem.length() - pattern.length() + a2 - 2)).contains(pattern.substring(1, a2 - 1)) & elem.substring(elem.length() - pattern.length() + a2 + 1, elem.length()).equals(pattern.substring(a2 + 1, pattern.length())))
                                    resultOfChecking.add(elem);

                            }
                            if (a1 != 0 & a2 == pattern.length() - 1) {
                                if (elem.substring(0, a1).equals(pattern.substring(0, a1)) & (elem.substring(a1, elem.length())).contains(pattern.substring(a1 + 1, a2))) {
                                    resultOfChecking.add(elem);
                                }
                            } else {
                                try {
                                    if (!elem.isEmpty()) {
                                        try{
                                        if (elem.substring(0, a1).equals(pattern.substring(0, a1)) &
                                                elem.substring(a1, elem.length() - pattern.length() + a2+2).contains(pattern.substring(a1 + 1, a2))
                                                & elem.substring(elem.length() - pattern.length() + a2 + 1, elem.length()).equals(pattern.substring(a2 + 1, pattern.length()))) {

                                            resultOfChecking.add(elem);
                                        }}catch (NullPointerException e){}
                                    }
                                } catch (NullPointerException e) {
                                }
                            }
                        }
                    } catch (NullPointerException e) {
                    }
                }
//                }
                return resultOfChecking.iterator();
            }
        }.check(list);
    }


    @Override
    public void add(String s) {
        if (s != null) {
            s = s.toLowerCase();
        }
        if (!list.contains(s)) {
            list.add(s);
        }
    }


    @Override
    public boolean remove(String s) {
        s = s.toLowerCase();
        if (list.contains(s)) {
            list.remove(s);
            return true;
        } else return false;
    }

    @Override
    public void removeAll() {
        list.clear();
    }

    @Override
    public Collection<String> getCollection() {
        return new HashSet(list);
    }

    @Override
    public Iterator<String> getStringsContaining(final String chars) {
        return new Filter() {
            @Override
            public Iterator<String> check(List list) {
                ArrayList<String> resultOfChecking = new ArrayList();
                Iterator<String> iterator = list.iterator();
                if (chars == null) {
                    return list.iterator();
                }
                if (chars.isEmpty()) {
                    return list.iterator();
                }

                while (iterator.hasNext()) {
                    String elem = iterator.next();
                    if (elem != null) {
                        if (elem.contains(chars))
                            resultOfChecking.add(elem);
                    }
                }
                return resultOfChecking.iterator();
            }
        }.check(list);
    }

    @Override
    public Iterator<String> getStringsStartingWith(final String begin) {

        return new Filter() {
            @Override
            public Iterator<String> check(List list) {
                if (begin == null) {
                    return list.iterator();
                }
                if (begin.isEmpty()) {
                    return list.iterator();
                }
                ArrayList<String> resultOfChecking = new ArrayList();
                Iterator<String> iterator = list.iterator();
                String beg = begin.toLowerCase();

                int k = beg.length();
                String s1 = null;
                while (iterator.hasNext()) {
                    String elem = iterator.next();
                    try {
                        if (elem.length() >= k) {
                            s1 = elem.substring(0, k);
                            if (s1.equals(beg)) {
                                resultOfChecking.add(elem);
                            }
                        }
                    } catch (NullPointerException e) {
                    }


                }
                return resultOfChecking.iterator();
            }
        }.check(list);
    }

    @Override
    public Iterator<String> getStringsByNumberFormat(final String format) {
        return new Filter() {
            @Override
            public Iterator<String> check(List list) {
                ArrayList<String> resultOfChecking = new ArrayList();
                Iterator<String> iterator = list.iterator();
                if (format == null) {
                    return list.iterator();
                }
                if (format.isEmpty()) {
                    return list.iterator();
                }
                while (iterator.hasNext()) {
                    String elem = iterator.next();
                    boolean d[] = new boolean[format.length()];
                    if (elem.length() == format.length()) {
                        for (int i = 0; i < format.length(); i++) {

                            char a = elem.charAt(i);
                            char b = format.charAt(i);

                            if ((Character.isDigit(a) & b == '#') || (a == b)) {
                                d[i] = true;
                            }
                        }
                    }
                    int a = 0;
                    for (int i = 0; i < format.length(); i++) {
                        if (d[i] != false) {
                            a++;
                        }
                    }
                    if (a == format.length())
                        resultOfChecking.add(elem);
                }
                return resultOfChecking.iterator();
            }
        }.check(list);
    }


    interface Filter {
        Iterator check(List list);
    }

    public static void main(String[] args) {

        StringFilterImpl imp = new StringFilterImpl();
        StringFilterImpl imp1 = new StringFilterImpl();
//        distribute, restrictions, distributed, redistributors, restricted, distribution

        imp.add("distributed");
        imp.add("distribute");
        imp.add("restrictions");
        imp.add("(283)834-7383");
        imp.add("");
        imp.add(null);


        imp.add("redistributors");
        imp.add("restricted");
        imp.add("distribution");
        imp.add("efotect");
        imp.add("effect");

//        Iterator iter = imp.getStringsContaining(null);
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//
//        }
//        System.out.println("____________________________");
//        System.out.println("imp: " + imp.getCollection().size());
//        Iterator iter1 = imp.getStringsStartingWith("ef");
////        System.out.println("imp: "+imp.getCollection().size());
//        while (iter1.hasNext()){
//            System.out.println("iter: "+iter1.next());
//        }
//        System.out.println("imp: "+imp.getCollection().size());
////        System.out.println("imp: "+);
//        System.out.println("____________________________");
//        Iterator iter2 = imp.getStringsByNumberFormat("# ###");
//        while (iter2.hasNext()) {
//            System.out.println(iter2.next());
//        }
        System.out.println("____________________________");
        Iterator iter3 = imp.getStringsByPattern("dis*bu*d");
        while (iter3.hasNext()) {
            System.out.println(iter3.next());
        }}
}

