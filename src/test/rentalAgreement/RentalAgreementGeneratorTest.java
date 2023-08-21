package test.rentalAgreement;

import main.rentalAgreement.RentalAgreement;
import main.rentalAgreement.RentalAgreementGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentalAgreementGeneratorTest
{
    private RentalAgreementGenerator rentalAgreementGenerator = new RentalAgreementGenerator();

    @Test
    public void testNoDiscountSingleDay()
    {
        RentalAgreement expected = new RentalAgreement(
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
        RentalAgreement result = rentalAgreementGenerator.generateAgreement("JAKR", "9/3/15", 1, 0);

        assertEquals(expected, result);
    }
}