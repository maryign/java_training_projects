package ru.ncedu.java.tasks.Checker;//package ru.ncedu.java.tasks.Checker;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class CheckerImpl implements Checker {
//
//    public CheckerImpl() {
//
//    }
//
//    @Override
//    public Pattern getPLSQLNamesPattern() {
//        return Pattern.compile("[A-Za-z][A-Za-z0-9_$]{0,29}");
//    }
//    @Override
//    public Pattern getHrefURLPattern() {
//        return Pattern.compile("<\\s*(a|A)\\s*\\s*[hH][rR][eE][fF]\\s*=" +
//                "\\s*((\"(https?://)?(www\\.)?[A-Za-z0-9 /:._?&%@#\\\\]*\")|" +
//                "([A-Za-z0-9/:._?&\\%@#\\\\]*))\\s*/?>");
//    }
//    //        return Pattern.compile("^<\\s*a\\s*href\\s*=\\s*(\".*\"|[^\\s]*)/?\\s*>$",Pattern.CASE_INSENSITIVE);
//    @Override
//    public Pattern getEMailPattern() {
//        return Pattern.compile("[A-Za-z0-9][A-Za-z0-9_.-]{0,20}[A-Za-z0-9]@" +
//                "([a-zA-Z0-9]+[a-zA-Z0-9-]*[a-zA-Z0-9]+\\.)+" +
//                "((ru)|(com)|(net)|(org))");
//    }
//
//    @Override
//    public boolean checkAccordance(String inputString, Pattern pattern) throws IllegalArgumentException {
//        if (inputString == null && pattern == null) {
//            return true;
//        } else if (inputString == null || pattern == null) {
//            throw new IllegalArgumentException("One of the arguments is null...");
//        } else {
//            Matcher matcher = pattern.matcher(inputString);
//            return matcher.matches();
//        }
//    }
//
//    @Override
//    public List<String> fetchAllTemplates(StringBuffer inputString, Pattern pattern) throws IllegalArgumentException {
//        if (inputString == null || pattern == null) {
//            throw new IllegalArgumentException("One of the arguments is null...");
//        } else {
//            Matcher matcher = pattern.matcher(inputString);
//            List<String> templates = new ArrayList<>();
//            while (matcher.find()) {
//                templates.add(matcher.group());
//            }
//            return templates;
//        }
//    }
//
//    public static void main(String[] args) {
//        CheckerImpl ch = new CheckerImpl();
////        Pattern p =ch.getHrefURLPattern();
//        Pattern p =  Pattern.compile("[A-Za-z0-9_$\\./:]{0,29}");
//        String s1 = "http://ru.javasql.center/course/view.php?id=4" ;
//        String s2  ="http://devcolibri.com/1043" ;
//        System.out.println(ch.checkAccordance(s1, p));
//        System.out.println(ch.checkAccordance(s2, p));
//        System.out.println(ch.fetchAllTemplates(new StringBuffer(s1), p));
//        System.out.println(ch.fetchAllTemplates(new StringBuffer(s2), p));
//    }
//}