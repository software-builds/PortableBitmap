package de.plk.pbm;

import de.plk.pbm.figure.ChessFigure;
import de.plk.pbm.figure.CircleFigure;
import de.plk.pbm.figure.CircleIterationFigure;
import de.plk.pbm.figure.ImageTestFigure;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        AbstractBitmap<ImageTestFigure> imageTestFigureAbstractBitmap = new AbstractBitmap<>(
                new ImageTestFigure()
        );

        imageTestFigureAbstractBitmap.save();

    }

}
