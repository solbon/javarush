package tests.qsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Qsorting
{
    private static int n = 5;
    private static int[] mas = new int[n];

    public static void initArray() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++)
            mas[i] = Integer.parseInt(reader.readLine());
    }


    public static void quicksort(int start, int end) {
        int i = start, j = end;
        if (i >= j) return;

        int mid = i - (i - j)/2;

        while (i < j) {
            while ((mas[i] < mas[mid]) && (i < mid)) i++;
            while ((mas[j] > mas[mid]) && (j > mid)) j--;

            if (i < j) {
                int temp = mas[i];
                mas[i] = mas[j];
                mas[j] = temp;
                if (i == mid) mid = j;
                else if (j == mid) mid = i;
            }

        }
        quicksort(start, mid);
        quicksort(mid + 1, end);

    }

    public static void main(String[] args) throws Exception {
        //Напишите тут ваш код

        //quick sort
        initArray();

        quicksort(0, n - 1);

        //output
        for(int i = n - 1; i>=0;i--)
            System.out.println(mas[i]);

    }


}
