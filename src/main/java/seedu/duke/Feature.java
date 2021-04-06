package seedu.duke;

import control.loadData;
import entity.Facility;

import java.util.ArrayList;
import java.util.List;

//@@cswbibibi
public class Feature {
    public static <T> List<String> listAllLocations(String location) throws NullPointerException {
        List<String> list = null;
        try {
            list = new ArrayList<>();
            if (location.equalsIgnoreCase("canteen")) {
                loadData ld = new loadData();
                List<Facility> canteens = ld.getCanteens();
                for (int i = 0; i < canteens.size(); i++) {
                    System.out.println(canteens.get(i).getName() + "@" + canteens.get(i).getAddress());
                    list.add(canteens.get(i).getName() + "@" + canteens.get(i).getAddress());
                }
            } else if (location.equalsIgnoreCase("lecture theater")) {
                List<Facility> lectureTheaters = loadData.getLectureTheaters();
                for (int i = 0; i < lectureTheaters.size(); i++) {
                    System.out.println(lectureTheaters.get(i).getName() + "@" + lectureTheaters.get(i).getAddress());
                    list.add(lectureTheaters.get(i).getName() + "@" + lectureTheaters.get(i).getAddress());
                }
            } else if (location.equalsIgnoreCase("library")) {
                List<Facility> libraries = loadData.getLibraries();
                for (int i = 0; i < libraries.size(); i++) {
                    System.out.println(libraries.get(i).getName() + "@" + libraries.get(i).getAddress());
                    list.add(libraries.get(i).getName() + "@" + libraries.get(i).getAddress());
                }
            } else {
                System.out.println("Sorry, there's no such facility");
            }
        } catch (Exception e) {
            System.out.println("Sorry, there's no such facility");
        }
        return list;
    }
}


