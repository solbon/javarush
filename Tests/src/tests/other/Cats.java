package tests.other;

/**
 * Created by solbon on 25.07.2014.
 */

class SiamCat {
    SiamCat () {
        System.out.println("ConstructorSiam: myau");
    }
    SiamCat (String name) {
        siamName = name;
        System.out.println("siamName = " + siamName);
    }
    private String siamName;
    public static void Myau() {
        System.out.println("Siam: Myau");
    }

    public static void main(String[] args) {
        SiamCat siamCat = new SiamCat("Murzik");
        Myau();
    }
}

public class Cats extends SiamCat {
    public static void main(String[] args) {
        Myau();
        SiamCat.main(args);
    }
}
