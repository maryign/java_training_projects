package ru.ncedu.java.tasks.XPathCaller;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * ЦЕЛИ ЗАДАЧИ:<br/>
 * - Разобраться с XPath выражениями: общий синтаксис, абсолютные и относительные пути,
 *     оси, фильтры, функции.<br/>
 * - Научиться делать произвольные выборки из древовидных структур с перекрестными ссылками.<br/>
 * - Разобраться с Java XPath API.<br/>
 * <br/>
 * ЗАДАНИЕ<br/>
 * Ознакомиться с двумя XML документами: emp.xml (emp.xsd) и emp-hier.xml.<br/>
 * С помощью XPath сделать выборку элемента (элементов) для каждого пункта задания
 *   для каждого из двух документов; XPath для каждого из документов может отличаться.<br/>
 * 1) Для заданного отдела (deptno) выбрать всех сотрудников.<br/>
 * 2) Выбрать имя самого высокооплачиваемого сотрудника.<br/>
 * 3) Для заданного отдела (deptno) выбрать имя самого высокоплачиваемого сотрудника.<br/>
 * 4) Выбрать всех топовых менеджеров (менеджер топовый, если над ним нет менеджера).<br/>
 * 5) Выбрать всех сотрудников, не являющихся менеджерами.<br/>
 * 6) Найти самый затратный отдел (сумма зарплат всех сотрудников самая большая).<br/>
 * 7) Для заданного сотрудника (empno) найти всех коллег, которые в подчинении у того же менеджера.<br/>
 * Во всех методах, возвращающих Element[], должны возвращаться элементы, соответствующие сотрудникам.<br/>
 * Примечание 1: преобразование из Node'ов (NodeList) в Element'ы (Element[]) на практике необходимо для удобства
 *  доступа к данным (так что есть смысл научиться писать краткий код для подобных преобразований массивов).<br/>
 * Примечание 2: здесь менеджер - это начальник сотрудника, а не сотрудник с job=MANAGER! <br/>
 * <br/>
 * ТРЕБОВАНИЯ:<br/>
 * - Использовать стандартный XPath API.<br/>
 * - Каждое решение должно содержать только один вызов XPath API с корректным XPath выражением.<br/>
 * - Пространства имен при решении задачи НЕ использовать.<br/>
 *
 * @author Sergey Pankratov
 */
public class XPathCallerImpl implements XPathCaller {
    XPathFactory factory = XPathFactory.newInstance();
    /**
     * Для заданного отдела выбрать всех сотрудников.
     * @param src XML документ для поиска
     * @param deptno Номер отдела deptno
     * @param docType "emp" - для файла типа emp.xml; "emp-hier" - для файла типа emp-hier.xml
     */
    public Element[] getEmployees (Document src, String deptno, String docType) {
        XPath path = factory.newXPath();
        Element[] kek = null;
        try {
            String expression = "//employee[@deptno=\""+deptno+"\"][1]" ;
            NodeList node = (NodeList) path.evaluate(expression, src.getDocumentElement(), XPathConstants.NODESET);
            Element[] elements = new Element[node.getLength()];
            for ( int i =0; i < node.getLength(); i++) {
                elements[i] = (Element) node.item(i);
            }
            kek = elements;
        } catch (XPathExpressionException e) {

            e.printStackTrace();
        }
        return kek;
    }

    /**
     * Выбрать имя самого высокооплачиваемого сотрудника.
     * @param src XML документ для поиска
     * @param docType "emp" - для файла типа emp.xml; "emp-hier" - для файла типа emp-hier.xml
     */
    public String getHighestPayed(Document src, String docType) {
        String expression = "//employee[sal[not(. < //employee/sal)][1]]/ename/text() ";
        String result = null;
        XPath path = factory.newXPath();
        try {
            result = path.evaluate(expression, src);
        } catch (XPathExpressionException e) {

            e.printStackTrace();
        }
        return result;
    }

    /**
     * Выбрать имя самого высокооплачиваемого сотрудника (любого, если таких несколько).
     * @param src XML документ для поиска
     * @param deptno Номер отдела deptno
     * @param docType "emp" - для файла типа emp.xml; "emp-hier" - для файла типа emp-hier.xml
     */
    public String getHighestPayed(Document src, String deptno, String docType) {
        String expression = "//employee[@deptno = \""+deptno+"\"][sal[not(. < //employee[@deptno = \""+deptno+"\"]/sal)][1]]/ename/text() ";
        String result = null;
        XPath path = factory.newXPath();
        try {
            result = path.evaluate(expression, src);
        } catch (XPathExpressionException e) {

            e.printStackTrace();
        }
        return result;
    }

