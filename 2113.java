public class OBElementTable extends OBGlobalDataBase {

    private long swigCPtr;

    protected OBElementTable(long cPtr, boolean cMemoryOwn) {
        super(openbabelJNI.SWIGOBElementTableUpcast(cPtr), cMemoryOwn);
        swigCPtr = cPtr;
    }

    protected static long getCPtr(OBElementTable obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (swigCPtr != 0 && swigCMemOwn) {
            swigCMemOwn = false;
            openbabelJNI.delete_OBElementTable(swigCPtr);
        }
        swigCPtr = 0;
        super.delete();
    }

    public OBElementTable() {
        this(openbabelJNI.new_OBElementTable(), true);
    }

    public void ParseLine(String arg0) {
        openbabelJNI.OBElementTable_ParseLine(swigCPtr, this, arg0);
    }

    public long GetNumberOfElements() {
        return openbabelJNI.OBElementTable_GetNumberOfElements(swigCPtr, this);
    }

    public long GetSize() {
        return openbabelJNI.OBElementTable_GetSize(swigCPtr, this);
    }

    public int GetAtomicNum(String arg0) {
        return openbabelJNI.OBElementTable_GetAtomicNum__SWIG_0(swigCPtr, this, arg0);
    }

    public int GetAtomicNum(String arg0, SWIGTYPE_p_int iso) {
        return openbabelJNI.OBElementTable_GetAtomicNum__SWIG_1(swigCPtr, this, arg0, SWIGTYPE_p_int.getCPtr(iso));
    }

    public String GetSymbol(int arg0) {
        return openbabelJNI.OBElementTable_GetSymbol(swigCPtr, this, arg0);
    }

    public double GetVdwRad(int arg0) {
        return openbabelJNI.OBElementTable_GetVdwRad(swigCPtr, this, arg0);
    }

    public double GetCovalentRad(int arg0) {
        return openbabelJNI.OBElementTable_GetCovalentRad(swigCPtr, this, arg0);
    }

    public double GetMass(int arg0) {
        return openbabelJNI.OBElementTable_GetMass(swigCPtr, this, arg0);
    }

    public double CorrectedBondRad(int arg0, int arg1) {
        return openbabelJNI.OBElementTable_CorrectedBondRad__SWIG_0(swigCPtr, this, arg0, arg1);
    }

    public double CorrectedBondRad(int arg0) {
        return openbabelJNI.OBElementTable_CorrectedBondRad__SWIG_1(swigCPtr, this, arg0);
    }

    public double CorrectedVdwRad(int arg0, int arg1) {
        return openbabelJNI.OBElementTable_CorrectedVdwRad__SWIG_0(swigCPtr, this, arg0, arg1);
    }

    public double CorrectedVdwRad(int arg0) {
        return openbabelJNI.OBElementTable_CorrectedVdwRad__SWIG_1(swigCPtr, this, arg0);
    }

    public int GetMaxBonds(int arg0) {
        return openbabelJNI.OBElementTable_GetMaxBonds(swigCPtr, this, arg0);
    }

    public double GetElectroNeg(int arg0) {
        return openbabelJNI.OBElementTable_GetElectroNeg(swigCPtr, this, arg0);
    }

    public double GetIonization(int arg0) {
        return openbabelJNI.OBElementTable_GetIonization(swigCPtr, this, arg0);
    }

    public double GetElectronAffinity(int arg0) {
        return openbabelJNI.OBElementTable_GetElectronAffinity(swigCPtr, this, arg0);
    }

    public vectorDouble GetRGB(int arg0) {
        return new vectorDouble(openbabelJNI.OBElementTable_GetRGB(swigCPtr, this, arg0), true);
    }

    public String GetName(int arg0) {
        return openbabelJNI.OBElementTable_GetName(swigCPtr, this, arg0);
    }
}
