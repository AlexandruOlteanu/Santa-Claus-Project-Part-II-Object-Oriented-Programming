package createfiles;

import common.Constants;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class CreateFiles {
    /**
     * Creeaza folderul pricipal "ouput" in cazul in care
     * acesta nu exista. Daca exista, procesul se incheie
     * In continuare, in acest folder sunt create fisierele
     * .json corespunzatoare fiecarui test
     *
     * @throws IOException
     */
    public void work() throws IOException {


        Path path = Paths.get("./output");
        File file = new File("./output");
        if (file.exists()) {
            return;
        }
        Files.createDirectories(path);

        for (int i = 1; i <= Constants.TESTS_NUMBER; ++i) {
            path = Paths.get(Constants.OUTPUT_PATH + i + Constants.FILE_EXTENSION);
            Files.createFile(path);
        }
    }

}
