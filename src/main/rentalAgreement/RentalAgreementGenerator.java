package main.rentalAgreement;

public class RentalAgreementGenerator
{
    public static RentalAgreement generateAgreement(String toolCode, String checkoutDate, int rental_days, double discount)
    {
        return new RentalAgreement(
                "JAKR",
                "Jackammer",
                "DeWalt",
                1,
                "9/3/15", //Thursday
                "9/4/15",    //Friday
                2.99,
                1,
                2.99,
                0,
                0,
                2.99
        );
    }
}
