import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class CommonUtils {

    static BufferedReader getResourceAsBufferedReader(String filename) {
        URL resource = CommonUtils.class.getClassLoader().getResource(filename);
        assert resource != null;
        try {
            return new BufferedReader(new FileReader(new File(resource.toURI())));
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException("Couldn't load data file");
        }
    }

    static String readNextLine(BufferedReader reader, String skipString) {
        String line;
        try {
            line = reader.readLine();
            if (line == null) return null;
            while (line.isEmpty() || line.contains(skipString)) {
                line = readNextLine(reader, skipString);
                if (line == null) return null;
            }
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read the next line from the data file");
        }
        return line;
    }

    static int getSpread(String[] fields, int field1, int field2, String scrubChar) {
        int field1Value = Integer.parseInt(fields[field1].replace(scrubChar,""));
        int field2Value = Integer.parseInt(fields[field2].replace(scrubChar,""));
        return Math.abs(field1Value - field2Value);
    }

    static String findMinSpreadLabel(String resourceFile, int field1, int field2, int labelField, String skipString, String scrubChar) {
        BufferedReader input = CommonUtils.getResourceAsBufferedReader(resourceFile);

        CommonUtils.readNextLine(input, skipString); // skip the header

        int minSpread = -1;
        String minSpreadLabel = "";

        String dataLine = CommonUtils.readNextLine(input, skipString);
        while (dataLine != null) {
            String[] fields = dataLine.split("\\s+");
            int curSpread = CommonUtils.getSpread(fields, field1, field2, scrubChar);
            if (minSpread == -1 || curSpread < minSpread) {
                minSpread = curSpread;
                minSpreadLabel = fields[labelField];
            }
            dataLine = CommonUtils.readNextLine(input, skipString);
        }

        return minSpreadLabel;
    }

}
