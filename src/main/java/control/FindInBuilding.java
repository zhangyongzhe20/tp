package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entity.Facility;
import exceptions.BuildingNotFoundException;

public class FindInBuilding {
    private static loadData dataController;
    public FindInBuilding(loadData dataController) {
        this.dataController = dataController;
    }

    public static List<Facility> findByBuildingName(String buildingName) throws BuildingNotFoundException {
        List<Facility> searchResults = new ArrayList<>();
        for (Facility facility: dataController.getFacilities()){
            String currentFacilityBuildingName = facility.getLocation().getBuilding();
            System.out.println(currentFacilityBuildingName);
            if (!currentFacilityBuildingName.toLowerCase(Locale.ROOT).equals(buildingName.toLowerCase(Locale.ROOT))) {
                continue;
            }
            searchResults.add(facility);
        }
        if (searchResults.isEmpty()) {
            throw new BuildingNotFoundException(String.format("Oi where got \"%s\" this kind of building one", buildingName));
        }
        System.out.println("Here are the facilities in \"" +  buildingName + "\":");
        for (Facility searchResult : searchResults) {
            System.out.println(searchResult);
        }
        return searchResults;
    }
}
