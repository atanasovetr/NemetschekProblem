import java.text.DecimalFormat;
import java.util.*;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class Parking {
    static final int PARKING_SIZE = 154;
    static final int FIRST_PARKING_SPOT = 74;
    private ParkingSpot[] parking = new ParkingSpot[PARKING_SIZE];

    public void setParking(ParkingSpot[] parking) {
        this.parking = parking;
    }

    public ParkingSpot[] getParking() {
        return parking;
    }

    public ParkingSpot[] sorting(String order){
        ParkingSpot[] sortedParkingArr = new ParkingSpot[PARKING_SIZE];
        List<ParkingSpot> parkingList = new ArrayList<>(Arrays.asList(this.parking));
        int firstIndex = 0;
        Iterator<ParkingSpot> it = parkingList.iterator();

        while(it.hasNext()){
            ParkingSpot ps = it.next();
            try {
                if (ps.getNumber() == FIRST_PARKING_SPOT) {
                    firstIndex = 1;
                    sortedParkingArr[0] = ps;
                    it.remove();
                }
            }
            catch(Exception e){
                break;
            }
        }
        switch (order) {
            case "123" -> parkingList.sort(Comparator.nullsLast(new SortByArea().thenComparing(new SortByName()).thenComparing(new SortByNumber())));
            case "12" -> parkingList.sort(Comparator.nullsLast(new SortByArea().thenComparing(new SortByName())));
            case "13" -> parkingList.sort(Comparator.nullsLast(new SortByArea().thenComparing(new SortByNumber())));
            case "1" -> parkingList.sort(Comparator.nullsLast(new SortByArea()));
            case "213" -> parkingList.sort(Comparator.nullsLast(new SortByName().thenComparing(new SortByArea()).thenComparing(new SortByNumber())));
            case "21" -> parkingList.sort(Comparator.nullsLast(new SortByName().thenComparing(new SortByArea())));
            case "23" -> parkingList.sort(Comparator.nullsLast(new SortByName().thenComparing(new SortByNumber())));
            case "2" -> parkingList.sort(Comparator.nullsLast(new SortByName()));
            case "3" -> parkingList.sort(Comparator.nullsLast(new SortByNumber()));
            default -> System.out.println("This is impossible combination");
        }
        for(int i = firstIndex; i < PARKING_SIZE; i++){
            sortedParkingArr[i] = parkingList.get(i-firstIndex);
        }
        return sortedParkingArr;
    }

    public void fillUpParkingRandom(){
        Random rand = new Random();
        DecimalFormat df = new DecimalFormat("#.##");
        int minArea = 15;
        int maxArea = 20;
        for(int i = 0; i < PARKING_SIZE; i++){
            double area = minArea + (maxArea - minArea) * rand.nextDouble();
            area = Double.parseDouble(df.format(area));

            this.parking[i] = new ParkingSpot(i+1, area, new Person("Firstname", "Lastname"), "blablabla" );
        }
    }

    public void fillUpParkingFromXML(){
        try {
            File inputFile = new File("src\\parking_input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("spot");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    int numberXML = Integer.parseInt(eElement.getElementsByTagName("number").item(0).getTextContent());
                    double areaXML = Double.parseDouble(eElement.getElementsByTagName("area").item(0).getTextContent());
                    Person nameXML = new Person(eElement.getElementsByTagName("firstname").item(0).getTextContent(),
                                        eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    String descriptionXML = eElement.getElementsByTagName("description").item(0).getTextContent();
                    this.parking[temp] = new ParkingSpot(numberXML, areaXML, nameXML, descriptionXML);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            for (ParkingSpot ps : this.parking) {
                sb.append(ps.toString());
            }
        }
        catch (Exception e){
            return sb.toString();
        }
        return sb.toString();
    }

}
