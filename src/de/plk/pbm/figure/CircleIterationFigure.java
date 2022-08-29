package de.plk.pbm.figure;

public class CircleIterationFigure implements FigureInterface {
    @Override
    public int getCanvasWidth() {
        return 512;
    }

    @Override
    public int getCanvasHeight() {
        return 512;
    }

    @Override
    public int[][] build() {
        int[][] pixels = new int[512][512];

        int half = 512 / 2;
        for (int point = 0; point < 100 / 3; point++) {
            double angle = 2 * Math.PI * point / (100 / 3);
            int sinX = (int) Math.round(half + 20 * Math.cos(angle));
            int sinY = (int) Math.round(half + 20 * Math.sin(angle));

            pixels[sinX][sinY] = 1;
        }

        return pixels;
    }

    @Override
    public String label() {
        return "CircleFigure";
    }
}
