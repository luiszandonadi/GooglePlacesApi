package places.api;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FindPlacesTest extends TestCase {

    public FindPlacesTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(FindPlacesTest.class);
    }

    public void testShouldFindPlaces() throws IOException {

        PlacesService service = new PlacesService("your key here") {

            @Override
            protected String getJSON(String url) {
                StringBuilder stringBuilder = new StringBuilder(System.getProperty("user.dir"));
                stringBuilder.append(File.separator);
                stringBuilder.append("src");
                stringBuilder.append(File.separator);
                stringBuilder.append("main");
                stringBuilder.append(File.separator);
                stringBuilder.append("resources");
                stringBuilder.append(File.separator);
                stringBuilder.append("places");
                stringBuilder.append(File.separator);
                stringBuilder.append("api");
                stringBuilder.append(File.separator);
                stringBuilder.append("json.txt");
                try {
                    return readFileAsString(stringBuilder.toString());
                } catch (IOException ex) {
                    Logger.getLogger(FindPlacesTest.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }
        };
        List<Place> findPlaces = service.findPlaces(-20.326975, -41.133026666666666);
        assertEquals(21, findPlaces.size());
    }

    private static String readFileAsString(String filePath) throws java.io.IOException {
        byte[] buffer = new byte[(int) new File(filePath).length()];
        BufferedInputStream f = null;
        try {
            f = new BufferedInputStream(new FileInputStream(filePath));
            f.read(buffer);
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException ignored) {
                }
            }
        }
        return new String(buffer);
    }
}
