import java.util.Comparator;

public class SortByArea implements Comparator<ParkingSpot> {
    public int compare(ParkingSpot a, ParkingSpot b){
        if(a.getArea() < b.getArea()) return -1;
        if(a.getArea() > b.getArea()) return 1;
        return 0;
    }

}
