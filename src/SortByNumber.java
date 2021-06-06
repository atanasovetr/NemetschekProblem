import java.util.Comparator;

public class SortByNumber implements Comparator<ParkingSpot> {
    public int compare(ParkingSpot a, ParkingSpot b){
        return a.getNumber() - b.getNumber();
    }
}
