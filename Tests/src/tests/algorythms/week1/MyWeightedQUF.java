package tests.algorythms.week1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by admin on 16.02.2016.
 */
public class MyWeightedQUF {
	private int[] id;
	private int[] size;

	MyWeightedQUF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}

	private int root(int i) {
		while (i != id[i]) {
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}

	public boolean connected(int p, int q) {
		return (root(p) == root(q));
	}

	public void union(int p, int q) {
		if (!connected(p, q)) {
			int rootP = root(p);
			int rootQ = root(q);
			if (size[rootP] < size[rootQ]) {
				id[rootP] = rootQ;
				size[q] += size[p];
			} else {
				id[rootQ] = rootP;
				size[rootP] += size[rootQ];
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
