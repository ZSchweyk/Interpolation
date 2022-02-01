public class Runner {
    public static void main(String[] args) {
        Point[] points = {
                new Point(0, 0),
                new Point(1, 1),
                new Point(2, 4),
                new Point(3, 9),
                new Point(4, 16),
                new Point(5, 25)
        };

        Interpolation InterpolationObject = new Interpolation(points);

        for(double i = 0; i < 7; i += .5) {
            System.out.println(i + ": " + InterpolationObject.interpolate(i));
        }

    }
}
