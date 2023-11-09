import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;

import java.awt.geom.Point2D;

public class AngleTest {


    public static double calculateAngle(Point2D.Double pointA, Point2D.Double pointB, Point2D.Double pointC) {
        // Calculate the vectors AB and BC
        Point2D.Double vectorAB = new Point2D.Double(pointB.x - pointA.x, pointB.y - pointA.y);
        Point2D.Double vectorBC = new Point2D.Double(pointC.x - pointB.x, pointC.y - pointB.y);

        // Calculate the dot product of AB and BC
        double dotProduct = vectorAB.x * vectorBC.x + vectorAB.y * vectorBC.y;

        // Calculate the magnitudes of AB and BC
        double magnitudeAB = Math.sqrt(vectorAB.x * vectorAB.x + vectorAB.y * vectorAB.y);
        double magnitudeBC = Math.sqrt(vectorBC.x * vectorBC.x + vectorBC.y * vectorBC.y);

        // Calculate the cosine of the angle
        double cosine = dotProduct / (magnitudeAB * magnitudeBC);

        // Calculate the angle in radians
        double angleRad = Math.acos(cosine);

        // Convert the angle to degrees
        double angleDeg = Math.toDegrees(angleRad);

        return angleDeg;
    }

    public static void main(String[] args) {
        // Example usage
        Point2D.Double pointA = new Point2D.Double(0, 0);
        Point2D.Double pointB = new Point2D.Double(1, 0);
        Point2D.Double pointC = new Point2D.Double(1, 1);


        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            double angle = calculateAngle(pointA, pointB, pointC);
          //  System.out.println("向量计算角度: " + angle);
        }
        System.out.println("耗时:" + DateUtil.formatBetween(System.currentTimeMillis() - start));

        // Example usage
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            double lengthAB = calculateDistance(pointA, pointB);
            double lengthBC = calculateDistance(pointB, pointC);
            double lengthCA = calculateDistance(pointC, pointA);
           // System.out.println("边长计算角度:" + calculateAngle(lengthAB, lengthBC, lengthCA));
        }
        System.out.println("耗时:" + DateUtil.formatBetween(System.currentTimeMillis() - start2));
    }

    public static double calculateDistance(Point2D.Double pointA, Point2D.Double pointB) {
        double dx = pointB.x - pointA.x;
        double dy = pointB.y - pointA.y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance;
    }

    public static double calculateAngle(double a, double b, double c) {
        // Calculate the cosines of the angles
       // double cosA = (b * b + c * c - a * a) / (2 * b * c);
       // double cosB = (a * a + c * c - b * b) / (2 * a * c);
        double cosC = (a * a + b * b - c * c) / (2 * a * b);

        // Calculate the angles in radians
        //double angleB = Math.acos(cosB);
        double angleC = Math.acos(cosC);

        // Convert the angles to degrees
       // double angleADeg = Math.toDegrees(angleA);
        //double angleBDeg = Math.toDegrees(angleB);
        return Math.toDegrees(angleC);
    }
}
