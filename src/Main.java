import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true){
            Scanner scan = new Scanner(System.in);
            Parking parking = new Parking();
            Parking sortedParking = new Parking();
            System.out.println("1. Fill parking with random info");
            System.out.println("2. Fill parking with info from parking_input.xml");
            System.out.println("0. Exit");

            int option = scan.nextInt();
            if(option == 0) break;

            if(option == 1){
                parking.fillUpParkingRandom();
            }
            else if(option == 2){
                parking.fillUpParkingFromXML();
            }
            else{
                System.out.println("Entered wrong number!");
            }
            if(option == 1 || option == 2){
                System.out.println("Enter how you want to sort the parking in the exact same order as your wish");
                System.out.println("1 - Sort by Area");
                System.out.println("2 - Sort by Name");
                System.out.println("3 - Sort by Number");
                scan.nextLine();
                String sortingOrder = scan.nextLine();
                sortedParking.setParking(parking.sorting(sortingOrder));
                System.out.println(sortedParking);
            }
        }
    }
}
