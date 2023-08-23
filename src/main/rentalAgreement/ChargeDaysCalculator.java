package main.rentalAgreement;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class ChargeDaysCalculator
{
    public static int calcChargeDays(LocalDate checkoutDate, LocalDate dueDate, int rentalDays, ToolType toolType)
    {
        int freeDays = 0;

        if (!toolType.isWeekendCharge())
            freeDays += calcFreeWeekendDays(checkoutDate, dueDate);
        if (!toolType.isHolidayCharge())
            freeDays += calcFreeHolidays(checkoutDate, dueDate, toolType.isWeekendCharge());

        return rentalDays - freeDays;
    }

    private static int calcFreeWeekendDays(LocalDate checkoutDate, LocalDate dueDate)
    {
        LocalDate currentDate = LocalDate.of(checkoutDate.getYear(), checkoutDate.getMonthValue(), checkoutDate.getDayOfMonth());
        int freeDays = 0;

        while (currentDate.isBefore(dueDate) || currentDate.isEqual(dueDate))
        {
            if (currentDate.getDayOfWeek() == DayOfWeek.SATURDAY)
            {
                freeDays++;
            }
            if (currentDate.getDayOfWeek() == DayOfWeek.SUNDAY)
                freeDays++;

            currentDate = currentDate.plusDays(1);
        }
        return freeDays;
    }

    private static int calcFreeHolidays(LocalDate checkoutDate, LocalDate dueDate, boolean chargeWeekend)
    {
        int freeDays = calcFreeLaborDay(checkoutDate, dueDate);

        freeDays += calcFreeForthOfJuly(checkoutDate, dueDate, chargeWeekend);

        return freeDays;
    }

    private static int calcFreeLaborDay(LocalDate checkoutDate, LocalDate dueDate)
    {
        int freeDays = 0;
        for (int year = checkoutDate.getYear(); year <= dueDate.getYear(); year++)
        {
            LocalDate laborDay = LocalDate.of(year, 9, 1).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
            if (isDayInRange(checkoutDate, dueDate, laborDay))
                freeDays++;
        }

        return freeDays;
    }

    private static int calcFreeForthOfJuly(LocalDate checkoutDate, LocalDate dueDate, boolean chargeWeekend)
    {
        int freeDays = 0;
        for (int year = checkoutDate.getYear(); year <= dueDate.getYear(); year++)
        {
            LocalDate fourthOfJuly = LocalDate.of(year, 7, 4);
            if (isDayInRange(checkoutDate, dueDate, fourthOfJuly))
            {
                if (chargeWeekend)
                {
                    freeDays++;
                    continue;
                }

                if (fourthOfJuly.getDayOfWeek() != DayOfWeek.SATURDAY && fourthOfJuly.getDayOfWeek() != DayOfWeek.SUNDAY)
                {
                    freeDays++;
                    continue;
                }

                if (fourthOfJuly.getDayOfWeek() == DayOfWeek.SATURDAY && isDayInRange(checkoutDate, dueDate, fourthOfJuly.minusDays(1)))
                {
                    freeDays++;
                } else if (fourthOfJuly.getDayOfWeek() == DayOfWeek.SUNDAY && isDayInRange(checkoutDate, dueDate, fourthOfJuly.minusDays(2)))
                {
                    freeDays++;
                }
            }
        }

        return freeDays;
    }

    private static boolean isDayInRange(LocalDate checkoutDate, LocalDate dueDate, LocalDate queryDate)
    {
        return checkoutDate.isEqual(queryDate) || dueDate.isEqual(queryDate)
                || (checkoutDate.isBefore(queryDate) && dueDate.isAfter(queryDate));
    }
}
