package test.rentalAgreement;

import main.rentalAgreement.RentalAgreement;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static main.rentalAgreement.Tool.JAKD;
import static org.junit.jupiter.api.Assertions.*;

class RentalAgreementTest
{
    @Test
    void testToString()
    {
        RentalAgreement example = new RentalAgreement(
                JAKD,
                6,
                LocalDate.parse("09/03/2015", DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                LocalDate.parse("09/08/2015", DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                3,
                8.97,
                0,
                0,
                8.97
        );

        String expected = "Tool code: JAKD" +
                "\nTool type: JACKHAMMER" +
                "\nTool brand: DeWalt" +
                "\nRental days: 6" +
                "\nCheck out date: 09/03/2015" +
                "\nDue date: 09/08/2015" +
                "\nDaily rental charge: 2.99" +
                "\nCharge days: 3" +
                "\nDiscount percent: 0.0" +
                "\nDiscount amount: 0.00" +
                "\nFinal charge: 8.97";

        String result = example.toString();
        assertEquals(expected, result);
    }
}