import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;

    public Person(String lastName, String firstName, String middleName, LocalDate birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
    }

    public static Person fromInput(String fullName, String birthDateInput) {
        String[] nameParts = fullName.split("\\s+");
        if (nameParts.length != 3) {
            throw new IllegalArgumentException("Введите полное ФИО в формате 'Фамилия Имя Отчество'.");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate birthDate;
        try {
            birthDate = LocalDate.parse(birthDateInput, formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Введите дату рождения в формате 'ДД.ММ.ГГГГ'.");
        }

        return new Person(nameParts[0], nameParts[1], nameParts[2], birthDate);
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getInitials() {
        return lastName + " " + firstName.charAt(0) + "." + middleName.charAt(0) + ".";
    }
}
