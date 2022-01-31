package it.unicam.cs.pa.cardgamemanager109172.Model.Library;

import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Interfaces.DeckInterface;

import java.io.*;

/**
 * This class allows the creation of binary files containing Deck type objects
 */
public class ConfigGenerator<D extends DeckInterface>{

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

    public void generateConfig(D toSave){
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
            readCheck();
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

    private void readCheck() throws IOException {
        assert this.file != null;
        if(!this.file.canRead()) throw new IOException();
    }
}
