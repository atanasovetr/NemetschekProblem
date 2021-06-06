public class ParkingSpot {
    private int number;
    private double area;
    private Person name;
    private String description;

    public ParkingSpot(int number, double area, Person name, String description) {
        this.number = number;
        this.area = area;
        this.name = name;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Person getName() {
        return name;
    }

    public void setName(Person name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ParkingSpot: " +
                "Number= " + number +
                ", Area= " + area +
                ", Name= " + name +
                ", Description= " + description  + System.lineSeparator();
    }
}
