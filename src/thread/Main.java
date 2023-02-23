package thread;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    static String target = ".idea";
    static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(6);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String disk = "D:\\Test";
        delete(disk);
//        executor.shutdownNow();
        System.out.println(System.currentTimeMillis() - startTime);

    }

    private static void delete(String path) {
        File file = new File(path);
        String fileName = file.getName();
        if (file.isDirectory() && fileName.equals(target)) {
            MyThread myThread = new MyThread(file);
            Main.executor.submit(myThread);
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                delete(path + "/" + files[i].getName());
            }
        }
    }
}
