package it.unicam.cs.pa.cardgamemanager109172.Model;

import java.io.*;

public class ConfigGenerator {

    private final File output;

    public ConfigGenerator(){
        this(null);
    }

    public ConfigGenerator(File output) {
        this.output = output;
    }

    public void generateConfig(Object toSave){
        FileOutputStream fileOutputStream;
        ObjectOutputStream outputStream;
        try {
            fileOutputStream = new FileOutputStream(this.output);
            outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(toSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
