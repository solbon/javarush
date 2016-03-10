package tests;

/**
 * Created by solbon on 24.07.2014.
 */
public class MyArrays {
    public static void main(String[] args) {
        int[] array = new int[5];
        Fish[] fishes = new Fish[5];



        for (int i = 0; i < fishes.length; i++) {
            fishes[i] = new Fish("fish" + i);

        }
        for (int i = 0; i < fishes.length; i++) {
            System.out.println(fishes[i].name);

        }

    }

    public static class Fish {
        String name;
        Fish(String s) {
            this.name = s;
        }
    }
}
