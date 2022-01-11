package main;

import checker.Checker;
import common.Constants;
import createfiles.CreateFiles;
import database.Input.Input;
import database.Input.InputLoader;
import solution.MainSolution;

import java.io.IOException;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * Acesta reprezinta punctul de plecare in rezolvarea testelor date.
     * In primul rand se creeaza ierarhia de fisiere necesara pentru afisari
     * si apoi se parcurge test cu test si se realizeaza rezolvarea fiecaruia in
     * mod independent. In final este apelata metoda pentru calcului scorului
     * prezenta in Checker.
     *
     * @param args argumentele folosite pentru apelarea metodei
     */
    public static void main(final String[] args) throws IOException {

        CreateFiles createFiles = new CreateFiles();
        createFiles.work();

        for (int i = 1; i <= Constants.TESTS_NUMBER; ++i) {
            InputLoader inputLoader = InputLoader.getInstance();
            inputLoader.init("./tests/test" + i
                    + Constants.FILE_EXTENSION);
            String output = Constants.OUTPUT_PATH + i + Constants.FILE_EXTENSION;
            Input input = inputLoader.readData();
            MainSolution mainSolution = MainSolution.getInstance();
            mainSolution.init(input, output);
            mainSolution.solve();
        }

        Checker.calculateScore();
    }
}
