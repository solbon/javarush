package tests.algorythms.week1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by admin on 15.02.2016.
 */
public class UF {
	private int[] id;

	UF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	boolean connected(int p, int q) {
		return (id[p] == id[q]);
	}

	void union(int p, int q) {
		if (connected(p, q)) {
			return;
		}
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid) {
				id[i] = qid;
			}
		}
	}

	public static void main(String[] args)
	{
		int N = StdIn.readInt();
		UF uf = new UF(N);
		while (!StdIn.isEmpty())
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (!uf.connected(p, q)) {
				uf.union(p, q);
				StdOut.println(p + " " + q);
			} else {
				System.out.println(p + " " + q + " are already connected!");
			}
		}
	}
}
