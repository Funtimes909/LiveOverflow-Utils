package xyz.funtimes909.liveoverflow_utils.util;

public class CoordinateRounder {

    public static double roundedDown(double num) {
        double temp = (double) (Math.round(num*100))/100;
        return Math.nextAfter(temp, temp + Math.signum(num));
    }
}
