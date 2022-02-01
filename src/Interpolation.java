import java.util.Arrays;
import java.util.Comparator;

public class Interpolation {
    private Point[] points;

    public Interpolation(Point[] points) {
        this.points = points;
        Arrays.sort(this.points, Comparator.comparingDouble(a -> a.x));
    }

    public double interpolate(double xInput) {
        int i = 0;
        Point[] pointsOfInterest = new Point[2];
        while(true) {

            if(i < this.points.length) {
                if(xInput < this.points[i].x) {
                    if(i == 0) {
                        pointsOfInterest[0] = this.points[0];
                        pointsOfInterest[1] = this.points[1];
                    }
                    else {
                        pointsOfInterest[0] = this.points[i - 1];
                        pointsOfInterest[1] = this.points[i];
                    }
                    break;
                }
            }
            else {
                pointsOfInterest[0] = this.points[this.points.length - 2];
                pointsOfInterest[1] = this.points[this.points.length - 1];
                break;
            }
            i++;
        }

        if(xInput == pointsOfInterest[0].x) {
            return pointsOfInterest[0].y;
        }

        // y - y1 = m(x - x1)
        // m = (y - y1) / (x - x1)
        double m = (pointsOfInterest[0].y - pointsOfInterest[1].y) / (pointsOfInterest[0].x - pointsOfInterest[1].x);

        // y = mx + b
        // b = y - mx
        double b = pointsOfInterest[0].y - m * pointsOfInterest[0].x;

        return m * xInput + b;
    }
    
}
