package api.utils;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;

public class DateUtil {

    public static void main(String[] args) {
        System.out.println(getTodayDate());
        System.out.println(secondsToMilliseconds(5));
    }

    public static String getTodayDate() {
        if (checkIfTodayIsWeekendDay()
                && LocalDate.now().getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
            return LocalDate.now().minusDays(1).toString();
        } else if (checkIfTodayIsWeekendDay()
                && LocalDate.now().getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            return LocalDate.now().minusDays(2).toString();
        }
        return LocalDate.now().toString();
    }

    private static boolean checkIfTodayIsWeekendDay() {
        return LocalDate.now().getDayOfWeek().equals(DayOfWeek.SATURDAY)
                || LocalDate.now().getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }

    public static long secondsToMilliseconds(int seconds) {
        return Duration.ofSeconds(seconds).toMillis();
    }
}
