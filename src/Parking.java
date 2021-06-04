import java.util.*;

public class Parking {
    private ParkingSpot[] parking = new ParkingSpot[154];

    public void setParking(ParkingSpot[] parking) {
        this.parking = parking;
    }

    public ParkingSpot[] getParking() {
        return parking;
    }

    public ParkingSpot[] sorting(){
        List<ParkingSpot> parkingList = new ArrayList<>();
        ParkingSpot[] sortedParkingArr = new ParkingSpot[154];


        parkingList.addAll(Arrays.asList(this.parking));
        Iterator<ParkingSpot> it = parkingList.iterator();

        while(it.hasNext()){
            ParkingSpot ps = it.next();
            if(ps.getNumber() == 74){
                sortedParkingArr[0] = ps;
                it.remove();
            }
        }
        Collections.sort(parkingList, new SortByArea()); // Here you can choose how to sort the parking lot
        for(int i = 1; i < 154; i++){
            sortedParkingArr[i] = parkingList.get(i-1);
        }
        return sortedParkingArr;
    }

    public void fillUpParking(){
        Random rand = new Random();
        for(int i = 0; i < 154; i++){
            double area = 15 + (20 - 5) * rand.nextDouble();

            this.parking[i] = new ParkingSpot(i+1, area, new Name("Firstname", "Lastname"), "blablabla" );
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(ParkingSpot ps: this.parking){
            sb.append(ps.toString());
        }
        return Arrays.toString(parking);
    }


}
