package ru.ncedu.java.tasks.BusinessCard;
import java.text.ParseException;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BusinessCardImpl implements BusinessCard {

    private String name;
    private String lastName;
    private String department;
    private String birthDate;
    private String gender;
    private int salary;
    private String phoneNumber;

    public BusinessCardImpl() {

    }

    public BusinessCardImpl(Scanner scanner) {
        this.getBusinessCard(scanner);
    }

    @Override
    public BusinessCard getBusinessCard(Scanner scanner) {
        scanner.useDelimiter(";");
        try {
            name = scanner.next("[а-яА-Яa-zA-Z-]+");
            lastName = scanner.next("[а-яА-Яa-zA-Z-]+");
            department = scanner.next("[а-яА-Яa-zA-Z]+");
            birthDate = scanner.next("((0[1-9]|1[0-9]|2[0-9]|3[01])-(0[1-9]|1[012])-[0-9]{4})");
            gender = scanner.next("[MF]");
            salary = Integer.parseInt(scanner.next("[1-9][0-9]{2,4}|10{5}"));
            phoneNumber = scanner.next("[0-9]{10}");
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Input value does not correspond to the data format!");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Input stream hasn't enough values to construct a BusinessCard!");
        }
        return this;
    }

    @Override
    public String getEmployee() {
        return name + " " + lastName;
    }

    @Override
    public String getDepartment() {
        return department;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public int getAge() {
        Calendar today = Calendar.getInstance();
        Calendar birth = Calendar.getInstance();
        birth.set(Integer.parseInt(this.birthDate.substring(6)),
                Integer.parseInt(this.birthDate.substring(3, 5)),
                Integer.parseInt(this.birthDate.substring(0, 2)));

        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < birth.get(Calendar.MONTH) ||
                today.get(Calendar.MONTH) == birth.get(Calendar.MONTH) &&
                        today.get(Calendar.DAY_OF_MONTH) < birth.get(Calendar.DAY_OF_MONTH)) {
            age--;
        }

        return age;
    }

    @Override
    public String getGender() {
        if (String.valueOf(gender).equals("M")) {
            return "Male";
        } else {
            return "Female";
        }
    }

    @Override
    public String getPhoneNumber() {
        return "+7 " + phoneNumber.substring(0, 3) +
                "-" + phoneNumber.substring(3, 6) +
                "-" + phoneNumber.substring(6, 8) +
                "-" + phoneNumber.substring(8);
    }
        public static void main(String[] args) throws ParseException {
        BusinessCardImpl bc = new BusinessCardImpl();
        //Ivan;Ign;IT;23-05-1987;F;524;1123456789;
        //Ivan; ;IT;23.05.1987;f;99;112346789;
        Scanner sc = new Scanner(System.in);
        System.out.println("Name;Last name;Department;Birth date;Gender;Salary;Phone number;");

        System.out.println(bc.getBusinessCard(sc));
        System.out.println(bc.name);
        System.out.println(bc.lastName);
        System.out.println(bc.department);
        System.out.println(bc.salary);

        System.out.println(bc.birthDate);
        System.out.println(bc.gender);
        System.out.println(bc.phoneNumber);


        System.out.println("Employee " + bc.getEmployee());
        System.out.println("Department " + bc.getDepartment());
        System.out.println("Salary " + bc.getSalary());
        System.out.println("age " + bc.getAge());
        System.out.println("gend " + bc.getGender());
        System.out.println("phonenumb " + bc.getPhoneNumber());
    }
}