package de.plk.pbm.figure;

public class CircleFigure implements FigureInterface {

    private final int canvasWidth;
    private final int canvasHeight;

    private final int radius;

    public CircleFigure(int canvasWidth, int canvasHeight, int radius) {
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.radius = radius;
    }

    @Override
    public int getCanvasWidth() {
        return this.canvasWidth;
    }

    @Override
    public int getCanvasHeight() {
        return this.canvasHeight;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public int[][] build() {
        int[][] pixels = new int[canvasWidth][canvasHeight];

        int centerX = canvasWidth / 2;
        int centerY = canvasHeight / 2;

        boolean reverse = false;
        int stroke = 30;
        for (int x = 0; x < canvasWidth; x++) {
            for (int y = 0; y < canvasHeight; y++) {
                int dx = centerX - x;
                int dy = centerY - y;

                double floating = Math.sqrt(dx * dx + dy * dy);

                if (floating < radius) {
                    pixels[x][y] = 1;

                    if (floating < radius - 2) {
                        boolean black = (y / stroke) % 2 == 0;

                        if (reverse)
                            black = !black;

                        pixels[x][y] = black ? 1 : 0;
                    }
                } else {
                        boolean black = (y / stroke) % 2 != 0;

                        if (reverse)
                            black = !black;

                        pixels[x][y] = black ? 1 : 0;
                }
            }

            if (x % stroke == 0)
                reverse = !reverse;
        }

        return pixels;
    }

    @Override
    public String label() {
        return "circle";
    }
}
