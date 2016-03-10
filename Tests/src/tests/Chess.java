package tests;

/**
 * Created by solbon on 25.07.2014.
 */
class Game {
    Game (int i) {
        System.out.println("Constructor Game");
    }
}

class BoardGame extends Game {
    BoardGame (int i) {
        super(i);
        System.out.println("Constructor BoardGame");
    }
}

public class Chess extends BoardGame {
    Chess (int i) {
        super(2);
        System.out.println("Constructor Chess");
    }

    public static void main(String[] args) {
        Chess chess = new Chess(8);
    }
}
