package progFinder.insideChek.searchRealisation.minecraft;

import progFinder.insideChek.searchRealisation.I_TypeOfSearch;

import java.io.File;
import java.util.LinkedList;

public class MgeWorld implements I_TypeOfSearch {

    @Override
    public boolean search(LinkedList<String> pathsList, File directory) {
        pathsList.add(directory.getAbsolutePath());
        return true;
    }
}
