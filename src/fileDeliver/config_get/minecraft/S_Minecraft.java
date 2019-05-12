package fileDeliver.config_get.minecraft;

import fileDeliver.config_get.I_NeededFiles;

import java.io.File;

public class S_Minecraft  implements I_NeededFiles {
    @Override
    public String[] getFilePaths(File root) {
        String [] toReturn = {root.getAbsolutePath() + "/updates/AdvancedEra/options.txt"};
        return toReturn;
    }
}
