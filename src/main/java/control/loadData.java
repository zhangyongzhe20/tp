package control;
import entity.Canteen;
import entity.Facility;
import entity.LectureTheater;
import entity.Library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class loadData {
    List<Facility> canteens;
    List<Facility> libraries;
    List<Facility> lectureTheaters;
    public static String[] files = {"canteens.txt", "libraries.txt", "lectureTheaters.txt"};

    public loadData() {
        this.canteens = new ArrayList<>();
        this.libraries = new ArrayList<>();
        this.lectureTheaters = new ArrayList<>();
    }

    public void load() throws FileNotFoundException {
        int numOfFiles = files.length;
        Facility facility = new Canteen();
        for (int i = 0; i < numOfFiles; i++) {
            File file = new File(files[i]);
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            Scanner sc = new Scanner(file);
            String data;
            while (sc.hasNextLine()) {
                data = sc.nextLine();
                if (!data.isEmpty()) {
                    String[] temp = data.split(",");
                    switch (i) {
                        case 0:
                            facility = new Canteen();
                            break;
                        case 1:
                            facility = new Library();
                            break;
                        case 2:
                            facility = new LectureTheater();
                            break;
                        default:
                            System.err.println("File can not be loaded");
                            System.exit(0);
                    }
                    facility.setFacilityID(temp[0]);
                    facility.setName(temp[1]);
                    facility.setFacilityID(temp[2]);
                    facility.setLocation(temp[3], temp[4]);
                    switch (i) {
                        case 0:
                            canteens.add(facility);
                            break;
                        case 1:
                            libraries.add(facility);
                            break;
                        case 2:
                            lectureTheaters.add(facility);
                            break;
                        default:
                            System.err.println("Data can not be collected");
                            System.exit(0);
                    }
                }
            }
            sc.close();
        }
    }
}