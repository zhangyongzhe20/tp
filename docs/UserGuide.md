# User Guide

## Introduction

This product named Map provides a user-friendly navigation tool for students to find out about the locations of the facilities in campus. 

## Quick Start

1. Ensure that you have Java 11 or above installed in your Computer.
1. Down the latest version of `Map.jar` from [here](http://link.to/Map).
1. Copy the file to the folder you want to use as the home folder for your Map.
1. Double-click the file to start the app. The GUI similar to the below screenshot should appear in a few seconds.
1. Type the command in the command box and press Enter to execute it.\
   Here are some example commands you can try:\
   `listAllLocarions<canteen>`\
   `search<library92>`
1. Refer to the Features below for details of each command.

## Features 

### **listAllLocations**
List all locations for a specific facility.

Format: `listAllLocarions<facility_type>`

* The `facility_type` can be either canteen, library or lecture theater.
* The `facility_type` are not case sensitive, for example, canteen and Canteen mean the same thing. 

Example of usage: 

`listAllLocarions<Canteen>`\
`listAllLocarions<library>`\
`listAllLocarions<LECTURE THEATER>`

### **search**
Search a facility's location by the facility type and facility id.

Format: `search in building_name`

* The `building_name` can be any building in the campus, and all facilities and its respective id in the building will return to users.
* The `building_name` is not case sensitive, for example, scse and SCSE mean the same thing.

Examples of usage:
`search in SCSE`\

Output: 
`Here are the facilities in "SCSE":`\
`2 (library1 ) locates at  (15.5, 16.6, N1-02-02)`

### **findFacility**
Find the top K nearest facilities of a certai type from a specific location.
  
Format: `findFacility<location><facility_type><top k>`

* The `location`, `facility_type` are not case sensitive.

Examples of usage:
`findFacility<library1><Canteen><2>`\

Output:
`canteen1@N4-01-01`\
`canteen3@N5-04-01`
