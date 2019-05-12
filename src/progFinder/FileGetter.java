package progFinder;

import frontend.lib.IllegalArgumentAlert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class FileGetter extends  Thread{

    LinkedList<String> toRet;

    public FileGetter(LinkedList<String> toRet){
        this.toRet = toRet;
    }

    @Override
    public void run(){
       toRet = getPaths();
    }
    /**
     * 1)создаем список поддерживаемых программ
     * 2)запускаем полный обход по файловой системе в поисках этих программ
     * 3)спрашиваем пользователя, какие из найденых программ он хочет сохранить
     *
     * @param
     * @throws FileNotFoundException
     */
    public static LinkedList<String> getPaths() {
        LinkedList<Prog> supportedProgList = new LinkedList<>();
        LinkedList<String> pathList = new LinkedList<String>();
        LinkedHashSet<String> progNames = new LinkedHashSet<>();
        try {                                                                                        // создаем связный список имен поддерживаемых программ
            supportedProgList = DependMaker.buildDependence(new File("./SupportedPrograms.txt"));
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            throw new IllegalArgumentAlert("File 'SupportPrograms.txt' does not exist!");
        }

        try {
            FileSystemSearch.initiateSearch(supportedProgList, pathList, progNames);                 //начинаем поиск
        } catch (IOException e) {
            throw new IllegalArgumentAlert(e);
        }

        return toArray(progNames);
    }
    private static LinkedList<String> toArray(LinkedHashSet<String> s){
        LinkedList<String> a = new LinkedList<>();
        Iterator<String> i= s.iterator();
        for (int j = 0; i.hasNext(); j++) {
             a.add( i.next());
        }

        return a;
    }

    public LinkedList<String> getReturn() {
        return toRet;
    }

    /*public static void main(String[] args) {
        String[] s = getPathsArray();
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }*/
}

