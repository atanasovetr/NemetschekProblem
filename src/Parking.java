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

    public ParkingSpot[] sorting(){
        ParkingSpot[] sortedParkingArr = new ParkingSpot[PARKING_SIZE];
        List<ParkingSpot> parkingList = new ArrayList<>(Arrays.asList(this.parking));
        
        Iterator<ParkingSpot> it = parkingList.iterator();

        while(it.hasNext()){
            ParkingSpot ps = it.next();
            if(ps.getNumber() == FIRST_PARKING_SPOT){
                sortedParkingArr[0] = ps;
                it.remove();
            }
        }
        Collections.sort(parkingList, new SortByArea()); // Here you can choose how to sort the parking lot
        for(int i = 1; i < PARKING_SIZE; i++){
            sortedParkingArr[i] = parkingList.get(i-1);
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

            this.parking[i] = new ParkingSpot(i+1, area, new Name("Firstname", "Lastname"), "blablabla" );
        }
    }

    public void fillUpParkingFromXML(){
        try {
            File inputFile = new File("src\\parking_input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("spot");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    int numberXML = Integer.parseInt(eElement.getElementsByTagName("number").item(0).getTextContent());
                    double areaXML = Double.parseDouble(eElement.getElementsByTagName("area").item(0).getTextContent());
                    Name nameXML = new Name(eElement.getElementsByTagName("firstname").item(0).getTextContent(),
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
