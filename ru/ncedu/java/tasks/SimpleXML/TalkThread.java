package ru.ncedu.java.tasks.SimpleXML;

/**
 * Created by Mari on 14.05.2016.
 */
public class TalkThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Talking");
            try {
                Thread.sleep(7); // остановка на 7 миллисекунд
            } catch (InterruptedException e) {
                System.err.print(e);
            }
        }
    }
}
//    package by.bsu.threads;
    class WalkRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Walking");
                try {
                    Thread.sleep(7);
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }
        }

//    package by.bsu.threads;
//    public class WalkTalk {
        public static void main(String[ ] args) {
            // новые объекты потоков
            TalkThread talk = new TalkThread();
            Thread walk = new Thread(new WalkRunnable());
            // запуск потоков
            talk.start();
            walk.start();
            // WalkRunnable w = new WalkRunnable(); // просто объект, не поток
            // w.run(); или talk.run(); // выполнится метод, но поток не запустится!
        }
    }