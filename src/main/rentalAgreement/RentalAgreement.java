package main.rentalAgreement;

import java.util.Objects;

public class RentalAgreement
{
    private final Tool tool;
    private final int rentalDays;
    private final String checkoutDate;
    private final String dueDate;
    private final int chargeDays;
    private final double prediscountCharge;
    private final double discountPercent;
    private final double discountAmount;
    private final double finalCharge;

    public RentalAgreement(Tool tool, int rentalDays, String checkoutDate, String dueDate, int chargeDays, double prediscountCharge, double discountPercent, double discountAmount, double finalCharge)
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
}
