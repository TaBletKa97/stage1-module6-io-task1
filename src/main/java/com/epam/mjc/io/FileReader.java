package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        final int NAME_INDEX = 0;
        final int AGE_INDEX = 1;
        final int EMAIL_INDEX = 2;
        final int PHONE_INDEX = 3;
        final int PARAMETER_COUNT = 4;
        final String NEW_LINE = "\n";
        final String SPACE = " ";

        String name = "";
        int age = 0;
        String email = "";
        long phone = 0;

        try (FileInputStream inputStream = new FileInputStream(file)) {
            String fileData = new String(inputStream.readAllBytes());
            String[] lines = fileData.split(NEW_LINE);
            for (int i = 0; i < PARAMETER_COUNT; i++) {
                lines[i] = lines[i].trim().split(SPACE)[AGE_INDEX];
            }
            name = lines[NAME_INDEX];
            age = Integer.parseInt(lines[AGE_INDEX]);
            email = lines[EMAIL_INDEX];
            phone = Long.parseLong(lines[PHONE_INDEX]);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new Profile(name, age, email, phone);
    }
}


