import ignore_parameter.*;

public class ignore_parameter_runme {

    static {
        try {
            System.loadLibrary("ignore_parameter");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Native code library failed to load. See the chapter on Dynamic Linking Problems in the SWIG Java documentation for help.\n" + e);
            System.exit(1);
        }
    }

    public static void main(String argv[]) {
        if (!ignore_parameter.jaguar(200, 0.0).equals("hello")) {
            System.err.println("Runtime Error in jaguar()");
        }
        if (ignore_parameter.lotus("fast", 0.0) != 101) {
            System.err.println("Runtime Error in lotus()");
        }
        if (ignore_parameter.tvr("fast", 200) != 8.8) {
            System.err.println("Runtime Error in tvr()");
        }
        if (ignore_parameter.ferrari() != 101) {
            System.err.println("Runtime Error in ferrari()");
        }
        SportsCars sc = new SportsCars();
        if (!sc.daimler(200, 0.0).equals("hello")) {
            System.err.println("Runtime Error in daimler()");
        }
        if (sc.astonmartin("fast", 0.0) != 101) {
            System.err.println("Runtime Error in astonmartin()");
        }
        if (sc.bugatti("fast", 200) != 8.8) {
            System.err.println("Runtime Error in bugatti()");
        }
        if (sc.lamborghini() != 101) {
            System.err.println("Runtime Error in lamborghini()");
        }
        MiniCooper mc = new MiniCooper(200, 0.0);
        MorrisMinor mm = new MorrisMinor("slow", 0.0);
        FordAnglia fa = new FordAnglia("slow", 200);
        AustinAllegro aa = new AustinAllegro();
    }
}
