public class OBRingSearch {

    private long swigCPtr;

    protected boolean swigCMemOwn;

    protected OBRingSearch(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    protected static long getCPtr(OBRingSearch obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (swigCPtr != 0 && swigCMemOwn) {
            swigCMemOwn = false;
            openbabelJNI.delete_OBRingSearch(swigCPtr);
        }
        swigCPtr = 0;
    }

    public OBRingSearch() {
        this(openbabelJNI.new_OBRingSearch(), true);
    }

    public void SortRings() {
        openbabelJNI.OBRingSearch_SortRings(swigCPtr, this);
    }

    public void RemoveRedundant(int arg0) {
        openbabelJNI.OBRingSearch_RemoveRedundant(swigCPtr, this, arg0);
    }

    public void AddRingFromClosure(OBMol arg0, OBBond arg1) {
        openbabelJNI.OBRingSearch_AddRingFromClosure(swigCPtr, this, OBMol.getCPtr(arg0), arg0, OBBond.getCPtr(arg1), arg1);
    }

    public boolean SaveUniqueRing(SWIGTYPE_p_std__dequeTint_t arg0, SWIGTYPE_p_std__dequeTint_t arg1) {
        return openbabelJNI.OBRingSearch_SaveUniqueRing(swigCPtr, this, SWIGTYPE_p_std__dequeTint_t.getCPtr(arg0), SWIGTYPE_p_std__dequeTint_t.getCPtr(arg1));
    }

    public void WriteRings() {
        openbabelJNI.OBRingSearch_WriteRings(swigCPtr, this);
    }

    public SWIGTYPE_p_std__vectorTOpenBabel__OBRing_p_t__iterator BeginRings() {
        return new SWIGTYPE_p_std__vectorTOpenBabel__OBRing_p_t__iterator(openbabelJNI.OBRingSearch_BeginRings(swigCPtr, this), true);
    }

    public SWIGTYPE_p_std__vectorTOpenBabel__OBRing_p_t__iterator EndRings() {
        return new SWIGTYPE_p_std__vectorTOpenBabel__OBRing_p_t__iterator(openbabelJNI.OBRingSearch_EndRings(swigCPtr, this), true);
    }
}
