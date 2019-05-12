package frontend.lib;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.stream.Stream;

public class InitHelper {

    public static LinkedList<String> initProgramsList() {
        LinkedList<String> linkedList = new LinkedList<>();
        try (Stream<Path> paths = Files.walk(Paths.get(References.SUPPORT_DIRECTORY_PATH))) {
            paths.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    try {
                        File file = filePath.toFile();
                        linkedList.add(file.getName().substring(0, file.getName().length() - 4));
                    } catch (Exception e) {
                        throw new IllegalArgumentAlert("Unable to get file name!");
                    }
                }
            });
        } catch (IOException e) {
            throw new IllegalArgumentAlert(e);
        }
        return linkedList;
    }


}
