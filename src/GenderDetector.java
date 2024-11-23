public class GenderDetector {
    public static String detectGender(String middleName) {
        if (middleName.endsWith("ич")) {
            return "мужской";
        } else if (middleName.endsWith("на")) {
            return "женский";
        } else {
            return "ОПРЕДЕЛИТЬ_НЕ_УДАЛОСЬ";
        }
    }
}
