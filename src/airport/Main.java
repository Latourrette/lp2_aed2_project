package airport;

import edu.princeton.cs.algs4.*;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        RedBlackBST<String, Airport> airportST = new RedBlackBST<>();

        loadFromFileAirport(airportST, ".//data//airports.txt");
        loadFromFileAirplane(airportST, ".//data//airplanes.txt");

        //printAllAirports(airportST);
        //printAirplanesByAirport(airportST);
        //printAirport(airportST);
        printAirplane(airportST);
    }

    public static void loadFromFileAirport(RedBlackBST<String, Airport> airportST, String path) {
        In in = new In(path);
        try {
            while (!in.isEmpty()) {
                String[] text = in.readLine().split(";");
                String name = text[0];
                String code = text[1];
                String city = text[2];
                String country = text[3];
                String continent = text[4];
                Float classification = Float.parseFloat(text[5]);


                Airport a = new Airport(name, code, city, country, continent, classification);
                airportST.put(code, a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void loadFromFileAirplane(RedBlackBST<String, Airport> airportST, String path) {
        In in = new In(path);
        try {
            while (!in.isEmpty()) {
                String[] text = in.readLine().split(";");
                String id = text[0];
                String model = text[1];
                String name = text[2];
                String airline = text[3];
                Integer cruiseSpeed = Integer.parseInt(text[4]);
                Integer cruiseAltitude = Integer.parseInt(text[5]);
                Integer maxDistance = Integer.parseInt(text[6]);
                String currentAirport = text[7];
                Integer maxCapacity = Integer.parseInt(text[8]);
                Integer fuelCapacity = Integer.parseInt(text[9]);

                Airplane a = new Airplane(id, model, name, airline, cruiseSpeed, cruiseAltitude, maxDistance,
                        currentAirport, maxCapacity, fuelCapacity);
                airportST.get(currentAirport).getAirplaneST().put(id, a);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void printAllAirports(RedBlackBST<String, Airport> airportST) {

        System.out.println("Airports list:");
        System.out.println("");

        for (String i : airportST.keys()) {
            System.out.println("Name: " + airportST.get(i).getName());
            System.out.println("Key: " + airportST.get(i).getCode());
            System.out.println("City: " + airportST.get(i).getCity());
            System.out.println("Country: " + airportST.get(i).getCountry());
            System.out.println("Continent: " + airportST.get(i).getContinent());
            System.out.println("Rating: " + airportST.get(i).getRating());
            System.out.println("");
        }
    }

    public static void printAirport(RedBlackBST<String, Airport> airportST) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Choose the airport code to get information: ");
        String code = scan.nextLine();

        System.out.println("Information of Airport: " + airportST.get(code).getName());

        System.out.println("\tName: " + airportST.get(code).getName());
        System.out.println("\tCode: " + airportST.get(code).getCode());
        System.out.println("\tCity: " + airportST.get(code).getCity());
        System.out.println("\tCountry: " + airportST.get(code).getCountry());
        System.out.println("\tContinent: " + airportST.get(code).getContinent());
        System.out.println("\tRating: " + airportST.get(code).getRating());
        System.out.println("");
    }

    public static void printAirportByCountry(RedBlackBST<String, Airport> airportST){}

    public static void printAirplanesByAirport(RedBlackBST<String, Airport> airportST) {

        for (String i : airportST.keys()) {
            System.out.println("Airplanes in " + airportST.get(i).getName());
            for (String j : airportST.get(i).getAirplaneST().keys()) {
                System.out.println("\tID: " + airportST.get(i).getAirplaneST().get(j).getId());
                System.out.println("\tModel: " + airportST.get(i).getAirplaneST().get(j).getModel());
                System.out.println("\tName: " + airportST.get(i).getAirplaneST().get(j).getName());
                System.out.println("\tAirline: " + airportST.get(i).getAirplaneST().get(j).getAirline());
                System.out.println("\tCruise Speed: " + airportST.get(i).getAirplaneST().get(j).getCruiseSpeed());
                System.out.println("\tCruise Altitude: " + airportST.get(i).getAirplaneST().get(j).getCruiseAltitude());
                System.out.println("\tMax Distance: " + airportST.get(i).getAirplaneST().get(j).getMaxDistance());
                System.out.println("\tCurrent Airport: " + airportST.get(i).getAirplaneST().get(j).getCurrentAirport());
                System.out.println("\tMax Capacity: " + airportST.get(i).getAirplaneST().get(j).getMaxCapacity());
                System.out.println("\tFuel Capacity: " + airportST.get(i).getAirplaneST().get(j).getFuelCapacity());
                System.out.println("");

            }
        }
    }

    public static void printAirplane(RedBlackBST<String, Airport> airportST) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Choose the airplane id to get information: ");
        String id = scan.nextLine();
        for (String i : airportST.keys()) {
            for (String j : airportST.get(i).getAirplaneST().keys())
                if (airportST.get(i).getAirplaneST().get(j).getId().equals(id)) {
                    System.out.println("\tID: " + airportST.get(i).getAirplaneST().get(j).getId());
                    System.out.println("\tModel: " + airportST.get(i).getAirplaneST().get(j).getModel());
                    System.out.println("\tName: " + airportST.get(i).getAirplaneST().get(j).getName());
                    System.out.println("\tAirline: " + airportST.get(i).getAirplaneST().get(j).getAirline());
                    System.out.println("\tCruise Speed: " + airportST.get(i).getAirplaneST().get(j).getCruiseSpeed());
                    System.out.println("\tCruise Altitude: " + airportST.get(i).getAirplaneST().get(j).getCruiseAltitude());
                    System.out.println("\tMax Distance: " + airportST.get(i).getAirplaneST().get(j).getMaxDistance());
                    System.out.println("\tCurrent Airport: " + airportST.get(i).getAirplaneST().get(j).getCurrentAirport());
                    System.out.println("\tMax Capacity: " + airportST.get(i).getAirplaneST().get(j).getMaxCapacity());
                    System.out.println("\tFuel Capacity: " + airportST.get(i).getAirplaneST().get(j).getFuelCapacity());
                    System.out.println("");
                }
        }
    }
}
