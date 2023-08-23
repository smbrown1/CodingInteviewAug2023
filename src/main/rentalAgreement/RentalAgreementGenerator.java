package main.rentalAgreement;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static main.rentalAgreement.Tool.JAKR;

public class RentalAgreementGenerator
{
    private final static int RENTAL_DAYS_OFFSET = 1;

    public RentalAgreement generateAgreement(String toolCode, String checkoutDateText, int rentalDays, double discount)
    {
        if (rentalDays < 1)
            throw new IllegalArgumentException("Rental days must be positive");

        if (discount < 0 || discount >= 100)
            throw new IllegalArgumentException("Discount must be between 0 and 100");

        Tool tool = Tool.valueOf(toolCode);
        ToolType toolType = tool.getToolType();
        LocalDate checkoutDate = LocalDate.parse(checkoutDateText, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate dueDate = calculateDueDate(checkoutDate, rentalDays);
        int chargeDays = ChargeDaysCalculator.calcChargeDays(checkoutDate, dueDate, rentalDays, toolType);
        double preDiscountCharge = FeeCalculator.calcInitialCharge(toolType, chargeDays);
        double finalCharge = round(FeeCalculator.calcDiscountedCharge(toolType, chargeDays, discount));
        double discountAmount = preDiscountCharge - finalCharge;

        return new RentalAgreement(tool,
                rentalDays,
                checkoutDate,
                dueDate,
                chargeDays,
                round(preDiscountCharge),
                discount,
                round(discountAmount),
                finalCharge
        );
    }

    public static LocalDate calculateDueDate(LocalDate checkoutDay, int rentalDays)
    {
        return checkoutDay.plusDays(rentalDays - RENTAL_DAYS_OFFSET);
    }

    private static double round(double value)
    {
        BigDecimal unRounded = new BigDecimal(value);
        return unRounded.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
