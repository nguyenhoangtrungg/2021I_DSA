package Week2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

public class UFClient2 {

    public static void main(String[] args) {

        int N = StdIn.readInt(), Ans = 0;
        UF uf = new UF(N);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            Ans++;

            if (!uf.connected(p, q)) {
                uf.union(p, q);
                if (uf.count() == 1) {
                    StdOut.println(Ans);
                    break;
                }
            }
        }

        if(uf.count() != 1) StdOut.println("FAILED");
    }
}