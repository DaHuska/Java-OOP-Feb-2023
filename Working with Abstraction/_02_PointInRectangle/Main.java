package com.company._02_PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] bottomLeftAndTopRightCoords = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Point bottomLeftPoint = createPoint(bottomLeftAndTopRightCoords[0], bottomLeftAndTopRightCoords[1]);
        Point topRightPoint = createPoint(bottomLeftAndTopRightCoords[2], bottomLeftAndTopRightCoords[3]);

        Rectangle rectangle = new Rectangle(bottomLeftPoint, topRightPoint);

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            int[] pointCoords = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            Point point = createPoint(pointCoords[0], pointCoords[1]);

            if (isValid(point, rectangle)) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }
    }

    public static boolean isValid(Point point, Rectangle rectangle) {
        boolean isXValid = point.getX() >= rectangle.getBottomLeftPoint().getX() && point.getX() <= rectangle.getTopRightPoint().getX();
        boolean isYValid = point.getY() >= rectangle.getBottomLeftPoint().getY() && point.getY() <= rectangle.getTopRightPoint().getY();

        return isXValid && isYValid;
    }

    public static Point createPoint(int x, int y) {
        return new Point(x, y);
    }
}