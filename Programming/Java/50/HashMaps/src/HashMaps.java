import java.util.HashMap;

/**
 * HashMaps
 *      Class that demonstrates how HashMap class works.
 */
public class HashMaps {

    public static void main(String[] args) {

        HashMap<String, String> countries = new HashMap<String, String>();

        countries.put("USA", "Washington DC");
        countries.put("India", "New Delhi");
        countries.put("Pakistan", "Islamabad");
        countries.put("China", "Beijing");

        System.out.println(countries);

        countries.remove("USA");

        System.out.println(countries);

        System.out.println(countries.get("China"));

        countries.clear();

        System.out.println(countries.size());

        countries.put("USA", "Washington DC");
        countries.put("India", "New Delhi");
        countries.put("Pakistan", "Islamabad");
        countries.put("China", "Beijing");

        System.out.println(countries.size());

        countries.put("Japan", "");

        countries.replace("Japan", "Tokyo");

        System.out.println(countries.get("Japan"));

        System.out.println(countries.containsKey("England"));

        System.out.println(countries.containsKey("Beijing"));

        for (String country : countries.keySet()) {
            System.out.printf("%s, %s\n", country, countries.get(country));
        }
    }
}