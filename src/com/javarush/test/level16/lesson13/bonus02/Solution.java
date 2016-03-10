package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
*/

public class Solution extends Thread{
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static {
        threads.add(new MyThread1());
        threads.add(new MyThread2());
        threads.add(new MyThread3());
        threads.add(new MyThread4());
        threads.add(new MyThread5());
    }



    public static void main(String[] args) throws InterruptedException {
//        for (Thread t : threads)
//            t.start();
//        Thread.sleep(2000);
//        for (Thread t : threads)
//            t.interrupt();
//        Thread thread4 = threads.get(3);
//        Message message = (Message) thread4;
//        thread4.start();
//        Thread.sleep(500);
//        message.showWarning();
//        System.out.println(thread4.isAlive());


    }

    public static class MyThread1 extends Thread{
        public MyThread1() {}
        public void run () {while(true);}
    }

    public static class MyThread2 extends Thread{
        public MyThread2() {}
        public void run () {
            try {
                sleep(10000000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class MyThread3 extends Thread{
        public MyThread3() {}
        public void run () {
            while (true) {
                try {
                    System.out.println("Ура");
                    sleep(500);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    public static class MyThread4 extends Thread implements Message{
        public MyThread4() {}
        public void showWarning() {
            this.interrupt();
            try {
                join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public void run () {
            while (true) {
                if (isInterrupted()) {
                    System.out.println("Interrupted");
                    return;
                }
            }
        }
    }

    public static class MyThread5 extends Thread{
        public MyThread5() {
        }

        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            String a;
            while (true) {
                try {
                    a = reader.readLine();
                    if (!(a.equals("N"))) {
                        sum = sum + Integer.valueOf(a);
                    } else if (a.equals("N"))
                        break;
                } catch (IOException e) {
                } catch (NumberFormatException e1) {
                    System.out.println("Please input integer number");
                }
            }
            System.out.println(sum);
        }
    }
}
