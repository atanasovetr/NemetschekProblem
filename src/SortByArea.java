import java.util.Comparator;

public class SortByArea implements Comparator<ParkingSpot> {
    public int compare(ParkingSpot a, ParkingSpot b){
        try {
            if (a.getArea() < b.getArea()) return -1;
            if (a.getArea() > b.getArea()) return 1;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

}
