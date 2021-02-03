package alik.airbnb.util;
import alik.airbnb.lodgement.Apartment;
import alik.airbnb.lodgement.House;
import alik.airbnb.lodgement.Lodgement;
import alik.airbnb.users.Host;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;

public class XMLParser extends DefaultHandler {
    private String firstname;
    private String lastname;
    private int age;
    private int responseTime;
    private int price;
    private int surface;
    private String address;
    private String name;
    private int maxNumberOfTraveler;
    private int balconySurface;
    private int floor;
    private int surfaceOfGarden;
    private boolean hasPool;
    private Host host;
    private House house;
    private Apartment apartment;

    private final ArrayList<Lodgement> lodgements = new ArrayList<Lodgement>();
    private final ArrayList<Host> hosts = new ArrayList<Host>();

    private String elementValue;

    public void XMLParser(){

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementValue = new String(ch, start, length);

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("Appartement") || qName.equalsIgnoreCase("Maison")){
            name = attributes.getValue("name");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("nom")){
            firstname = elementValue;
        }
        if(qName.equalsIgnoreCase(("prenom"))){
            lastname = elementValue;
        }
        if(qName.equalsIgnoreCase("age")){
            age = Integer.parseInt(elementValue);
        }
        if(qName.equalsIgnoreCase("delaiReponse")){
            responseTime = Integer.parseInt(elementValue);
        }
        if(qName.equalsIgnoreCase(("tarifParNuit"))){
            price = Integer.parseInt(elementValue);
        }
        if(qName.equalsIgnoreCase("adresse")){
            address = elementValue;
        }
        if(qName.equalsIgnoreCase("superficie")){
            surface = Integer.parseInt(elementValue);
        }
        if(qName.equalsIgnoreCase("nbVoyageursMax")){
            maxNumberOfTraveler = Integer.parseInt(elementValue);
        }
        if(qName.equalsIgnoreCase("numeroEtage")){
            floor = Integer.parseInt(elementValue);
        }
        if(qName.equalsIgnoreCase("superficieBalcon")){
            balconySurface = Integer.parseInt(elementValue);
        }
        if(qName.equalsIgnoreCase("superficieJardin")){
            surfaceOfGarden = Integer.parseInt(elementValue);
        }
        if(qName.equalsIgnoreCase("possedePiscine")){
            if(elementValue.equals("1")){
                hasPool = true;
            }else {
                hasPool = false;
            }
        }

        if(qName.equalsIgnoreCase("hote")){
            host = new Host(firstname,lastname,age,responseTime);
            boolean addToList = true;
            for (int i = 0; i < hosts.size(); i++){
                Host host1 = hosts.get(i);
                if (host1.equals(host)) {
                    addToList = false;
                    host = host1;
                }
            }
            if(addToList){
                hosts.add(host);
            }

        }
        if(qName.equalsIgnoreCase("Appartement")){
            apartment = new Apartment(host,price,address,surface,maxNumberOfTraveler,floor,balconySurface);
            if(name != null) apartment.setName(name);
            lodgements.add(apartment);
        }
        if (qName.equalsIgnoreCase("Maison")){
            house = new House(host,price,address,surface,maxNumberOfTraveler,surfaceOfGarden,hasPool);
            if(name != null) house.setName(name);
            lodgements.add(house);
        }
    }

    public ArrayList<Lodgement> getLodgements() {
        return lodgements;
    }

    public ArrayList<Host> getHosts() {
        return hosts;
    }
}
