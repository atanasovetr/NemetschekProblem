import java.util.Comparator;

public class SortByName implements Comparator<ParkingSpot> {
    public int compare(ParkingSpot a, ParkingSpot b){
        String fn1 = a.getName().getFirstName();
        String fn2 = b.getName().getFirstName();

        int result = fn1.compareTo(fn2);
        if(result != 0) return result;
        else{
            String ln1 = a.getName().getLastName();
            String ln2 = b.getName().getLastName();
            return ln1.compareTo(ln2);
        }
    }
}
