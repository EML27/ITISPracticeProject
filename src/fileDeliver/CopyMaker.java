package fileDeliver;

import fileDeliver.config_get.GetRealisationOf_NeededFiles;
import frontend.lib.IllegalArgumentAlert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class CopyMaker {
    private static final String PATH_CONTAINER ="./support";
    private static final String CONFIG_ROOT= "./configs";
    public static void makeCopy(File config, File pathList){
        try {
            Scanner reader = new Scanner(pathList);
            config.mkdir();
            File tmp = new File(config.getAbsolutePath() + "/realNames.txt");
            tmp.createNewFile();
            FileWriter rec = new FileWriter(config.getAbsolutePath() + "/" + "realNames.txt");
            for (int i = 0; reader.hasNext(); i++) {
                tmp = new File(config.getAbsolutePath() + "/" + i);
                tmp.mkdir();
                String realName = reader.nextLine();
                rec.write(i + " ");
                copy(new File(realName), tmp, rec);
            }
            rec.close();
        } catch (IOException e) {
            throw new IllegalArgumentAlert(e);
        }

    }
    public static void copyUtil(File toCopy, File dest) throws IOException {
        Files.copy(toCopy.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copy(File source, File dest, FileWriter rec) throws IOException {
        File [] sf;
        if(GetRealisationOf_NeededFiles.get(source) == null)
            return;

        String []tmp = GetRealisationOf_NeededFiles.get(source).getFilePaths(source);

        /*LinkedList<File> cf = new LinkedList<>();
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
        }*/

        sf = new File[tmp.length];
        for (int i = 0; i <tmp.length; i++) {
            sf[i] = new File(tmp[i]);
        }

        for (int i = 0; i < tmp.length; i++) {
            copyUtil(sf[i], dest);
            rec.write(tmp[i] +  "\n");
        }

        rec.flush();
    }
}

