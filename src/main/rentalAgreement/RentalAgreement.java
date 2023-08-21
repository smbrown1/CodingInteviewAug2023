package main.rentalAgreement;

import java.util.Objects;

public class RentalAgreement
{
    //Enum?
    private String toolCode;
    private String toolType;
    private String toolBrand;

    private int rentalDays;
    private String checkoutDate;
    private String dueDate;
    private double dailyRentalCharge; //Part of Enum?
    private int chargeDays;
    private double prediscountCharge;
    private double discountPercent;
    private double discountAmount;
    private double finalCharge;

    public RentalAgreement(String toolCode, String toolType, String toolBrand, int rentalDays, String checkoutDate, String dueDate, double dailyRentalCharge, int chargeDays, double prediscountCharge, double discountPercent, double discountAmount, double finalCharge)
    {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.toolBrand = toolBrand;
        this.rentalDays = rentalDays;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.dailyRentalCharge = dailyRentalCharge;
        this.chargeDays = chargeDays;
        this.prediscountCharge = prediscountCharge;
        this.discountPercent = discountPercent;
        this.discountAmount = discountAmount;
        this.finalCharge = finalCharge;
    }

    public String getToolCode()
    {
        return toolCode;
    }

    public String getToolType()
    {
        return toolType;
    }

    public String getToolBrand()
    {
        return toolBrand;
    }

    public int getRentalDays()
    {
        return rentalDays;
    }

    public String getCheckoutDate()
    {
        return checkoutDate;
    }

    public String getDueDate()
    {
        return dueDate;
    }

    public double getDailyRentalCharge()
    {
        return dailyRentalCharge;
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
                Double.compare(that.dailyRentalCharge, dailyRentalCharge) == 0 &&
                Double.compare(that.prediscountCharge, prediscountCharge) == 0 &&
                Double.compare(that.discountPercent, discountPercent) == 0 &&
                Double.compare(that.discountAmount, discountAmount) == 0 &&
                Double.compare(that.finalCharge, finalCharge) == 0 &&
                toolCode.equals(that.toolCode) &&
                toolType.equals(that.toolType) &&
                toolBrand.equals(that.toolBrand) &&
                checkoutDate.equals(that.checkoutDate) &&
                dueDate.equals(that.dueDate) &&
                chargeDays == that.chargeDays;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(toolCode, toolType, toolBrand, rentalDays, checkoutDate, dueDate, dailyRentalCharge, chargeDays, prediscountCharge, discountPercent, discountAmount, finalCharge);
    }
}
