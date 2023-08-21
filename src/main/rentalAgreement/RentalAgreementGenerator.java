package main.rentalAgreement;

import static main.rentalAgreement.Tool.JAKR;

public class RentalAgreementGenerator
{
    public RentalAgreement generateAgreement(String toolCode, String checkoutDate, int rental_days, double discount)
    {
        return new RentalAgreement(JAKR,
                1,
                "9/3/15", //Thursday
                "9/4/15",    //Friday
                1,
                2.99,
                0,
                0,
                2.99
        );
    }
}
