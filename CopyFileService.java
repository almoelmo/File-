package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;


public class CopyFileService {
    private final String logFilename = "copyfile.log";

    public void copy(String path, InputStream in, OutputStream out) throws IOException {
        Files.exists(Path.of(path));
        String filenameOut = "copy_" + path;
        byte[] buffer = new byte[65536];
        while (in.available() > 0) {
            int real = in.read(buffer);
            out.write(buffer, 0, real);
        }
        this.logger(new Date(), path, filenameOut);
    }
	

    private void logger(Date date, String pathIn, String pathOut) throws IOException {
        String message = String.format("Date: %s, PathToFile: %s, PathToCopy: %s\n", date.toString(), pathIn, pathOut);
        Path file = Path.of(logFilename);
        if(Files.notExists(file)){
            Files.createFile(file);
        }
        Files.write(file, message.getBytes(), StandardOpenOption.APPEND);
    }
}
