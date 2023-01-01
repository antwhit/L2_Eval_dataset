public class OBFormat {

    private long swigCPtr;

    protected boolean swigCMemOwn;

    protected OBFormat(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    protected static long getCPtr(OBFormat obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (swigCPtr != 0 && swigCMemOwn) {
            swigCMemOwn = false;
            openbabelJNI.delete_OBFormat(swigCPtr);
        }
        swigCPtr = 0;
    }

    public boolean ReadMolecule(OBBase arg0, OBConversion arg1) {
        return openbabelJNI.OBFormat_ReadMolecule(swigCPtr, this, OBBase.getCPtr(arg0), arg0, OBConversion.getCPtr(arg1), arg1);
    }

    public boolean ReadChemObject(OBConversion arg0) {
        return openbabelJNI.OBFormat_ReadChemObject(swigCPtr, this, OBConversion.getCPtr(arg0), arg0);
    }

    public boolean WriteMolecule(OBBase arg0, OBConversion arg1) {
        return openbabelJNI.OBFormat_WriteMolecule(swigCPtr, this, OBBase.getCPtr(arg0), arg0, OBConversion.getCPtr(arg1), arg1);
    }

    public boolean WriteChemObject(OBConversion arg0) {
        return openbabelJNI.OBFormat_WriteChemObject(swigCPtr, this, OBConversion.getCPtr(arg0), arg0);
    }

    public String Description() {
        return openbabelJNI.OBFormat_Description(swigCPtr, this);
    }

    public String TargetClassDescription() {
        return openbabelJNI.OBFormat_TargetClassDescription(swigCPtr, this);
    }

    public SWIGTYPE_p_std__type_info GetType() {
        return new SWIGTYPE_p_std__type_info(openbabelJNI.OBFormat_GetType(swigCPtr, this), false);
    }

    public String SpecificationURL() {
        return openbabelJNI.OBFormat_SpecificationURL(swigCPtr, this);
    }

    public String GetMIMEType() {
        return openbabelJNI.OBFormat_GetMIMEType(swigCPtr, this);
    }

    public long Flags() {
        return openbabelJNI.OBFormat_Flags(swigCPtr, this);
    }

    public int SkipObjects(int arg0, OBConversion arg1) {
        return openbabelJNI.OBFormat_SkipObjects(swigCPtr, this, arg0, OBConversion.getCPtr(arg1), arg1);
    }

    public OBFormat MakeNewInstance() {
        long cPtr = openbabelJNI.OBFormat_MakeNewInstance(swigCPtr, this);
        return (cPtr == 0) ? null : new OBFormat(cPtr, false);
    }
}
