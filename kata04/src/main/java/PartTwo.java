import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class PartTwo {

    private static final String RESOURCE_DATA_FILE = "football.dat";

    static private BufferedReader getResourceAsBufferedReader(String filename) {
        URL resource = PartOne.class.getClassLoader().getResource(filename);
        assert resource != null;
        try {
            return new BufferedReader(new FileReader(new File(resource.toURI())));
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException("Couldn't load data file");
        }
    }

    static private String readNextLine(BufferedReader reader) {
        String line;
        try {
            line = reader.readLine();
            if (line == null) return null;
            while (line.isEmpty()) {
                line = readNextLine(reader);
            }
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read the next line from the data file");
        }
        return line;
    }

    static private int getScoreSpread(String[] fields) {
        int max = Integer.parseInt(fields[7].replace("*",""));
        int min = Integer.parseInt(fields[9].replace("*",""));
        return Math.abs(max - min);
    }

    public static void main(String[] args) {
        BufferedReader input = getResourceAsBufferedReader(RESOURCE_DATA_FILE);

        readNextLine(input); // skip the header

        int minSpread = -1;
        String minTeamName = "";

        String dataLine = readNextLine(input);
        while (dataLine != null) {
            String[] fields = dataLine.split("\\s+");
            if (fields.length != 2) {
                int curSpread = getScoreSpread(fields);
                if (minSpread == -1 || curSpread < minSpread) {
                    minSpread = curSpread;
                    minTeamName = fields[2];
                }
            }
            dataLine = readNextLine(input);
        }

        System.out.println(minTeamName);
    }

}
