package control;
import org.junit.jupiter.api.Test;
import seedu.duke.Feature;
import seedu.duke.Parser;


import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@@cswbibibi
public class ListAllLocationsTest {


    @Test
    void listAllCanteenLocations() {
        Parser parser = new Parser();
        String userInput1 = "listAllLocations<canteen>";
        String userInput2 = "listAllLocations<CANTEEN>";
        String userInput3 = "listAllLocations<Canteen>";
        ArrayList expectedOutput = new ArrayList<>(Arrays.asList("canteen1@N4-01-01", "canteen2@N3-02-02", "canteen3@N5-04-01"));
        String location1 = parser.getLocationsList(userInput1);
        String location2 = parser.getLocationsList(userInput2);
        String location3 = parser.getLocationsList(userInput3);
        assertEquals(expectedOutput, Feature.listAllLocations(location1));
        assertEquals(expectedOutput, Feature.listAllLocations(location2));
        assertEquals(expectedOutput, Feature.listAllLocations(location3));
    }

    @Test
    void listAllLibraryLocations() {
        Parser parser = new Parser();
        String userInput1 = "listAllLocations<library>";
        String userInput2 = "listAllLocations<LIBRARY>";
        String userInput3 = "listAllLocations<Library>";
        ArrayList expectedOutput = new ArrayList<>(Arrays.asList("library1@N1-02-02"));
        String location1 = parser.getLocationsList(userInput1);
        String location2 = parser.getLocationsList(userInput2);
        String location3 = parser.getLocationsList(userInput3);
        assertEquals(expectedOutput, Feature.listAllLocations(location1));
        assertEquals(expectedOutput, Feature.listAllLocations(location2));
        assertEquals(expectedOutput, Feature.listAllLocations(location3));
    }

    @Test
    void listAllLectureTheaterLocations() {
        Parser parser = new Parser();
        Feature feature = new Feature();
        String userInput1 = "listAllLocations<Lecture Theater>";
        String userInput2 = "listAllLocations<lecture theater>";
        String userInput3 = "listAllLocations<Lecture theater>";
        String userInput4 = "listAllLocations<LECTURE THEATER>";
        ArrayList expectedOutput = new ArrayList<>(Arrays.asList("lectureTheater1@NS3-05-43"));
        String location1 = parser.getLocationsList(userInput1);
        String location2 = parser.getLocationsList(userInput2);
        String location3 = parser.getLocationsList(userInput3);
        String location4 = parser.getLocationsList(userInput4);
        assertEquals(expectedOutput, feature.listAllLocations(location1));
        assertEquals(expectedOutput, feature.listAllLocations(location2));
        assertEquals(expectedOutput, feature.listAllLocations(location3));
        assertEquals(expectedOutput, feature.listAllLocations(location4));
    }
}

