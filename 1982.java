public class T20020604 {

    static double d2 = 0.0;

    static Object lockObject = new Object();

    public static double f(double d1) {
        synchronized (lockObject) {
            d2 = Math.max(d1, d2);
        }
        return d2;
    }
}
