package seedu.duke;

import control.loadData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {


    @Test
    void findFacilityByName_validLibrary() throws InvalidCommandException {
        Map map = new Map();
        loadData ld = map.getDataController();
        String outputFacility = map.findFacilityByName(ld, "library1").getName();
        String expectedFacilityFound = "library1";
        assertEquals(expectedFacilityFound, outputFacility);

    }

    @Test
    void findFacilityByName_validCanteen() throws InvalidCommandException {
        Map map = new Map();
        loadData ld = map.getDataController();
        String outputFacility = map.findFacilityByName(ld, "canteen1").getName();
        String expectedFacilityFound = "canteen1";
        assertEquals(expectedFacilityFound, outputFacility);

    }

    @Test
    void findFacilityByName_validLT() throws InvalidCommandException {
        Map map = new Map();
        loadData ld = map.getDataController();
        String outputFacility = map.findFacilityByName(ld, "lectureTheater1").getName();
        String expectedFacilityFound = "lectureTheater1";
        assertEquals(expectedFacilityFound, outputFacility);

    }
    @Test
    void findFacilityByName_invalidLT() throws InvalidCommandException {
        Map map = new Map();
        loadData ld = map.getDataController();
        assertThrows(InvalidCommandException.class, () -> {
            map.findFacilityByName(ld, "lectureTheater3");
        });

    }

}