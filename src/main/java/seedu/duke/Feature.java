package seedu.duke;

import control.FileManager;
import entity.Facility;

import java.util.ArrayList;
import java.util.List;

//@@cswbibibi
public class Feature {
    public static <T> List<String> listAllLocations(String location) {
        List<String> list = new ArrayList<>();
        switch (location) {
        case "Canteen":
        case "canteen":
        case "CANTEEN":
            FileManager ld = new FileManager();
            List<Facility> canteens = ld.getCanteens();
            for (int i=0; i<canteens.size(); i++) {
                System.out.println(canteens.get(i).getName() + "@" + canteens.get(i).getAddress());
                list.add(canteens.get(i).getName() + "@" + canteens.get(i).getAddress());
            }
            break;
        case "Lecture Theater":
        case "lecture theater":
        case "Lecture theater":
        case "LECTURE THEATER":
            List<Facility> lectureTheaters = FileManager.getLectureTheaters();
            for (int i=0; i<lectureTheaters.size(); i++) {
                System.out.println(lectureTheaters.get(i).getName() + "@" + lectureTheaters.get(i).getAddress());
                list.add(lectureTheaters.get(i).getName() + "@" + lectureTheaters.get(i).getAddress());
            }


            break;
        case "Library":
        case "LIBRARY":
        case "library":
            List<Facility> libraries = FileManager.getLibraries();
            for (int i=0; i<libraries.size(); i++) {
                System.out.println(libraries.get(i).getName() + "@" + libraries.get(i).getAddress());
                list.add(libraries.get(i).getName() + "@" + libraries.get(i).getAddress());
            }
            break;
        default:
            break;
        }
        return list;
    }
}


