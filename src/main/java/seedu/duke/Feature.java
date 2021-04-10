package seedu.duke;

import control.FileManager;
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
                FileManager fm = new FileManager();
                List<Facility> canteens = fm.getCanteens();
                for (int i = 0; i < canteens.size(); i++) {
                    System.out.println(canteens.get(i).getName() + "@" + canteens.get(i).getAddress());
                    list.add(canteens.get(i).getName() + "@" + canteens.get(i).getAddress());
                }
            } else if (location.equalsIgnoreCase("lecture theater")) {
                FileManager fm = new FileManager();
                List<Facility> lectureTheaters = fm.getLectureTheaters();
                for (int i = 0; i < lectureTheaters.size(); i++) {
                    System.out.println(lectureTheaters.get(i).getName() + "@" + lectureTheaters.get(i).getAddress());
                    list.add(lectureTheaters.get(i).getName() + "@" + lectureTheaters.get(i).getAddress());
                }
            } else if (location.equalsIgnoreCase("library")) {
                FileManager fm = new FileManager();
                List<Facility> libraries = fm.getLibraries();
                for (int i = 0; i < libraries.size(); i++) {
                    System.out.println(libraries.get(i).getName() + "@" + libraries.get(i).getAddress());
                    list.add(libraries.get(i).getName() + "@" + libraries.get(i).getAddress());
                }
            } else {
                System.out.println("Sorry, there's no such facility");
            }
        } catch (Exception e) {
            System.out.println("We couldn't find the facility you are searching, please input the correct facility name.");
        }
        return list;
    }
}


