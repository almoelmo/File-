package org.example;

import org.example.exceptions.CopyFileNotFoundException;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, CopyFileNotFoundException {
        String path = "pom.xmlx";
        InputStream in = new FileInputStream(path);
        OutputStream out = new FileOutputStream("copy_"+ path);
        CopyFileService copyFileService = new CopyFileService();
        copyFileService.copy(path, in, out);
        in.close();
        out.close();
    }
}