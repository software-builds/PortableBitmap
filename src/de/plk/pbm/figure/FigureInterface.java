package de.plk.pbm.figure;

import java.io.IOException;

public interface FigureInterface {

    int getCanvasWidth();

    int getCanvasHeight();

    int[][] build() throws IOException;

    String label();

}
