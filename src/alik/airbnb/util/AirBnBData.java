package alik.airbnb.util;

import alik.airbnb.lodgement.Lodgement;
import alik.airbnb.users.Host;
import alik.airbnb.users.Traveler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AirBnBData {
    private static volatile AirBnBData instance = null;
    private ArrayList<Host> hostsList;
    private ArrayList<Lodgement> lodgementsList;

    // private constructor so we can't initialize the object
    private AirBnBData() throws IOException, SAXException, ParserConfigurationException {
        lodgementsList = new ArrayList<>();
        hostsList = new ArrayList<>();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XMLParser xmlParser = new XMLParser();
        saxParser.parse("./src/logements.xml",xmlParser);
        hostsList = xmlParser.getHosts();
        lodgementsList = xmlParser.getLodgements();
    }

    public static AirBnBData getInstance() throws ParserConfigurationException, SAXException, IOException {
        if (instance == null) {
            synchronized (AirBnBData.class) {
                // Double check
                if (instance == null) {
                    instance = new AirBnBData();
                }
            }
        }
        return instance;
    }

    public ArrayList<Host> getHostsList() {
        return hostsList;
    }

    public ArrayList<Lodgement> getLodgementsList() {
        return lodgementsList;
    }
}
