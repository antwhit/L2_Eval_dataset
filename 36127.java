public abstract class InStream {

    public final int check(int itemSize, int nItems) throws Exception {
        if (ptr + itemSize * nItems > end) {
            if (ptr + itemSize > end) return overrun(itemSize, nItems);
            nItems = (end - ptr) / itemSize;
        }
        return nItems;
    }

    public final void check(int itemSize) throws Exception {
        if (ptr + itemSize > end) overrun(itemSize, 1);
    }

    public final int readS8() throws Exception {
        check(1);
        return b[ptr++];
    }

    public final int readS16() throws Exception {
        check(2);
        int b0 = b[ptr++];
        int b1 = b[ptr++] & 0xff;
        return b0 << 8 | b1;
    }

    public final int readS32() throws Exception {
        check(4);
        int b0 = b[ptr++];
        int b1 = b[ptr++] & 0xff;
        int b2 = b[ptr++] & 0xff;
        int b3 = b[ptr++] & 0xff;
        return b0 << 24 | b1 << 16 | b2 << 8 | b3;
    }

    public final int readU8() throws Exception {
        return readS8() & 0xff;
    }

    public final int readU16() throws Exception {
        return readS16() & 0xffff;
    }

    public final int readU32() throws Exception {
        return readS32() & 0xffffffff;
    }

    public final String readString() throws Exception {
        int len = readU32();
        if (len > maxStringLength) throw new Exception("InStream max string length exceeded");
        char[] str = new char[len];
        int i = 0;
        while (i < len) {
            int j = i + check(1, len - i);
            while (i < j) {
                str[i++] = (char) b[ptr++];
            }
        }
        return new String(str);
    }

    public static int maxStringLength = 65535;

    public final void skip(int bytes) throws Exception {
        while (bytes > 0) {
            int n = check(1, bytes);
            ptr += n;
            bytes -= n;
        }
    }

    public void readBytes(byte[] data, int offset, int length) throws Exception {
        int offsetEnd = offset + length;
        while (offset < offsetEnd) {
            int n = check(1, offsetEnd - offset);
            System.arraycopy(b, ptr, data, offset, n);
            ptr += n;
            offset += n;
        }
    }

    public final int readOpaque8() throws Exception {
        return readU8();
    }

    public final int readOpaque16() throws Exception {
        return readU16();
    }

    public final int readOpaque32() throws Exception {
        return readU32();
    }

    public final int readOpaque24A() throws Exception {
        check(3);
        int b0 = b[ptr++];
        int b1 = b[ptr++];
        int b2 = b[ptr++];
        return b0 << 24 | b1 << 16 | b2 << 8;
    }

    public final int readOpaque24B() throws Exception {
        check(3);
        int b0 = b[ptr++];
        int b1 = b[ptr++];
        int b2 = b[ptr++];
        return b0 << 16 | b1 << 8 | b2;
    }

    public abstract int pos();

    public boolean bytesAvailable() {
        return end != ptr;
    }

    public final byte[] getbuf() {
        return b;
    }

    public final int getptr() {
        return ptr;
    }

    public final int getend() {
        return end;
    }

    public final void setptr(int p) {
        ptr = p;
    }

    protected abstract int overrun(int itemSize, int nItems) throws Exception;

    protected InStream() {
    }

    protected byte[] b;

    protected int ptr;

    protected int end;
}
