package fileDeliver;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class CopyMaker {
    private static final String PATH_CONTAINER ="./support";
    private static final String CONFIG_ROOT= "./configs";
    public static void makeCopy(File config, File pathList){
        try {
            Scanner reader = new Scanner(pathList);
            File tmp;
            FileWriter rec = new FileWriter(config.getAbsolutePath() + "/" + "realNames.txt");
            for (int i = 0; reader.hasNext(); i++) {

                tmp = new File(config.getAbsolutePath() + "/" + i);
                tmp.mkdir();
                String realName = reader.nextLine();
                copy(new File(realName), tmp);
                rec.write(i+ " "+ realName + "\n");

            }
            rec.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(); //TODO добавить что делать при отсутствии нужного файла
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static void copyUtil(File toCopy, File dest) throws IOException {
        Files.copy(toCopy.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copy(File source, File dest) throws IOException {
        File [] sf = source.listFiles();
        LinkedList<File> cf = new LinkedList<>();
        File toAdd;
        if(sf == null)
            return;
        for (int i = 0; i < sf.length; i++) {
            cf.add(toAdd = new File(dest + "/" + sf[i].getName()));
            if(sf[i].isDirectory())
                toAdd.mkdir();
            else
                toAdd.createNewFile();
        }

        Iterator iterator = cf.iterator();

        for (int i = 0; i < sf.length; i++) {
            if(sf[i].isDirectory()){
                //System.out.println(sf[i].getName());
                copy(sf[i], (File) iterator.next());
            }
            else
                iterator.next();
        }
    }
}

