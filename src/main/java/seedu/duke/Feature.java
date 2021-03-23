package seedu.duke;

import java.util.List;
import control.*;
import entity.*;

public class Feature {
    public static void listAllLocations(String location) {
        switch (location) {
        case "Canteen":
        case "canteen":
            loadData ld = new loadData();
            List<Facility> canteens = ld.getCanteens();
            for (int i=0; i<canteens.size(); i++) {
                System.out.println(canteens.get(i).getName() + "@" + canteens.get(i).getAddress());
            }
            break;
        case "Lecture Theater":
        case "lecture theater":
        case "Lecture theater":
            List<Facility> lectureTheaters = loadData.getLectureTheaters();
            for (int i=0; i<lectureTheaters.size(); i++) {
                System.out.println(lectureTheaters.get(i).getName() + "@" + lectureTheaters.get(i).getAddress());
            }
            break;
        case "Library":
        case "library":
            List<Facility> libraries = loadData.getLibraries();
            for (int i=0; i<libraries.size(); i++) {
                System.out.println(libraries.get(i).getName() + "@" + libraries.get(i).getAddress());
            }
            break;
        default:
            break;
        }
    }
}


