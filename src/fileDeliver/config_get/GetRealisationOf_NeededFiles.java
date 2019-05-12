package fileDeliver.config_get;

import fileDeliver.config_get.minecraft.S_Minecraft;

import java.io.File;

public class GetRealisationOf_NeededFiles {
    public static I_NeededFiles get(File root){
        switch (root.getName()){
            case ".mge-world":
                return new S_Minecraft();
        }
        return null;
    }
}
