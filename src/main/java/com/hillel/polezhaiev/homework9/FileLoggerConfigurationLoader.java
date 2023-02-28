package com.hillel.polezhaiev.homework9;

import java.io.*;

public class FileLoggerConfigurationLoader {

    private FileLoggerConfiguration fLC;

    public FileLoggerConfiguration load(File file){

            fLC = new FileLoggerConfiguration();
            String extension = getFileExtension(file.getName());
            String path = file.getAbsolutePath();
            String level = getLevel(file);
            long sizeOfFile = file.length();

            fLC.setExtension(extension);
            fLC.setLevel(level);
            fLC.setPath(path);
            fLC.setSizeOfFile(sizeOfFile);

            return fLC;
    }
    private String getFileExtension(String name){

        if(name.length() < 0){
            return null;
        }

        return name.substring(name.lastIndexOf('.') + 1);
    }

    private String getLevel(File file) {

        if(file.length() < 0){
            return null;
        }

        try (Reader reader = new FileReader(file)){

            BufferedReader br = new BufferedReader(reader);
            StringBuilder builder = new StringBuilder();
            br.lines().forEach(line -> builder.append(line));
            String result = builder.toString();

            if(result.contains(LoggingLevel.INFO.getLevel())){
                return LoggingLevel.INFO.getLevel();

            } else if(result.contains(LoggingLevel.DEBUG.getLevel())){
                return LoggingLevel.DEBUG.getLevel();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "There isn't level";

    }
}
