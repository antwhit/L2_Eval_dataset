public class CyclomaticComplexity2 {

    public void example() {
        int x = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int a1 = 0;
        int a2 = 0;
        int b1 = 0;
        int b2 = 0;
        int z = 0;
        int h = 0;
        int e = 0;
        int f = 0;
        if (a == b) {
            if (a1 == b1) {
                x = 2;
            } else if (a2 == b2) {
                x = 2;
            } else {
                x = 2;
            }
        } else if (c == d) {
            while (c == d) {
                x = 2;
            }
        } else if (e == f) {
            for (int n = 0; n < h; n++) {
                x = 2;
            }
        } else {
            switch(z) {
                case 1:
                    x = 2;
                    break;
                case 2:
                    x = 2;
                    break;
                case 3:
                    x = 2;
                    break;
                default:
                    x = 2;
                    break;
            }
        }
    }
}
