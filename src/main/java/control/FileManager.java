package control;
import entity.Canteen;
import entity.Facility;
import entity.LectureTheater;
import entity.Library;
import exceptions.FileIsEmptyException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.err;
import static java.lang.System.exit;

//@@author zhangyongzhe20
public class FileManager {
    static List<Facility> canteens;
    static List<Facility> libraries;
    static List<Facility> lectureTheaters;

    public static String[] files = {"canteens.txt", "libraries.txt", "lectureTheaters.txt"};

    public static List<Facility> getFacilities() {
        List<Facility> mergedFacilities = new ArrayList<>();
        mergedFacilities.addAll(canteens);
        mergedFacilities.addAll(libraries);
        mergedFacilities.addAll(lectureTheaters);

        return mergedFacilities;
    }

    public static List<Facility> getCanteens() {
        return canteens;
    }

    public static List<Facility> getLibraries() {
        return libraries;
    }

    public static List<Facility> getLectureTheaters() {
        return lectureTheaters;
    }


    public FileManager() {
        this.canteens = new ArrayList<>();
        this.libraries = new ArrayList<>();
        this.lectureTheaters = new ArrayList<>();
        try {
            this.load();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(3);
        } catch (FileIsEmptyException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(3);
        }
    }

    public void load() throws FileNotFoundException, FileIsEmptyException {
        int numOfFiles = files.length;
        Facility facility = new Canteen();

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = null;
        try {
            for (int i = 0; i < numOfFiles; i++) {

                inputStream = classLoader.getResourceAsStream(files[i]);
                if(inputStream == null){
                    throw new FileNotFoundException("No data file is found!");
                }
                if (inputStream.read() == -1) {
                    throw new FileIsEmptyException("This file is empty, please add some data");
                }
                try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                    String data;
                    while ((data = br.readLine()) != null) {
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
                                    err.println("File can not be loaded");
                                    System.exit(0);
                            }
                            facility.setFacilityID(temp[0]);
                            facility.setName(temp[1]);
                            facility.strToFacilityType(temp[2]);
                            facility.setLocation(temp[3], temp[4], temp[5], temp[6]);
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
                                    err.println("Data can not be collected");
                                    System.exit(0);
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
