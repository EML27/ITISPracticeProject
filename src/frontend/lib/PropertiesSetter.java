package frontend.lib;


import java.io.*;

public class PropertiesSetter implements IPropertiesSetter{

    private static PropertiesSetter propertiesSetter;
    private PropertiesHandler handler;
    private File propertiesFile;

    public static PropertiesSetter getInstance() {
        if(propertiesSetter == null) {
            propertiesSetter = new PropertiesSetter();
        }
        return propertiesSetter;
    }

    private PropertiesSetter() {
        this.propertiesFile = new File(References.CONFIX_SETTINGS_FILE_PATH);
        if (!propertiesFile.exists()) {
            try {
                propertiesFile.createNewFile();
            } catch (IOException e) {
                throw new IllegalArgumentAlert("Unable to create properties file");
            }
        }
        this.handler = PropertiesHandler.getInstance();
    }

    public void initialize() {
        if(isPropertiesFileEmpty()) {
            handler.save("first-time", "true");
            handler.save("open-settings", "false");
            handler.save("searching-completed", "false");
            handler.save("options-id", "1");
//        handler.save("first-time", "false");
//        handler.save("first-time", "false");
//        handler.save("first-time", "false");
        }
    }

    private boolean isPropertiesFileEmpty() {
        try {
            InputStream fr = new FileInputStream(propertiesFile);
            int result = fr.read();
            fr.close();
            if(result != -1) return false;
            return true;
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentAlert(e);
        } catch (IOException e) {
            throw new IllegalArgumentAlert(e);
        }
    }
}
