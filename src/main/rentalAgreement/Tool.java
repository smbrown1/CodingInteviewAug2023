package main.rentalAgreement;

import static main.rentalAgreement.ToolType.*;

public enum Tool
{
    CHNS(CHAINSAW, "Stihl"),
    LADW(LADDER, "Werner"),
    JAKD(JACKHAMMER, "DeWalt"),
    JAKR(JACKHAMMER, "Ridgid");

    private final ToolType toolType;
    private final String brand;

    Tool(ToolType toolType, String brand)
    {
        this.toolType = toolType;
        this.brand = brand;
    }
}
