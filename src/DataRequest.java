import java.io.FileWriter;
import java.util.Scanner;

public class DataRequest {

    private String firstName;
    private String lastName;
    private String middleName;
    private String dateOfBirth;
    private long numberPhone;
    private char gender;
    private final Scanner scan = new Scanner(System.in);

    // Методы для присваивания значений полям
    private void EnterFirstName() {
        System.out.println("Введите Вашу фамилию:");
        firstName = scan.nextLine();
        if (firstName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterLastName() {
        System.out.println("Введите Ваше имя:");
        lastName = scan.nextLine();
        if (lastName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterMiddleName() {
        System.out.println("Введите Ваше отчество");
        middleName = scan.nextLine();
        if (middleName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterDateOfBirth() {
        System.out.println("Введите дату Вашего рождения:");
        dateOfBirth = scan.nextLine();
        if (dateOfBirth.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterNumberPhone() {
        try {
            System.out.println("Введите Ваш мобильный номер телефона:");
            String number = scan.nextLine();
            if (number.equals("")) {
                throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
            }
            numberPhone = Long.parseLong(number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Не верный формат, попробуйте снова!");
        }
    }

    private void EnterGender() {
        System.out.println("Введите Ваш пол (f, m):");
        String gen;
        String f = "f";
        String m = "m";
        gen = scan.nextLine();
        if (gen.length() > 1) {
            throw new RuntimeException("Вы ввели слишком много символов \nпопробуйте снова!");
        }
        if (gen.equals(f) || gen.equals(m)) {
            gender = gen.charAt(0);
        } else {
            throw new RuntimeException("Вы ввели не тот символ!");
        }
    }

    // Метод для вывода в консоль получившихля значений
    private void OutPutData() {
        System.out.println("\nFirst name \t- \t" + firstName + "\n" + "Last name \t- \t" + lastName + "\n" + "Middle name \t- \t" + middleName + "\n" + "Year of birth \t- \t" + dateOfBirth + "\n" + "Number phone \t- \t" + numberPhone + "\n" + "Gender   \t- \t" + gender);
    }

    // Метод для соединения всех методов в один
    private void DataEnter() {
        EnterFirstName();
        EnterLastName();
        EnterMiddleName();
        EnterDateOfBirth();
        EnterNumberPhone();
        EnterGender();
        OutPutData();
    }

    // Метод для сохранения данных в файл
    public void SaveDataEnter() {

        DataEnter();
        String file = "data/" + lastName + ".txt";
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write("<" + firstName + "> " + "<" + lastName + "> " + "<" + middleName + "> " + "<" + dateOfBirth + "> " + "<" + numberPhone + "> " + "<" + gender + ">\n");
        } catch (Exception e) {
            System.out.println("Чтото пошло не так!");
        }
    }

    // Геттеры для полей

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public long getNumberPhone() {
        return numberPhone;
    }

    public char getGender() {
        return gender;
    }
}