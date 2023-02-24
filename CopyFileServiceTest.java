import org.example.CopyFileService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;



public class CopyFileServiceTest {
    private CopyFileService copyFileService;
    String path;
    private InputStream in;
    private OutputStream out;

    @Before
    public void setUp() throws FileNotFoundException {
        copyFileService = new CopyFileService();
        path = "pom.xml";
        in = new FileInputStream(path);
        out = new FileOutputStream("copy_"+ path);
    }

    @Test
    public void testSuccessCopy() throws IOException {
        copyFileService.copy(path, in, out);
        File copied = new File("copy_"+ path);
        File original = new File(path);
        Assert.assertTrue(copied.exists());
        Assert.assertEquals(Files.readAllLines(original.toPath()), Files.readAllLines(copied.toPath()));
    }

    @After
    public void closeStreams() throws IOException {
        in.close();
        out.close();
    }
}