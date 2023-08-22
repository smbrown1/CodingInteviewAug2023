package main.rentalAgreement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static main.rentalAgreement.Tool.JAKR;

public class RentalAgreementGenerator
{
    public RentalAgreement generateAgreement(String toolCode, String checkoutDateText, int rentalDays, double discount)
    {
        Tool tool = Tool.valueOf(toolCode);
        LocalDate checkoutDate = LocalDate.parse(checkoutDateText, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate dueDate = calculateDueDate(checkoutDate, rentalDays);

        return new RentalAgreement(JAKR,
                1,
                checkoutDate, //Thursday
                dueDate,    //Friday
                1,
                2.99,
                0,
                0,
                2.99
        );
    }

    public static LocalDate calculateDueDate(LocalDate checkoutDay, int rentalDays)
    {
        return checkoutDay.plusDays(rentalDays);
    }
}
