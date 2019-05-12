package handler;

import database.IConfigFileDB;
import database.modelsDB.ConfigFileDB;
import database.modelsDB.ConfigSetDB;
import database.modelsDB.ProgramDB;
import database.repositories.DataBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilesToDBHandler {

    private static FilesToDBHandler filesToDBHandler;

    public static FilesToDBHandler getInstance() {
        if (filesToDBHandler == null) {
            filesToDBHandler = new FilesToDBHandler();
        }
        return filesToDBHandler;
    }

    public void convert(List<File> List) throws FileNotFoundException, SQLException {
        List<IConfigFileDB> ConfigFiles = new ArrayList<>();
        for (File file: List) {
            Scanner scanner = new Scanner(file);
            String programName = scanner.nextLine().substring(2);
            String programVersion = scanner.nextLine().substring(2);
            String configName = scanner.nextLine().substring(2);
            ProgramDB programDB = new ProgramDB(programName, programVersion);
            ConfigSetDB configSetDB = new ConfigSetDB(configName , ConfigFiles);
            while (scanner.hasNext("#")) {
                String pathProgram = "./configs/" + programName + "/" + programVersion + "/" + configName;
                String pathBackup = scanner.nextLine().substring(2);
                ConfigFileDB configFileDB = new ConfigFileDB(configName, pathProgram, pathBackup);
                ConfigFiles.add(configFileDB);
            }
            //===================== inserted by Emil
            DataBase.getInstance().save(programDB, configSetDB);
        }
    }
}