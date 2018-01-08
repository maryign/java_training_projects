package ru.ncedu.java.tasks.BusinessCard;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Mari on 27.07.2016.
 */
public class BusinessCardImpl1 implements BusinessCard {
    /**
     * This method obtains (via Scanner) information from an input stream
     * that contains the following information about an Employee:<br/>
     * Name - String<br/>
     * Last name - String<br/>
     * Department - String <br/>
     * Birth date - String in format: "DD-MM-YYYY", where DD - two-digits birth date,
     * MM - two-digits month of birth, YYYY - year of birth<br/>
     * Gender : F or M - Character<br/>
     * Salary : number from 100 to 100000<br/>
     * Phone number : 10-digits number<br/>
     * All entries are separated with ";" sign<br/>
     * The format of input is the following:<br/>
     * Name;Last name;Department;Birth date;Gender;Salary;Phone number
     *
     * @param scanner Data source
     * @return Business Card
     * @throws InputMismatchException Thrown if input value
     * does not correspond to the data format given above (for example,
     * if phone number is like "AAA", or date format is incorrect, or salary is too high)
     * @throws NoSuchElementException Thrown if input stream hasn't enough values
     * to construct a BusinessCard
     */

    private String Name;
    private String Lastname;
    private String Department;
    private String Birthdate;
    private String Gender;
    private int Salary;
    private String Phone;

    public BusinessCardImpl1() {
    }

    ;

    @Override
    public BusinessCard getBusinessCard(Scanner scanner) throws IOException {
        scanner.useDelimiter(";");
        try {
            Name = scanner.next("[а-яА-Яa-zA-Z-]+");
            Lastname = scanner.next("[а-яА-Яa-zA-Z-]+");
            Department = scanner.next("[а-яА-Яa-zA-Z]+");
            Birthdate = scanner.next("((0[1-9]|1[0-9]|2[0-9]|3[01])-(0[1-9]|1[012])-[0-9]{4})");
            Gender = scanner.next("[MF]");
            Salary = Integer.parseInt(scanner.next("[1-9][0-9]{2,4}|10{5}"));
            Phone = scanner.next("[0-9]{10}");
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Data doesn't correspond to the data format!");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Data isn't full");
        }
        return this;
    }

    /**
     * @return Employee Name and Last name separated by space (" "), like "Chuck Norris"
     */
    @Override
    public String getEmployee() {
        return Name + " " + Lastname;
    }

    /**
     * @return Employee Department name, like "DSI"
     */
    @Override
    public String getDepartment() {
        return Department;
    }

    /**
     * @return Employee Salary, like 1000
     */
    @Override
    public int getSalary() {
        return Salary;
    }

    /**
     * @return Employee Age in years, like 69
     */
    @Override
    public int getAge() throws ParseException {
        Calendar today = Calendar.getInstance();
        Calendar birth = Calendar.getInstance();
        birth.set(Integer.parseInt(this.Birthdate.substring(6)),
                Integer.parseInt(this.Birthdate.substring(3, 5)),
                Integer.parseInt(this.Birthdate.substring(0, 2)));

        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < birth.get(Calendar.MONTH) ||
                today.get(Calendar.MONTH) == birth.get(Calendar.MONTH) &&
                        today.get(Calendar.DAY_OF_MONTH) < birth.get(Calendar.DAY_OF_MONTH)) {
            age--;
        }

        return age;

    }

    /**
     * @return Employee Gender: either "Female" or "Male"
     */
    @Override
    public String getGender() {
        if (Gender == "M")
            return "Male";
        else return "Female";
//        return Gender;
    }

    /**
     * @return Employee Phone Number in the following format: "+7 123-456-78-90"
     */
    @Override
    public String getPhoneNumber() {
        return "+7 " + Phone.substring(0, 3) +
                "-" + Phone.substring(3, 6) +
                "-" + Phone.substring(6, 8) +
                "-" + Phone.substring(8);
    }
    public static void main(String[] args) throws ParseException {
        BusinessCardImpl bc = new BusinessCardImpl();
        //Ivan;Ign;IT;23-05-1987;F;524;1123456789;
        //Ivan; ;IT;23.05.1987;f;99;112346789;
        Scanner sc = new Scanner(System.in);
        System.out.println("Name;Last name;Department;Birth date;Gender;Salary;Phone number;");

        System.out.println(bc.getBusinessCard(sc));
//        System.out.println(bc.Name);
//        System.out.println(bc.lastName);
//        System.out.println(bc.department);
//        System.out.println(bc.salary);
//
//        System.out.println(bc.birthDate);
//        System.out.println(bc.gender);
//        System.out.println(bc.phoneNumber);


        System.out.println("Employee " + bc.getEmployee());
        System.out.println("Department " + bc.getDepartment());
        System.out.println("Salary " + bc.getSalary());
        System.out.println("age " + bc.getAge());
        System.out.println("gend " + bc.getGender());
        System.out.println("phonenumb " + bc.getPhoneNumber());
    }
}
