import java.io.BufferedReader;

public class PartThreeA {

    private static final String RESOURCE_DATA_WEATHER = "weather.dat";

    public static void main(String[] args) {
        System.out.println(CommonUtils.findMinSpreadLabel(RESOURCE_DATA_WEATHER, 2, 3, 1, "mo", "*"));
    }

}
