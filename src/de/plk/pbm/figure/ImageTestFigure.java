package de.plk.pbm.figure;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ImageTestFigure implements FigureInterface {
    @Override
    public int getCanvasWidth() {
        return 100;
    }

    @Override
    public int getCanvasHeight() {
        return 100;
    }

    @Override
    public int[][] build() {
        int[][] pixels = new int[100][100];

        BufferedImage image = null;
        try {
            image = ImageIO.read(Objects.requireNonNull(ImageTestFigure.class.getResource("100x100.jpg")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                if (image.getRGB(y, x) <= Color.GRAY.getRGB())
                    pixels[x][y] = 1;
            }
        }

        return pixels;
    }

    @Override
    public String label() {
        return "ImageTest2";
    }
}
