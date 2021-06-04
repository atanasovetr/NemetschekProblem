public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking();
        parking.fillUpParking();
        System.out.println(parking);

        System.out.println("------------------------");

        Parking sortedParking = new Parking();
        sortedParking.setParking(parking.sorting());
        System.out.println(sortedParking);
    }
}
