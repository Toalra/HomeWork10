import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DownloadZip {
    ClassLoader cl = DownloadZip.class.getClassLoader();
    Gson gson = new Gson();
    @Test
    public void zipDownload() throws Exception {
        try (InputStream stream = cl.getResourceAsStream("HW10.zip");
             ZipInputStream zipFile = new ZipInputStream(stream)) {

            ZipEntry entry;
            while ((entry = zipFile.getNextEntry()) != null) {
                final String name = entry.getName();
                Assertions.assertEquals("HW10/", name);
            }

        }
    }

}
