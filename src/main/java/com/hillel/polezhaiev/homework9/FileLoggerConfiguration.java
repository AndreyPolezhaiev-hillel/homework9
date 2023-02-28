package com.hillel.polezhaiev.homework9;

import java.io.*;

public class FileLoggerConfiguration {
    private File file = new File("text.txt");
    private String path = file.getAbsolutePath();
    private long sizeOfFile = file.length();
    private final int limitSizeOfFile = 120;
    private String extension;
    private String level;
    public FileLoggerConfiguration() {
    }

    public FileLoggerConfiguration(String path, long sizeOfFile, String extension, String level) {
        this.path = path;
        this.sizeOfFile = sizeOfFile;
        this.extension = extension;
        this.level = level;
    }

    public String getPath() {
        return path;
    }

    public File getFile() {
        return file;
    }

    public long getSizeOfFile() {
        return sizeOfFile;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSizeOfFile(long sizeOfFile) {
        this.sizeOfFile = sizeOfFile;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "FileLoggerConfiguration{" +
                "path='" + path + '\'' +
                ", sizeOfFile=" + sizeOfFile +
                ", extension='" + extension + '\'' +
                ", level='" + level + '\'' +
                '}';
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getLimitSizeOfFile() {
        return limitSizeOfFile;
    }

    public String getExtension() {
        return extension;
    }

    public String getLevel() {
        return level;
    }
}
