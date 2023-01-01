/**
 * System.arraycopy cases
 */
public class Main {

    public static void main(String args[]) {
        String[] stringArray = new String[8];
        Object[] objectArray = new Object[8];
        for (int i = 0; i < stringArray.length; i++) stringArray[i] = new String(Integer.toString(i));
        System.out.println("string -> object");
        System.arraycopy(stringArray, 0, objectArray, 0, stringArray.length);
        System.out.println("object -> string");
        System.arraycopy(objectArray, 0, stringArray, 0, stringArray.length);
        System.out.println("object -> string (modified)");
        objectArray[4] = new ImplA();
        try {
            System.arraycopy(objectArray, 0, stringArray, 0, stringArray.length);
        } catch (ArrayStoreException ase) {
            System.out.println("caught ArrayStoreException (expected)");
        }
    }
}
