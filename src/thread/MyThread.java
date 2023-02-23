package thread;

import java.io.File;

public class MyThread implements Runnable {
    File file;

    public MyThread(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            File file1 = files[i];
            if (file1.isFile()) {
                file1.delete();
            } else {
                deleteFile(file1.listFiles());
            }
            file1.delete();
        }
        file.delete();
    }

    public static void deleteFile(File[] files) {
        for (int i = 0; i < files.length; i++) {
            File file1 = files[i];
            if (file1.isFile()) {
                file1.delete();
            } else {
                deleteFile(file1.listFiles());
                file1.delete();
            }
        }
    }
}
