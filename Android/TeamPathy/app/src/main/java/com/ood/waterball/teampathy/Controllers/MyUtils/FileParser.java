package com.ood.waterball.teampathy.Controllers.MyUtils;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileParser {
    public static String readInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        while ((len = inputStream.read(buf)) != -1) {
            outputStream.write(buf, 0, len);
        }
        outputStream.close();
        inputStream.close();

        return outputStream.toString();
    }
}
