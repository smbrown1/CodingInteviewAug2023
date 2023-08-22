package main.rentalAgreement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static main.rentalAgreement.Tool.JAKR;

public class RentalAgreementGenerator
{
    private static int RENTAL_DAYS_OFFSET = 1;

    public RentalAgreement generateAgreement(String toolCode, String checkoutDateText, int rentalDays, double discount)
    {
        if(rentalDays < 1)
            throw new IllegalArgumentException("Rental days must be positive");

        if(discount < 0 || discount >= 100)
            throw new IllegalArgumentException("Discount must be between 0 and 100");

        Tool tool = Tool.valueOf(toolCode);
        LocalDate checkoutDate = LocalDate.parse(checkoutDateText, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate dueDate = calculateDueDate(checkoutDate, rentalDays);
        int chargeDays = ChargeDaysCalculator.calcChargeDays(checkoutDate, dueDate, rentalDays, tool);
        double preDiscountCharge = FeeCalculator.calcInitialCharge(tool.getToolType(), rentalDays);
        double finalCharge = FeeCalculator.calcDiscountedCharge(tool.getToolType(), chargeDays, discount);
        double discountAmount = preDiscountCharge-finalCharge;

        return new RentalAgreement(JAKR,
                rentalDays,
                checkoutDate, //Thursday
                dueDate,    //Friday
                chargeDays,
                preDiscountCharge,
                discount,
                discountAmount,
                finalCharge
        );
    }

    public static LocalDate calculateDueDate(LocalDate checkoutDay, int rentalDays)
    {
        return checkoutDay.plusDays(rentalDays-RENTAL_DAYS_OFFSET);
    }
}
