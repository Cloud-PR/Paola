package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    public static void saveContract(Contract contract) {
        try {
            File contractFile = new File("src/main/resources/contract.csv");
            FileWriter fw = new FileWriter("src/main/resources/contract.csv", true);
            if (contract instanceof salesContract) {
                String saveInfo = formatSalesContract((salesContract) contract);
                fw.write(saveInfo);
            } else if (contract instanceof leaseContract) {
                String saveInfo = formatLeaseContract((leaseContract) contract);
                fw.write(saveInfo);
            }

            fw.write(System.lineSeparator()); // Add a new line for the next entry
            fw.close();
            System.out.println("Contract saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving contract.");
            e.printStackTrace();
        }
    }

    private static String formatSalesContract(salesContract salesContract) {
        return String.format("Name: %s|SALE|Date: %s|Email: %s|VIN: %s|Year: %d|Make: %s|Model: %s|Type: %s|Color: %s|SalesTax: %.2f|RecordingFee: %.2f|ProcessingFee: %.2f|Total: %.2f|Financed: %s|MonthlyPayment: %.2f",
                salesContract.getCustomerName(), salesContract.getDateOfContract(), salesContract.getCustomerEmail(), salesContract.getVehicleSold().getVin(), salesContract.getVehicleSold().getYear(), salesContract.getVehicleSold().getMake(),
                salesContract.getVehicleSold().getModel(), salesContract.getVehicleSold().getVehicleType(), salesContract.getVehicleSold().getColor(), salesContract.salesTax(), salesContract.recordingFee(), salesContract.processingFee(), salesContract.getTotalPrice(), salesContract.isFinanced(), salesContract.getMonthlyPayment());
    }

    private static String formatLeaseContract(leaseContract leaseContract) {
        return String.format("Name: %s|LEASE|Date: %s|Email: %s|VIN: %s|Year: %d|Make: %s|Model: %s|Type: %s|Color: %s|ExpectingEndingValue: %.2f|LeaseFee: %.2f|MonthlyPayment: %.2f",
                leaseContract.getCustomerName(), leaseContract.getDateOfContract(), leaseContract.getCustomerEmail(), leaseContract.getVehicleSold().getVin(), leaseContract.getVehicleSold().getYear(), leaseContract.getVehicleSold().getMake(),
                leaseContract.getVehicleSold().getModel(), leaseContract.getVehicleSold().getVehicleType(), leaseContract.getVehicleSold().getColor(), leaseContract.getExpectingEndingValue(), leaseContract.getLeaseFee(), leaseContract.getMonthlyPayment());
    }
}
