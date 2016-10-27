package tests.visiona;

/**
 * Created by admin on 11.02.2016.
 */
public class WholeSquare {
	public int solution(int A, int B) {
		int count = 0;
		for (int i = 0; i < B; i++) {
			if ((i * i >= A) && (i * i <= B)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new WholeSquare().solution(4, 170));
	}
}
