public class vectorData {

    private long swigCPtr;

    protected boolean swigCMemOwn;

    protected vectorData(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    protected static long getCPtr(vectorData obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (swigCPtr != 0 && swigCMemOwn) {
            swigCMemOwn = false;
            openbabelJNI.delete_vectorData(swigCPtr);
        }
        swigCPtr = 0;
    }

    public vectorData() {
        this(openbabelJNI.new_vectorData__SWIG_0(), true);
    }

    public vectorData(long n) {
        this(openbabelJNI.new_vectorData__SWIG_1(n), true);
    }

    public long size() {
        return openbabelJNI.vectorData_size(swigCPtr, this);
    }

    public long capacity() {
        return openbabelJNI.vectorData_capacity(swigCPtr, this);
    }

    public void reserve(long n) {
        openbabelJNI.vectorData_reserve(swigCPtr, this, n);
    }

    public boolean isEmpty() {
        return openbabelJNI.vectorData_isEmpty(swigCPtr, this);
    }

    public void clear() {
        openbabelJNI.vectorData_clear(swigCPtr, this);
    }

    public void add(OBGenericData x) {
        openbabelJNI.vectorData_add(swigCPtr, this, OBGenericData.getCPtr(x));
    }

    public OBGenericData get(int i) {
        long cPtr = openbabelJNI.vectorData_get(swigCPtr, this, i);
        return (cPtr == 0) ? null : new OBGenericData(cPtr, false);
    }

    public void set(int i, OBGenericData x) {
        openbabelJNI.vectorData_set(swigCPtr, this, i, OBGenericData.getCPtr(x));
    }
}
