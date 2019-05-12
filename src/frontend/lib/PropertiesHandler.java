package frontend.lib;

import java.io.*;
import java.util.Properties;

public class PropertiesHandler implements IPropertiesHandler{

    private Properties properties;
    private FileInputStream fis;
    private File confixProperties;
    private static PropertiesHandler ph;

    public static PropertiesHandler getInstance() {
        if(ph == null) {
            ph = new PropertiesHandler(new File(References.CONFIX_SETTINGS_FILE_PATH));
        }
        return ph;
    }

    private PropertiesHandler(File file) {
        try {
            this.fis = new FileInputStream(file);
            this.properties = new Properties();
            this.properties.load(fis);
            this.confixProperties = file;
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentAlert("File " + file + " was not found");
        } catch (IOException e) {
            throw new IllegalArgumentAlert("Unable to load FileInputStream");
        }
    }

    @Override
    public void save(String key, String value) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(confixProperties);
            properties.setProperty(key, value);
            properties.store(fos, null);
            fos.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentAlert("File with name " + References.CONFIX_SETTINGS_FILE_PATH + "was not found");
        } catch (IOException e) {
            throw new IllegalArgumentAlert("Can't store property with " + fos.toString());
        }
    }

    @Override
    public String get(String key) {
        if (properties.containsKey(key)) {
            return properties.getProperty(key);
        } else {
            throw new IllegalArgumentAlert("Property " + key +" was not found");
        }
    }
}
