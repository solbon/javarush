package tests.visiona;

/**
 * Created by admin on 11.02.2016.
 */
public class MinimumCostTickets {
	public int solution(int[] A) {
		// write your code in Java SE 8
		int days = 0;
		int weeks = 0;
		int months = 0;
		int maxWeek = 0;
		int maxMonth = 0;
		for (int i = 0; i < A.length; i++) {
			if (enoughDaysForMonthTicket(A, i)) {
				if (A[i] <= maxMonth) {
					continue;
				}
				months++;
				maxMonth = A[i] + 29;
				i = i + 15;
			} else if (enoughDaysForWeekTicket(A, i)) {
				if (A[i] <= maxWeek) {
					continue;
				}
				weeks++;
				maxWeek = A[i] + 6;
				i = i + 3;

			} else {
				days++;
			}
		}

		return months * 25 + weeks * 7 + days * 2;
	}

	private boolean enoughDaysForWeekTicket(int[] A, int i) {
		return (A.length >= 4) && ((i + 3) < A.length) && (A[i + 3] - A[i] < 7);
	}

	private boolean enoughDaysForMonthTicket(int[] A, int i) {
		return (A.length > 16) && ((i + 15 < A.length)) && (A[i + 15] - A[i] < 30);
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 4, 5, 7, 8, 9, 10, 11, 30 };
		System.out.println(new MinimumCostTickets().solution(array));
	}
}
