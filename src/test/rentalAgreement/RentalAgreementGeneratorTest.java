package test.rentalAgreement;

import main.rentalAgreement.RentalAgreement;
import main.rentalAgreement.RentalAgreementGenerator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static main.rentalAgreement.Tool.JAKR;
import static org.junit.jupiter.api.Assertions.*;

class RentalAgreementGeneratorTest
{
    private final RentalAgreementGenerator rentalAgreementGenerator = new RentalAgreementGenerator();

    @Test
    public void testNoDiscountSingleDay()
    {
        String checkoutDate = "09/03/2015";
        String expectedDueDate = "09/03/2015";

        RentalAgreement expected = new RentalAgreement(
                JAKR,
                1,
                LocalDate.parse(checkoutDate, DateTimeFormatter.ofPattern("MM/dd/yyyy")), //Thursday
                LocalDate.parse(expectedDueDate, DateTimeFormatter.ofPattern("MM/dd/yyyy")), //Friday
                1,
                2.99,
                0,
                0,
                2.99
        );

        RentalAgreement result = rentalAgreementGenerator.generateAgreement("JAKR", checkoutDate, 1, 0);

        assertEquals(expected, result);
    }

    @Test
    public void testTooHighDiscount()
    {
        String checkoutDate = "09/03/2015";

        assertThrows(IllegalArgumentException.class, () -> rentalAgreementGenerator.generateAgreement("JAKR", checkoutDate, 1, 101));
    }

    @Test
    public void testNegativeRentalDays()
    {
        String checkoutDate = "09/03/2015";

        assertThrows(IllegalArgumentException.class, () -> rentalAgreementGenerator.generateAgreement("JAKR", checkoutDate, -1, 0));
    }

    @Test
    public void testNotRealTool()
    {
        String checkoutDate = "09/03/2015";

        assertThrows(IllegalArgumentException.class, () -> rentalAgreementGenerator.generateAgreement("FAKE", checkoutDate, 1, 0));
    }

    @Test
    public void testFreeWeekend()
    {
        String checkoutDate = "08/07/2015";
        String expectedDueDate = "08/10/2015";

        RentalAgreement expected = new RentalAgreement(
                JAKR,
                4,
                LocalDate.parse(checkoutDate, DateTimeFormatter.ofPattern("MM/dd/yyyy")), //Thursday
                LocalDate.parse(expectedDueDate, DateTimeFormatter.ofPattern("MM/dd/yyyy")), //Friday
                2,
                5.96,
                0,
                2.98,
                2.98
        );

        RentalAgreement result = rentalAgreementGenerator.generateAgreement("CHNS", checkoutDate, 5, 0);

        assertEquals(expected, result);
    }

    @Test
    // one free day for the holiday but we charge for the weekend
    public void testFourthOfJulyWeekendLadder()
    {
        String checkoutDate = "07/02/2020";
        String expectedDueDate = "07/04/2020";

        RentalAgreement expected = new RentalAgreement(
                JAKR,
                3,
                LocalDate.parse(checkoutDate, DateTimeFormatter.ofPattern("MM/dd/yyyy")), //Thursday
                LocalDate.parse(expectedDueDate, DateTimeFormatter.ofPattern("MM/dd/yyyy")), //Friday
                2,
                2.99,
                10,
                0.29,
                2.7
        );

        RentalAgreement result = rentalAgreementGenerator.generateAgreement("LADW", checkoutDate, 3, 10);

        assertEquals(expected, result);
    }

    @Test
    // We charge for the holiday but not the weekend
    public void testFourthOfJulyWeekendChainsaw()
    {
        String checkoutDate = "07/02/2015";
        String expectedDueDate = "07/06/2015";

        RentalAgreement expected = new RentalAgreement(
                JAKR,
                5,
                LocalDate.parse(checkoutDate, DateTimeFormatter.ofPattern("MM/dd/yyyy")), //Thursday
                LocalDate.parse(expectedDueDate, DateTimeFormatter.ofPattern("MM/dd/yyyy")), //Friday
                4,
                4.47,
                25,
                1.12,
                3.35
        );

        RentalAgreement result = rentalAgreementGenerator.generateAgreement("CHNS", checkoutDate, 5, 25);

        assertEquals(expected, result);
    }

    @Test
    //we don't charge for the weekend or holiday
    public void testSeptemberJAKDLaborDay()
    {
        String checkoutDate = "09/03/2015";
        String expectedDueDate = "09/08/2015";

        RentalAgreement expected = new RentalAgreement(
                JAKR,
                6,
                LocalDate.parse(checkoutDate, DateTimeFormatter.ofPattern("MM/dd/yyyy")), //Thursday
                LocalDate.parse(expectedDueDate, DateTimeFormatter.ofPattern("MM/dd/yyyy")), //Friday
                3,
                8.97,
                0,
                0,
                8.97
        );

        RentalAgreement result = rentalAgreementGenerator.generateAgreement("JAKD", checkoutDate, 6, 0);

        assertEquals(expected, result);
    }

    @Test
    //Wee don't charge for weekend or holiday
    public void testJAKRFourthOfJulyWeekend()
    {
        String checkoutDate = "07/02/2015";
        String expectedDueDate = "07/10/2015";

        RentalAgreement expected = new RentalAgreement(
                JAKR,
                9,
                LocalDate.parse(checkoutDate, DateTimeFormatter.ofPattern("MM/dd/yyyy")), //Thursday
                LocalDate.parse(expectedDueDate, DateTimeFormatter.ofPattern("MM/dd/yyyy")), //Friday
                6,
                2.99,
                0,
                0,
                2.99
        );

        RentalAgreement result = rentalAgreementGenerator.generateAgreement("JAKR", checkoutDate, 9, 0);

        assertEquals(expected, result);
    }

    @Test
    public void testJAKRFourthOfJulyWeekendWithDiscount()
    {
        String checkoutDate = "07/02/2020";
        String expectedDueDate = "07/06/2020";

        RentalAgreement expected = new RentalAgreement(
                JAKR,
                4,
                LocalDate.parse(checkoutDate, DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                LocalDate.parse(expectedDueDate, DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                2,
                5.98,
                50,
                2.99,
                2.99
        );

        RentalAgreement result = rentalAgreementGenerator.generateAgreement("JAKR", checkoutDate, 4, 50);

        assertEquals(expected, result);
    }
}