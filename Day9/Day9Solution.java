import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day9Solution { 
    static ArrayList<City> cities = new ArrayList<City>();
    static Map<String,Integer> routes = new HashMap<String,Integer>();

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("Day9Input.txt"));
        while(in.hasNext()) {
            String[] lineSplit = in.nextLine().split(" ");
            City c = getCity(lineSplit[0]);
            c.addDist(getCity(lineSplit[2]),Integer.parseInt(lineSplit[4]));
        }

        for(City c : cities) {
            getRoutes(c, new ArrayList<String>(), 0);
        }

        Integer[] allRoutes = routes.values().toArray(new Integer[0]);
        Arrays.sort(allRoutes);
        System.out.println("Part One: " + allRoutes[0]);
        System.out.println("Part Two: "+ allRoutes[allRoutes.length - 1]);
        in.close();
    }

    public static City getCity(String s) {
        for(City c: cities)
            if(c.name.equals(s))
                return c;
        City city = new City(s);
        cities.add(city);
        return city;
    }

    public static void getRoutes(City city, ArrayList<String> list, int sum) {
        list.add(city.name);
        for(City c : city.dist.keySet()) {
            if(!list.contains(c.name))
                getRoutes(c,new ArrayList<String>(list),sum+city.dist.get(c));
            else if(list.size() == cities.size())
                routes.put(Arrays.toString(list.toArray()),sum);
        }
    }
}

class City {
    String name;
    Map<City,Integer> dist = new HashMap<City,Integer>();

    City(String n) {
        name = n;
    }
    
    public void addDist(City c, int d) {
        dist.put(c, d);
        c.dist.put(this, d);
    }
}