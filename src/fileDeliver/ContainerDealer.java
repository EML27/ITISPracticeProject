package fileDeliver;

import java.io.File;
import java.util.LinkedList;

public class ContainerDealer {
    private static final String PATH_CONTAINER = "./support";
    private static final String CONFIG_ROOT = "./configs";

    public static void main(String[] args) {
        initiate();
    }

    public static void initiate(){
        initiate(PATH_CONTAINER);
    }

    private static void initiate(String pathContainer){
        File []supportDir = new File(pathContainer).listFiles(); //все найденные поддерживаемые программы на компудахтере
        File configs = new File(CONFIG_ROOT);

        configs.mkdir(); //создаем директорию, в которую будем складывать конфиги

        LinkedList<File> savedProgs = new LinkedList<>();

        for (int i = 0; i < supportDir.length; i++) { //создаем новые папки для программ, содержащие в себе сохраненные конфиги программ
            File tmp = new File(CONFIG_ROOT +"/"+ supportDir[i].getName().substring(0, supportDir[i].getName().indexOf('.')));
            savedProgs.add(tmp);
            tmp.mkdir();
        }

    }

    public static File add(File program, String configName){
        File toReturn = new File(program.getAbsolutePath() + "/" + configName);
        toReturn.mkdirs();
        return toReturn;
    }

}
