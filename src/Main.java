import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ФИО (Фамилия Имя Отчество):");
        String fullName = scanner.nextLine().trim();
        System.out.println("Введите дату рождения (в формате ДД.ММ.ГГГГ):");
        String birthDateInput = scanner.nextLine().trim();

        Person person;
        try {
            person = Person.fromInput(fullName, birthDateInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return;
        }

        String gender = GenderDetector.detectGender(person.getMiddleName());

        int age = AgeCalculator.calculateAge(person.getBirthDate(), LocalDate.now());
        String ageText = AgeCalculator.getAgeWithSuffix(age);

        System.out.println("Инициалы: " + person.getInitials());
        System.out.println("Пол: " + gender);
        System.out.println("Возраст: " + ageText);
    }
}
