public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking();
        parking.fillUpParkingRandom();
//        System.out.println(parking);

        System.out.println("------------------------");

        Parking sortedParking = new Parking();
        sortedParking.setParking(parking.sorting());
//        System.out.println(sortedParking);

        Parking parking2 = new Parking();
        parking2.fillUpParkingFromXML();
        System.out.println(parking2);
    }
}
