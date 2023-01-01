import java.util.WeakHashMap;

/**
 * Fill up a WeakHashSet with linked list elements.  Kill off every second element
 * and add new elements to the list.  Rinse and repeat.
 */
public class ReferenceStress {

    static boolean verbose = false;

    static int elements = 0;

    private static synchronized void report(int completed) {
        elements += completed;
    }

    /**
   * The element type of the hash table - a simple linked list
   */
    private static class Element {

        Element next;

        Element(Element next) {
            this.next = next;
        }

        void deleteNext() {
            if (next != null) next = next.next;
        }

        int length() {
            int result = 1;
            Element cursor = next;
            while (cursor != null) {
                cursor = cursor.next;
                result++;
            }
            return result;
        }
    }

    /**
   * The kernel of the test.  Add elements to the linked list/hash table, while
   * killing off half of them.
   *
   * @param liveSize
   * @param iterations
   */
    private static void thrash(int liveSize, int iterations) {
        WeakHashMap<Element, Integer> map = new WeakHashMap<Element, Integer>();
        Element list = new Element(null);
        Integer serial = Integer.valueOf(0);
        for (int i = 0; i < liveSize; i++) {
            list = new Element(list);
            map.put(list, serial++);
        }
        for (int j = 0; j < iterations; j++) {
            Element cursor = list;
            int inserts = 0;
            while (cursor != null) {
                cursor.deleteNext();
                cursor = cursor.next;
                list = new Element(list);
                map.put(list, serial++);
                inserts++;
            }
            if (verbose) {
                System.out.println("Map size " + map.size() + ", list length " + list.length());
            }
            report(inserts);
        }
    }

    /**
   * Print usage and die
   */
    private static void usage() {
        System.err.println("Usage: ReferenceStress [-verbose] [-threads n] [-size s] [-iterations i] [perf|base]");
        System.exit(1);
    }

    public static void main(String[] args) {
        int liveSize = 5000;
        int iterations = 100;
        int threads = 2;
        for (int i = 0; i < args.length; i++) {
            if (args[i].charAt(0) == '-') {
                if (args[i].equals("-verbose")) {
                    verbose = true;
                } else if (args[i].equals("-threads")) {
                    threads = Integer.valueOf(args[++i]);
                } else if (args[i].equals("-iterations")) {
                    iterations = Integer.valueOf(args[++i]);
                } else if (args[i].equals("-size")) {
                    liveSize = Integer.valueOf(args[++i]);
                } else {
                    System.out.println("Unrecognized switch " + args[i]);
                    usage();
                }
            } else if (args[i].equals("perf") || args[i].equals("base")) {
            } else {
                System.out.println("Unrecognized parameter " + args[i]);
                usage();
            }
        }
        System.out.println("Running " + threads + " threads with " + liveSize + " entries for " + iterations + " iterations");
        Thread[] threadTable = new Thread[threads];
        final int finalLiveSize = liveSize;
        final int finalIterations = iterations;
        for (int i = 0; i < threads; i++) {
            threadTable[i] = new Thread() {

                public void run() {
                    thrash(finalLiveSize, finalIterations);
                }
            };
        }
        long start = System.nanoTime();
        for (int i = 0; i < threads; i++) {
            threadTable[i].start();
        }
        for (int i = 0; i < threads; i++) {
            try {
                threadTable[i].join();
            } catch (InterruptedException e) {
            }
        }
        long time = (System.nanoTime() - start) / 1000000;
        System.out.println(elements + " references inserted in " + time + "ms.");
        System.out.println("Overall: SUCCESS");
    }
}
