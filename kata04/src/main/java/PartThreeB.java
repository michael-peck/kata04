import java.io.BufferedReader;

public class PartThreeB {

    private static final String RESOURCE_DATA_FOOTBALL = "football.dat";

    public static void main(String[] args) {
        System.out.println(CommonUtils.findMinSpreadLabel(RESOURCE_DATA_FOOTBALL, 7, 9, 2, "-------------------------------------------------------", ""));
    }

}
