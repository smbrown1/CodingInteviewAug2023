package main.rentalAgreement;

public enum ToolType
{
    CHAINSAW(1.99, true, false),
    LADDER(1.49,false, true),
    JACKHAMMER(2.99, false, false);

    private double dailyCharge;
    private boolean weekendCharge;
    private boolean holidayCharge;

    ToolType(double dailyCharge, boolean weekendCharge, boolean holidayCharge)
    {
        this.dailyCharge = dailyCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;
    }
}
