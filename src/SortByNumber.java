import java.util.Comparator;

public class SortByNumber implements Comparator<ParkingSpot> {
    public int compare(ParkingSpot a, ParkingSpot b){
        try {
            return a.getNumber() - b.getNumber();
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
