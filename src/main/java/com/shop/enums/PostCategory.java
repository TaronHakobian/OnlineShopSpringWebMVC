package com.shop.enums;

import java.util.ArrayList;
import java.util.Arrays;

public class PostCategory {

    public enum Vehicle {
        Car, Bike, Bus;
    }

    public enum Cloths {
        Shoes, Clothing, Underwear
    }

    public enum Accessories {
        Jewellery, Watches
    }

    public enum Jobs {
        ProgrammingAndDevelopment,
        ScienceAndEngineering,
        MediaAndDesign
    }


    public static String getSuperCategory(String subSector) {
        switch (subSector) {
            case "Car", "Bus", "Bike" -> {
                return "Vehicle";
            }
            case "Shoes", "Underwear", "Clothing" -> {
                return "Cloths";
            }
            case "Jewellery", "Watches" -> {
                return "Accessories";
            }
            case "ProgrammingAndDevelopment", "MediaAndDesign", "ScienceAndEngineering" -> {
                return "Jobs";
            }
        }
        return null;
    }


    public static ArrayList<String> getSubSectors(String category) {
        switch (category) {
            case "Accessories" -> {
                return new ArrayList<>(Arrays.asList(Accessories.Jewellery.toString(),
                        Accessories.Watches.toString()));
            }
            case "Jobs" -> {
                return new ArrayList<>(Arrays.asList(Jobs.MediaAndDesign.toString(),
                        Jobs.ProgrammingAndDevelopment.toString(),
                        Jobs.ScienceAndEngineering.toString()));
            }
            case "Vehicle" -> {
                return new ArrayList<>(Arrays.asList(Vehicle.Car.toString(),
                        Vehicle.Bike.toString(),
                        Vehicle.Bus.toString()));
            }
            case "Cloths" -> {
                return new ArrayList<>(Arrays.asList(Cloths.Clothing.toString(),
                        Cloths.Shoes.toString(),
                        Cloths.Underwear.toString()));
            }
        }
        return null;
    }

}
