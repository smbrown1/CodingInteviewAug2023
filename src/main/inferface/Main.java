package main.inferface;

import main.rentalAgreement.RentalAgreement;
import main.rentalAgreement.RentalAgreementGenerator;

public class Main
{
    public static void main(String[] args)
    {
        RentalAgreement rentalAgreement = RentalAgreementGenerator.generateAgreement(args[0], args[1], Integer.valueOf(args[2]), Double.valueOf(args[3]));
        System.out.println(rentalAgreement.toString());
    }
}
