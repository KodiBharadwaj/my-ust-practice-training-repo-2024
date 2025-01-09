package com.stackroute.streams;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DateTimeUtility {
    public List<String> getNextMonthWorkingDays(LocalDate today) {
        List<String> workingDays = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Get the first day of the next month
        LocalDate firstDayNextMonth = today.plusMonths(1).withDayOfMonth(1);
        // Get the last day of the next month
        LocalDate lastDayNextMonth = firstDayNextMonth.withDayOfMonth(firstDayNextMonth.lengthOfMonth());

        // Iterate through the days of the next month
        LocalDate currentDate = firstDayNextMonth;
        while (!currentDate.isAfter(lastDayNextMonth)) {
            // Only add weekdays (Monday to Friday)
            if (currentDate.getDayOfWeek() != DayOfWeek.SATURDAY && currentDate.getDayOfWeek() != DayOfWeek.SUNDAY) {
                workingDays.add(currentDate.format(formatter));
            }
            currentDate = currentDate.plusDays(1);
        }

        return workingDays;
    }
}
