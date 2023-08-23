package main.rentalAgreement;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class RentalAgreement
{
    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    private final Tool tool;
    private final int rentalDays;
    private final LocalDate checkoutDate;
    private final LocalDate dueDate;
    private final int chargeDays;
    private final double prediscountCharge;
    private final double discountPercent;
    private final double discountAmount;
    private final double finalCharge;

    public RentalAgreement(Tool tool, int rentalDays, LocalDate checkoutDate, LocalDate dueDate, int chargeDays, double prediscountCharge, double discountPercent, double discountAmount, double finalCharge)
    {
        this.tool = tool;
        this.rentalDays = rentalDays;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.chargeDays = chargeDays;
        this.prediscountCharge = prediscountCharge;
        this.discountPercent = discountPercent;
        this.discountAmount = discountAmount;
        this.finalCharge = finalCharge;
    }

    public Tool getTool()
    {
        return tool;
    }

    public int getRentalDays()
    {
        return rentalDays;
    }

    public LocalDate getCheckoutDate()
    {
        return checkoutDate;
    }

    public LocalDate getDueDate()
    {
        return dueDate;
    }

    public int getChargeDays()
    {
        return chargeDays;
    }

    public double getPrediscountCharge()
    {
        return prediscountCharge;
    }

    public double getDiscountPercent()
    {
        return discountPercent;
    }

    public double getDiscountAmount()
    {
        return discountAmount;
    }

    public double getFinalCharge()
    {
        return finalCharge;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalAgreement that = (RentalAgreement) o;
        return rentalDays == that.rentalDays &&
                chargeDays == that.chargeDays &&
                Double.compare(that.prediscountCharge, prediscountCharge) == 0 &&
                Double.compare(that.discountPercent, discountPercent) == 0 &&
                Double.compare(that.discountAmount, discountAmount) == 0 &&
                Double.compare(that.finalCharge, finalCharge) == 0 &&
                tool == that.tool &&
                Objects.equals(checkoutDate, that.checkoutDate) &&
                Objects.equals(dueDate, that.dueDate);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(tool, rentalDays, checkoutDate, dueDate, chargeDays, prediscountCharge, discountPercent, discountAmount, finalCharge);
    }

    @Override
    public String toString()
    {
        return "Tool code: " + tool.name() +
                "\nTool type: " + tool.getToolType() +
                "\nTool brand: " + tool.getBrand() +
                "\nRental days: " + rentalDays +
                "\nCheck out date: " + checkoutDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) +
                "\nDue date: " + dueDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) +
                "\nDaily rental charge: " +  decimalFormat.format(tool.getToolType().getDailyCharge()) +
                "\nCharge days: " + chargeDays +
                "\nDiscount percent: " + discountPercent +
                "\nDiscount amount: " + decimalFormat.format(discountAmount) +
                "\nFinal charge: " + decimalFormat.format(finalCharge);
    }
}
