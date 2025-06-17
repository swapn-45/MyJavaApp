package epam.java8.Task9;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.function.*;

public class DateTimeFunctions {

    public static void main(String[] args) {
        // 1. Predicate: Check if given date is yesterday
        Predicate<LocalDate> isYesterday = date -> date.equals(LocalDate.now().minusDays(1));
        System.out.println("Is yesterday? " + isYesterday.test(LocalDate.now().minusDays(1))); // true

        // 2. Supplier: Get date of next Thursday
        Supplier<LocalDate> nextThursday = () -> {
            LocalDate today = LocalDate.now();
            return today.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
        };
        System.out.println("Next Thursday: " + nextThursday.get());

        // 3. Supplier: Get current time in EST timezone
        Supplier<ZonedDateTime> currentESTTime = () -> ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("Current EST Time: " + currentESTTime.get().format(DateTimeFormatter.ofPattern("HH:mm:ss z")));

        // 4. Function: Calculate age given date of birth
        Function<LocalDate, Integer> calculateAge = dob -> {
            LocalDate today = LocalDate.now();
            return Period.between(dob, today).getYears();
        };
        LocalDate dob = LocalDate.of(1995, 6, 2);
        System.out.println("Age: " + calculateAge.apply(dob)); // e.g., 29
    }
}
