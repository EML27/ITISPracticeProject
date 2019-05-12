package database.modelsDB;

import database.IConfigFileDB;
import database.IConfigSetDB;

import java.util.List;

/**
 * General config
 */
public class ConfigSetDB implements IConfigSetDB {

    private String name;
    private List<IConfigFileDB> ConfigFiles;

    /**
     * @param name        config's name
     * @param configFiles list of all files which are contained to this config
     */
    public ConfigSetDB(String name, List<IConfigFileDB> configFiles) {
        this.name = name;
        ConfigFiles = configFiles;
    }

    @Override
    public String getConfigName() {
        return name;
    }

    @Override
    public List<IConfigFileDB> getConfigFiles() {
        return ConfigFiles;
    }

    @Override
    public String toString() {
        return "ConfigSetDB{" +
                "name='" + name + '\'' +
                ", ConfigFiles=" + ConfigFiles +
                '}';
    }
}