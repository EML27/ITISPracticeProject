package fileDeliver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException {
        ContainerDealer.initiate();
        File conf = ContainerDealer.add(new File("./configs/telegram-desktop"), "conf1");
        CopyMaker.makeCopy(conf, new File("./support/telegram-desktop.txt"));
    }


}
