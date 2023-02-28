package com.hillel.polezhaiev;

import com.hillel.polezhaiev.homework9.FileLogger;
import com.hillel.polezhaiev.homework9.FileLoggerConfiguration;
import com.hillel.polezhaiev.homework9.FileLoggerConfigurationLoader;
import com.hillel.polezhaiev.homework9.FileMaxSizeReachedException;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileMaxSizeReachedException, IOException {

        FileLoggerConfigurationLoader fLCL = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration fLConfiguration = new FileLoggerConfiguration();
        FileLogger fileLogger = new FileLogger(fLConfiguration);

        fileLogger.debug("The 20th (twentieth) century began on January 1, 1901 (MCMI), on December 31, 2000.");

        System.out.println();
        fLConfiguration = fLCL.load(fLConfiguration.getFile());


    }
}
