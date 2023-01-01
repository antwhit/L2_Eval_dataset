class ExceptionTest3 {

    static int[] testa = null;

    public static void main(String[] args) {
        run();
    }

    public static boolean run() {
        try {
            testa[4] = 0;
        } catch (IndexOutOfBoundsException e5) {
            System.out.println(" IndexOutOfBoundsException caught");
        } catch (NullPointerException e) {
            System.out.println(" NullPointerException");
        }
        System.out.println(" At End");
        return true;
    }
}
