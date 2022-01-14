package it.unicam.cs.pa.cardgamemanager109172.Model.Library;

import java.io.*;

/**
 * This class allows the creation of binary files containing GameRules or Deck type objects
 */
public class ConfigGenerator{

    private final File file;

    public ConfigGenerator(){
        this.file = null;
    }

    public ConfigGenerator(File file) {
        this.file = file;
    }

    public ConfigGenerator(String filePath) {
        this.file = new File(filePath);
    }

    public void generateConfig(Object toSave){
        FileOutputStream fileOutputStream;
        ObjectOutputStream outputStream;
        try {
            assert this.file != null;
            fileOutputStream = new FileOutputStream(this.file);
            outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(toSave);
            outputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object loadConfig(){
        FileInputStream fileInputStream;
        ObjectInputStream inputStream;
        Object loaded = null;
        try {
            readControl();
            assert this.file != null;
            fileInputStream = new FileInputStream(this.file);
            inputStream = new ObjectInputStream(fileInputStream);
            loaded = inputStream.readObject();
            inputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return loaded;
    }

    private void readControl() throws IOException {
        assert this.file != null;
        if(!this.file.canRead()) throw new IOException();
    }
}
