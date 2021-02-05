package alik.airbnb.util;

import alik.airbnb.lodgement.Apartment;
import alik.airbnb.lodgement.House;
import alik.airbnb.lodgement.Lodgement;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Search {


    private enum SearchChoice{
        YES(0,"YES"),
        NO(1,"No"),
        NEITHER(2,"Neither");

        private int value;
        private String name;

        private SearchChoice(int value, String name){
            this.value = value;
            this.name = name;
        }

    }

    //required parameters
    private final int numberOfPersons;
    //optional parameters
    private final int maxPricePerNight;
    private final int minPricePerNight;
    private final SearchChoice hasPool;
    private final SearchChoice hasGarden;
    private final SearchChoice hasBalcony;

    private Search(SearchBuilder builder){
        this.numberOfPersons = builder.numberOfPersons;
        this.maxPricePerNight = builder.maxPricePerNight;
        this.minPricePerNight = builder.minPricePerNight;
        this.hasPool = builder.hasPool;
        this.hasGarden = builder.hasGarden;
        this.hasBalcony = builder.hasBalcony;
    }

    public ArrayList<Lodgement> result(){
        ArrayList<Lodgement> lodgements = new ArrayList<>();
        ArrayList<Lodgement> result = new ArrayList<>();
        try {
            AirBnBData data = AirBnBData.getInstance();
            lodgements = data.getLodgementsList();
        }catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }
        for (Lodgement lodgement : lodgements) {
            if(lodgement.getMaxNumberOfTraveler() <= numberOfPersons){
                continue;
            }
            if(lodgement.getPrice() > minPricePerNight || lodgement.getPrice() < minPricePerNight){
                continue;
            }
            // Test pour la piscine
            if(hasPool == SearchChoice.YES){
                if(lodgement instanceof House){
                    if(!((House) lodgement).getHasPool()){
                        continue;
                    }
                }else {
                    continue;
                }
            }
            if(hasPool == SearchChoice.NO){
                if(lodgement instanceof House){
                    if(((House) lodgement).getHasPool()){
                        continue;
                    }
                }
            }
            //Test pour le jardin
            if (hasGarden == SearchChoice.YES){
                if(lodgement instanceof House){
                    if(((House) lodgement).getSurfaceOfGarden() == 0){
                        continue;
                    }
                }else {
                    continue;
                }
            }
            if (hasGarden == SearchChoice.NO){
                if(lodgement instanceof House){
                    if(((House) lodgement).getSurfaceOfGarden() != 0){
                        continue;
                    }
                }
            }
            //Test pour le Balcon
            if(hasBalcony == SearchChoice.YES){
                if (lodgement instanceof Apartment){
                    if(((Apartment) lodgement).getBalconySurface() == 0){
                        continue;
                    }
                }else {
                    continue;
                }
            }
            if(hasBalcony == SearchChoice.NO){
                if (lodgement instanceof Apartment){
                    if(((Apartment) lodgement).getBalconySurface() != 0){
                        continue;
                    }
                }
            }
            result.add(lodgement);
        }
        return result;
    }
    private Predicate<Lodgement> predicateNumberOfPersons(){
        return lodgement -> numberOfPersons <= lodgement.getMaxNumberOfTraveler();
    }


    public List<Lodgement> result2(){
        ArrayList<Lodgement> lodgements = new ArrayList<>();
        List<Lodgement> result = new ArrayList<>();
        try {
            AirBnBData data = AirBnBData.getInstance();
            lodgements = data.getLodgementsList();
        }catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }
         result = lodgements.stream().filter(predicateNumberOfPersons()).collect(Collectors.toList());
        return result;
    }

    public static class SearchBuilder{
        //required parameters
        private final int numberOfPersons;
        //optional parameters
        private int maxPricePerNight;
        private int minPricePerNight;
        private SearchChoice hasPool;
        private SearchChoice hasGarden;
        private SearchChoice hasBalcony;

        public SearchBuilder(int numberOfPersons){
            this.numberOfPersons = numberOfPersons;
            this.maxPricePerNight = Integer.MAX_VALUE;
            this.minPricePerNight = 0;
            this.hasPool = SearchChoice.NEITHER;
            this.hasBalcony = SearchChoice.NEITHER;
            this.hasGarden = SearchChoice.NEITHER;
        }

        public SearchBuilder setMaxPricePerNight(int maxPricePerNight){
            this.maxPricePerNight = maxPricePerNight;
            return this;
        }
        public SearchBuilder setMinPricePerNight(int minPricePerNight){
            this.minPricePerNight = minPricePerNight;
            return this;
        }
        public SearchBuilder setHasPool(boolean hasPool){
            this.hasPool = hasPool ? SearchChoice.YES : SearchChoice.NO;
            return this;
        }
        public SearchBuilder setHasGarden(boolean hasGarden){
            this.hasGarden = hasGarden ? SearchChoice.YES : SearchChoice.NO;
            return this;
        }
        public SearchBuilder setHasBalcony(boolean hasBalcony){
            this.hasBalcony = hasBalcony ? SearchChoice.YES : SearchChoice.NO;
            return this;
        }
        public Search build(){
            return new Search(this);
        }
    }

}
