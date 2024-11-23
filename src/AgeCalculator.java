import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {
    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        return Period.between(birthDate, currentDate).getYears();
    }

    public static String getAgeWithSuffix(int age) {
        int lastDigit = age % 10;
        int lastTwoDigits = age % 100;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            return age + " лет";
        }

        switch (lastDigit) {
            case 1:
                return age + " год";
            case 2:
            case 3:
            case 4:
                return age + " года";
            default:
                return age + " лет";
        }
    }
}