    /**
     * Выбрать всех топовых менеджеров (менеджер топовый, если над ним нет менеджера)
     * @param src XML документ для поиска
     * @param docType "emp" - для файла типа emp.xml; "emp-hier" - для файла типа emp-hier.xml
     */
    public Element[] getTopManagement(Document src, String docType) {
        XPath path = factory.newXPath();
        Element[] kek = null;
        try {
            String expression = null;
            if(docType.equals("emp")) expression = "//employee[not(@mgr)]";
            if(docType.equals("emp-hier")) expression = "/employee[1]";
            NodeList node = (NodeList) path.evaluate(expression, src.getDocumentElement(), XPathConstants.NODESET);
            Element[] elements = new Element[node.getLength()];
            for ( int i =0; i < node.getLength(); i++) {
                elements[i] = (Element) node.item(i);
            }
            kek = elements;
        } catch (XPathExpressionException e) {

            e.printStackTrace();
        }
        return kek;
    }
    /**
     * Выбрать всех сотрудников, не являющихся менеджерами.
     * Считать, что сотрудник не является менеджером, если у него нет подчиненных.
     * @param src XML документ для поиска
     * @param docType "emp" - для файла типа emp.xml; "emp-hier" - для файла типа emp-hier.xml
     */
    public Element[] getOrdinaryEmployees(Document src, String docType) {return null; }

    /**
     * Для заданного сотрудника(empno) найти всех коллег, которые в подчинении у того же менеджера.
     * @param src XML документ для поиска
     * @param empno Номер сотрудника empno
     * @param docType "emp" - для файла типа emp.xml; "emp-hier" - для файла типа emp-hier.xml
     */
    public Element[] getCoworkers(Document src, String empno, String docType) {return null; }}
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//
///**
// * Created by Mari on 03.05.2016.
// */
//public class XPathCallerImpl implements XPathCaller {
//    /**
//     * Для заданного отдела выбрать всех сотрудников.
//     *
//     * @param src     XML документ для поиска
//     * @param deptno  Номер отдела deptno
//     * @param docType "emp" - для файла типа emp.xml; "emp-hier" - для файла типа emp-hier.xml
//     */
//    @Override
//    public Element[] getEmployees(Document src, String deptno, String docType) {
//        return new Element[0];
//    }
//
//    /**
//     * Выбрать имя самого высокооплачиваемого сотрудника.
//     *
//     * @param src     XML документ для поиска
//     * @param docType "emp" - для файла типа emp.xml; "emp-hier" - для файла типа emp-hier.xml
//     */
//    @Override
//    public String getHighestPayed(Document src, String docType) {
//        return null;
//    }
//
//    /**
//     * Выбрать имя самого высокооплачиваемого сотрудника (любого, если таких несколько).
//     *
//     * @param src     XML документ для поиска
//     * @param deptno  Номер отдела deptno
//     * @param docType "emp" - для файла типа emp.xml; "emp-hier" - для файла типа emp-hier.xml
//     */
//    @Override
//    public String getHighestPayed(Document src, String deptno, String docType) {
//        return null;
//    }
//
//    /**
//     * Выбрать всех топовых менеджеров (менеджер топовый, если над ним нет менеджера)
//     *
//     * @param src     XML документ для поиска
//     * @param docType "emp" - для файла типа emp.xml; "emp-hier" - для файла типа emp-hier.xml
//     */
//    @Override
//    public Element[] getTopManagement(Document src, String docType) {
//        return new Element[0];
//    }
//
//    /**
//     * Выбрать всех сотрудников, не являющихся менеджерами.
//     * Считать, что сотрудник не является менеджером, если у него нет подчиненных.
//     *
//     * @param src     XML документ для поиска
//     * @param docType "emp" - для файла типа emp.xml; "emp-hier" - для файла типа emp-hier.xml
//     */
//    @Override
//    public Element[] getOrdinaryEmployees(Document src, String docType) {
//        return new Element[0];
//    }
//
//    /**
//     * Для заданного сотрудника(empno) найти всех коллег, которые в подчинении у того же менеджера.
//     *
//     * @param src     XML документ для поиска
//     * @param empno   Номер сотрудника empno
//     * @param docType "emp" - для файла типа emp.xml; "emp-hier" - для файла типа emp-hier.xml
//     */
//    @Override
//    public Element[] getCoworkers(Document src, String empno, String docType) {
//        return new Element[0];
//    }
//}
