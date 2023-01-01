class t3GT3Worker extends Thread {

    int reps, length;

    boolean isReady = false;

    boolean isFinished = false;

    Object syncher;

    t3GT3Worker(int reps, int length, Object o) {
        this.reps = reps;
        this.length = length;
        syncher = o;
    }

    public void start() {
        super.start();
    }

    public void run() {
        isReady = true;
        synchronized (syncher) {
            try {
                syncher.wait();
            } catch (InterruptedException e) {
            }
        }
        allocate(reps, length);
        isFinished = true;
        synchronized (t3GT3.syncher2) {
            t3GT3.syncher2.notify();
        }
    }

    public static void allocate(int reps, int length) {
        for (int i = 0; i < reps; i++) {
            char buf[] = new char[0];
            for (int j = 0; j < length; j++) {
                char newbuf[] = new char[buf.length + 1];
                System.arraycopy(buf, 0, newbuf, 0, buf.length);
                newbuf[buf.length] = 'x';
                buf = newbuf;
            }
        }
    }
}
