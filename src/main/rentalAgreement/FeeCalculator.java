package main.rentalAgreement;

public class FeeCalculator
{
    public static double calcInitialCharge(ToolType tool, int chargeDays)
    {
        return tool.getDailyCharge() * chargeDays;
    }

    public static double calcDiscountedCharge(ToolType tool, int chargeDays, double discount)
    {
        return tool.getDailyCharge() * chargeDays * (1.0 - (discount / 100.0));
    }
}
