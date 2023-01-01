public class OBChiralData extends OBGenericData {

    private long swigCPtr;

    protected OBChiralData(long cPtr, boolean cMemoryOwn) {
        super(openbabelJNI.SWIGOBChiralDataUpcast(cPtr), cMemoryOwn);
        swigCPtr = cPtr;
    }

    protected static long getCPtr(OBChiralData obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (swigCPtr != 0 && swigCMemOwn) {
            swigCMemOwn = false;
            openbabelJNI.delete_OBChiralData(swigCPtr);
        }
        swigCPtr = 0;
        super.delete();
    }

    public OBChiralData() {
        this(openbabelJNI.new_OBChiralData__SWIG_0(), true);
    }

    public OBChiralData(OBChiralData src) {
        this(openbabelJNI.new_OBChiralData__SWIG_1(OBChiralData.getCPtr(src), src), true);
    }

    public OBGenericData Clone(OBBase arg0) {
        long cPtr = openbabelJNI.OBChiralData_Clone(swigCPtr, this, OBBase.getCPtr(arg0), arg0);
        return (cPtr == 0) ? null : new OBGenericData(cPtr, false);
    }

    public void Clear() {
        openbabelJNI.OBChiralData_Clear(swigCPtr, this);
    }

    public vectorUnsignedInt GetAtom4Refs(atomreftype t) {
        return new vectorUnsignedInt(openbabelJNI.OBChiralData_GetAtom4Refs(swigCPtr, this, t.swigValue()), true);
    }

    public long GetAtomRef(int a, atomreftype t) {
        return openbabelJNI.OBChiralData_GetAtomRef(swigCPtr, this, a, t.swigValue());
    }

    public boolean SetAtom4Refs(vectorUnsignedInt atom4refs, atomreftype t) {
        return openbabelJNI.OBChiralData_SetAtom4Refs(swigCPtr, this, vectorUnsignedInt.getCPtr(atom4refs), atom4refs, t.swigValue());
    }

    public int AddAtomRef(long atomref, atomreftype t) {
        return openbabelJNI.OBChiralData_AddAtomRef(swigCPtr, this, atomref, t.swigValue());
    }

    public long GetSize(atomreftype t) {
        return openbabelJNI.OBChiralData_GetSize(swigCPtr, this, t.swigValue());
    }
}
