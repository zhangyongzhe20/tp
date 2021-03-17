package control;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Canteen;
import entity.Facility;
import entity.LectureTheater;
import entity.Library;
import entity.Location;

class SearchFacilityTest {
    static loadData fakeDataController;
    SearchFacility moduleUnderTest;

    @BeforeAll
    public static void initializeDb() {
        fakeDataController = mock(loadData.class);

        List<Facility> fakeLibraries = new ArrayList<>();
        fakeLibraries.add(new Library(69, "library69", new Location(6.9, 6.9, "N4-01-01")));
        when( fakeDataController.getLibraries()).thenReturn( fakeLibraries );

        List<Facility> fakeCanteens = new ArrayList<>();
        fakeCanteens.add(new Canteen(66, "canteen66", new Location(6.9, 6.9, "N4-01-01")));
        when( fakeDataController.getCanteens()).thenReturn( fakeCanteens );

        List<Facility> fakeLectureTheaters = new ArrayList<>();
        fakeLectureTheaters.add(new LectureTheater(88, "canteen88", new Location(6.9, 6.9, "N4-01-01")));
        when( fakeDataController.getLectureTheaters()).thenReturn( fakeLectureTheaters );

    }

    @BeforeEach
    public void initializeModuleUnderTest() {
        moduleUnderTest  = new SearchFacility(fakeDataController);
    }

    @Test
    public void query_library_69_returns_true() {
        boolean foundLibrary = moduleUnderTest.query("library", 69);
        assert (foundLibrary);
    }

    @Test
    public void query_canteens_66_returns_true() {
        boolean foundLibrary = moduleUnderTest.query("canteen", 66);
        assert (foundLibrary);
    }

    @Test
    public void query_lt_88_returns_true() {
        boolean foundLibrary = moduleUnderTest.query("lecturetheater", 88);
        assert (foundLibrary);
    }

    @Test
    public void query_nonexistent_lt_returns_false() {
        boolean foundLibrary = moduleUnderTest.query("lecturetheater", 8888);
        assert (!foundLibrary);
    }

    @Test
    public void query_nonexistent_canteen_returns_false() {
        boolean foundLibrary = moduleUnderTest.query("library", 6969);
        assert (!foundLibrary);
    }

    @Test
    public void query_nonexistent_library_returns_false() {
        boolean foundLibrary = moduleUnderTest.query("lecturetheater", 29126);
        assert (!foundLibrary);
    }

}