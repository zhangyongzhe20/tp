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

    public List<Facility> getCanteens() {
        return canteens;
    }

    public List<Facility> getLibraries() {
        return libraries;
    }

    public List<Facility> getLectureTheaters() {
        return lectureTheaters;
    }

    List<Facility> lectureTheaters;
    public static String[] files = {"canteens.txt", "libraries.txt", "lectureTheaters.txt"};

    public loadData() {
        this.canteens = new ArrayList<>();
        this.libraries = new ArrayList<>();
        this.lectureTheaters = new ArrayList<>();
        try {
            this.load();
        } catch (FileNotFoundException e) {
            System.err.println("WARNING: did not find a file to initialize data from.");
        } catch (FileIsEmptyException e) {
            System.err.println("WARNING: file to initalize data from is empty.");
        }
    }

    public void load() throws FileNotFoundException, FileIsEmptyException {
        int numOfFiles = files.length;
        Facility facility = new Canteen();
        for (int i = 0; i < numOfFiles; i++) {
            File file = new File(files[i]);
            if(file.length() == 0){
                throw new FileIsEmptyException("This file is empty, please add some data");
            }
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
                    facility.strToFacilityType(temp[2]);
                    facility.setLocation(temp[3], temp[4], temp[5]);
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
