package de.plk.pbm;

import de.plk.pbm.figure.FigureInterface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class AbstractBitmap<F extends FigureInterface> {

    private final F figure;

    public AbstractBitmap(F figure) {
        this.figure = figure;
    }

    public void save() throws IOException {
        PrintStream printStream = new PrintStream(figure.label() + ".pbm");

        printStream.println("P1");
        printStream.println(figure.getCanvasWidth() + " " + figure.getCanvasHeight());

        int[][] pixels = figure.build();
        for (int[] pixel : pixels) {
            for (int y = 0; y < pixels.length; y++) {
                printStream.print(pixel[y]);
            }

            printStream.println();
        }

        printStream.close();
    }

}
