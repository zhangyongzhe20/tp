package control;

import static org.mockito.Mockito.mockStatic;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

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
        try (MockedStatic<loadData> theMock = mockStatic(loadData.class)) {
            List<Facility> fakeLibraries = new ArrayList<>();
            fakeLibraries.add(new Library(69, "library69", new Location(6.9, 6.9,
                    "N4-01-01", "building69")));
            theMock.when( loadData::getLibraries ).thenReturn( fakeLibraries );

            List<Facility> fakeCanteens = new ArrayList<>();
            fakeCanteens.add(new Canteen(66, "canteen66", new Location(6.9, 6.9,
                    "N4-01-01", "building69")));
            theMock.when( loadData::getCanteens ).thenReturn( fakeCanteens );

            List<Facility> fakeLectureTheaters = new ArrayList<>();
            fakeLectureTheaters.add(new LectureTheater(88, "canteen88", new Location(6.9, 6.9,
                    "N4-01-01", "building69")));
            theMock.when( loadData::getLectureTheaters ).thenReturn( fakeLectureTheaters );
        }
    }

    @BeforeEach
    public void initializeModuleUnderTest() {
        moduleUnderTest  = new SearchFacility(fakeDataController);
    }

    @Test
    public void query_library_69_returns_true() {
        try (MockedStatic<loadData> theMock = mockStatic(loadData.class)) {
            List<Facility> fakeLibraries = new ArrayList<>();
            fakeLibraries.add(new Library(69, "library69", new Location(6.9, 6.9,
                    "N4-01-01", "building69")));
            theMock.when( loadData::getLibraries ).thenReturn( fakeLibraries );

            boolean foundLibrary = moduleUnderTest.query("library", 69);
            assert (foundLibrary);
        }
    }

    @Test
    public void query_canteens_66_returns_true() {
        try (MockedStatic<loadData> theMock = mockStatic(loadData.class)) {
            List<Facility> fakeCanteens = new ArrayList<>();
            fakeCanteens.add(new Canteen(66, "canteen66", new Location(6.9, 6.9,
                    "N4-01-01", "building69")));
            theMock.when( loadData::getCanteens ).thenReturn( fakeCanteens );

            boolean foundLibrary = moduleUnderTest.query("canteen", 66);
            assert (foundLibrary);
        }
    }

    @Test
    public void query_lt_88_returns_true() {
        try (MockedStatic<loadData> theMock = mockStatic(loadData.class)) {
            List<Facility> fakeLectureTheaters = new ArrayList<>();
            fakeLectureTheaters.add(new LectureTheater(88, "lecturetheater88", new Location(6.9,
                    6.9, "N4-01-01", "building69")));
            theMock.when( loadData::getLectureTheaters ).thenReturn( fakeLectureTheaters );

            boolean foundLibrary = moduleUnderTest.query("lecturetheater", 88);
            assert (foundLibrary);
        }
    }

    @Test
    public void query_nonexistent_lt_returns_false() {
        try (MockedStatic<loadData> theMock = mockStatic(loadData.class)) {
            List<Facility> fakeLectureTheaters = new ArrayList<>();
            fakeLectureTheaters.add(new LectureTheater(88, "lecture88", new Location(6.9,
                    6.9, "N4-01-01", "building69")));
            theMock.when( loadData::getLectureTheaters ).thenReturn( fakeLectureTheaters );

            boolean foundLibrary = moduleUnderTest.query("lecturetheater", 8888);
            assert (!foundLibrary);
        }
    }

    @Test
    public void query_nonexistent_canteen_returns_false() {
        try (MockedStatic<loadData> theMock = mockStatic(loadData.class)) {
            List<Facility> fakeLibraries = new ArrayList<>();
            fakeLibraries.add(new Library(69, "library69", new Location(6.9,
                    6.9, "N4-01-01", "building69")));
            theMock.when( loadData::getLibraries ).thenReturn( fakeLibraries );

            boolean foundLibrary = moduleUnderTest.query("library", 6969);
            assert (!foundLibrary);
        }
    }

    @Test
    public void query_nonexistent_library_returns_false() {
        try (MockedStatic<loadData> theMock = mockStatic(loadData.class)) {
            List<Facility> fakeLectureTheaters = new ArrayList<>();
            fakeLectureTheaters.add(new LectureTheater(88, "lecture88", new Location(6.9,
                    6.9, "N4-01-01", "building69")));
            theMock.when( loadData::getLectureTheaters ).thenReturn( fakeLectureTheaters );

            boolean foundLibrary = moduleUnderTest.query("lecturetheater", 29126);
            assert (!foundLibrary);
        }
    }

}