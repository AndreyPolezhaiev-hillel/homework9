package com.hillel.polezhaiev.homework9;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger {

    private FileLoggerConfiguration fLConfig;

    public FileLogger(FileLoggerConfiguration fileLoggerConfiguration) {
        this.fLConfig = fileLoggerConfiguration;
    }

    public void debug(String message){
        {
            try (Writer writer = new FileWriter(fLConfig.getFile())){
                BufferedWriter bw = new BufferedWriter(writer);

                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                String time = dateFormat.format(new Date());

                String received = "[" + time + "]"
                        + LoggingLevel.DEBUG.getLevel()
                        + " Message: " + message + "\n";

                bw.write(received);
                bw.flush();

                if(checkFileLength(fLConfig.getFile())){
                    System.out.println("Message \"" + message + "\" successfully received!!!");

                }


            } catch (IOException | FileMaxSizeReachedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void info(String message){
        {
            try (Writer writer = new FileWriter(fLConfig.getFile())){
                BufferedWriter bw = new BufferedWriter(writer);

                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                String time = dateFormat.format(new Date());

                String received = "[" + time + "]"
                        + LoggingLevel.INFO.getLevel()
                        + " Message: " + message + "\n";

                bw.write(received);
                bw.flush();

                if(checkFileLength(fLConfig.getFile())){
                    System.out.println("Message " + message + " successfully received!!!");

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (FileMaxSizeReachedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean checkFileLength(File file) throws FileMaxSizeReachedException {

        if(fLConfig.getLimitSizeOfFile() <= fLConfig.getSizeOfFile()){
            throw new FileMaxSizeReachedException(
                    "\n\n========================FileMaxSizeReachedException=========================="
                            + "\nFile size is " + fLConfig.getLimitSizeOfFile() + " bytes\n"
                            + "your message is " + fLConfig.getSizeOfFile() + " bytes\n"
                            + "File path: " + fLConfig.getPath() + "\n"
                            + "========================FileMaxSizeReachedException==========================\n\n");
        }
        return true;
    }
}
