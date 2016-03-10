package tests.algorythms.week1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by admin on 16.02.2016.
 */
public class Percolation {
	private boolean openSites[];
	private int N;
	private WeightedQuickUnionUF uf;
	private int virtualTop;
	private int virtualBottom;

	Percolation(int N) {
		this.N = N;
		virtualTop = N * N;
		virtualBottom = N * N + 1;
		this.openSites = new boolean[N * N];
		this.uf = new WeightedQuickUnionUF(N * N + 2);
	}

	public void open(int i, int j) {
		validateIndices(i, j);
		openSites[xyTo1D(i, j)] = true;

		if (i == 1)
			uf.union(xyTo1D(i, j), virtualTop);
		if (i == N)
			uf.union(xyTo1D(i, j), virtualBottom);
		if ((i != 1) && isOpen(i - 1, j))
			uf.union(xyTo1D(i, j), xyTo1D(i - 1, j));
		if ((i != N) && isOpen(i + 1, j))
			uf.union(xyTo1D(i, j), xyTo1D(i + 1, j));
		if ((j != 1) && isOpen(i, j - 1))
			uf.union(xyTo1D(i, j), xyTo1D(i, j - 1));
		if ((j != N) && isOpen(i, j + 1))
			uf.union(xyTo1D(i, j), xyTo1D(i, j + 1));
	}

	private void validateIndices(int i, int j) {
		if (i > N || j > N || i <= 0 || j <= 0) {
			throw new IndexOutOfBoundsException();
		}
	}

	public boolean isOpen(int i, int j) {
		validateIndices(i, j);
		return openSites[xyTo1D(i, j)];
	}

	public boolean isFull(int i, int j) {
		validateIndices(i, j);
		if (isOpen(i, j)) {
			return uf.connected(xyTo1D(i, j), virtualTop);
		}
		return false;
	}

	public boolean percolates() {
		return uf.connected(virtualTop, virtualBottom);
	}

	private int xyTo1D(int x, int y) {
		return 4 * (x - 1) + y - 1;
	}

	public static void main(String[] args) {
		Percolation p = new Percolation(4);
		p.open(1, 1);
		System.out.println("System percolates: " + p.percolates());
		p.open(2, 1);
		System.out.println("System percolates: " + p.percolates());
		p.open(3, 1);
		System.out.println("System percolates: " + p.percolates());
		p.open(4, 1);
		System.out.println("System percolates: " + p.percolates());

		for (int i = 1; i <= p.N; i++) {
			for (int j = 1; j <= p.N; j++) {
				if (p.isOpen(i, j)) {
					System.out.println("(" + i + ", " + j + ") is opened");
				} else {
					System.out.println("(" + i + ", " + j + ") is closed");
				}
			}
		}
	}

}