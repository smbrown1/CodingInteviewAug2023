package main.rentalAgreement;

public enum ToolType
{
    LADDER(1.99,true, false),
    CHAINSAW(1.49, false, true),
    JACKHAMMER(2.99, false, false);

    private final double dailyCharge;
    private final boolean weekendCharge;
    private final boolean holidayCharge;

    ToolType(double dailyCharge, boolean weekendCharge, boolean holidayCharge)
    {
        this.dailyCharge = dailyCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;
    }

    public double getDailyCharge()
    {
        return dailyCharge;
    }

    public boolean isWeekendCharge()
    {
        return weekendCharge;
    }

    public boolean isHolidayCharge()
    {
        return holidayCharge;
    }
}
