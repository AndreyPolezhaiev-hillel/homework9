package com.hillel.polezhaiev.homework9;

public enum LoggingLevel {
    INFO("[INFO]"),
    DEBUG("[DEBUG]");

    private String level;
    LoggingLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
