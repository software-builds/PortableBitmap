package de.plk.pbm.figure;

public class ChessFigure implements FigureInterface {

    private final int canvasWidth;
    private final int canvasHeight;

    private final int stroke;

    public ChessFigure(int canvasWidth, int canvasHeight, int stroke) {
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.stroke = stroke;
    }

    @Override
    public int getCanvasWidth() {
        return this.canvasWidth;
    }

    @Override
    public int getCanvasHeight() {
        return this.canvasHeight;
    }

    public int getStroke() {
        return stroke;
    }

    @Override
    public int[][] build() {
        int[][] pixels = new int[canvasWidth][canvasHeight];

        boolean reverse = false;
        for (int x = 0; x < canvasWidth; x++) {
            for (int y = 0; y < canvasHeight; y++) {
                boolean black = (y / stroke) % 2 == 0;

                if (reverse)
                    black = !black;

                pixels[x][y] = black ? 1 : 0;
            }

            if (x % stroke == 0)
                reverse = !reverse;
        }

        return pixels;
    }

    @Override
    public String label() {
        return "chess";
    }
}
