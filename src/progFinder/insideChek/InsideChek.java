package progFinder.insideChek;

import progFinder.insideChek.searchRealisation.GetSearchRealisation;
import progFinder.insideChek.searchRealisation.I_TypeOfSearch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class InsideChek extends Thread{
    private LinkedList pathList;
    private File initRoot;
    private I_TypeOfSearch searchMethod;
    private LinkedHashSet<String> progNames;
    public InsideChek(){
        pathList = null;
        initRoot = null;
        searchMethod = null;
    }

    public void setPathList(LinkedList pathList, File initRoot, LinkedHashSet<String> progNames){
        this.pathList = pathList;
        this.initRoot = initRoot;
        this.searchMethod = GetSearchRealisation.getSearch(initRoot.getName());
        this.progNames = progNames;
    }

    @Override
    public void run(){
        if(searchMethod.search(pathList, initRoot)) {
            progNames.add(initRoot.getName());
            File file = new File("./support/" + initRoot.getName()+".txt");

            if(!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(initRoot.getAbsolutePath() + "\n");
                bufferedWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }



        }
    }
}