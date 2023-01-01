public class OBExternalBondData extends OBGenericData {

    private long swigCPtr;

    protected OBExternalBondData(long cPtr, boolean cMemoryOwn) {
        super(openbabelJNI.SWIGOBExternalBondDataUpcast(cPtr), cMemoryOwn);
        swigCPtr = cPtr;
    }

    protected static long getCPtr(OBExternalBondData obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (swigCPtr != 0 && swigCMemOwn) {
            swigCMemOwn = false;
            openbabelJNI.delete_OBExternalBondData(swigCPtr);
        }
        swigCPtr = 0;
        super.delete();
    }

    public OBExternalBondData() {
        this(openbabelJNI.new_OBExternalBondData(), true);
    }

    public OBGenericData Clone(OBBase arg0) {
        long cPtr = openbabelJNI.OBExternalBondData_Clone(swigCPtr, this, OBBase.getCPtr(arg0), arg0);
        return (cPtr == 0) ? null : new OBGenericData(cPtr, false);
    }

    public void SetData(OBAtom arg0, OBBond arg1, int arg2) {
        openbabelJNI.OBExternalBondData_SetData(swigCPtr, this, OBAtom.getCPtr(arg0), arg0, OBBond.getCPtr(arg1), arg1, arg2);
    }

    public SWIGTYPE_p_std__vectorTOpenBabel__OBExternalBond_t GetData() {
        long cPtr = openbabelJNI.OBExternalBondData_GetData(swigCPtr, this);
        return (cPtr == 0) ? null : new SWIGTYPE_p_std__vectorTOpenBabel__OBExternalBond_t(cPtr, false);
    }
}
