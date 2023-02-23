package withoutthread;

import java.io.File;

public class Main {
    //241ms
    static String target = "src";
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String disk = "D:\\Test";
        delete(disk);
        System.out.println(System.currentTimeMillis()-startTime);
    }
    private static void delete(String path) {
        File file = new File(path);
        String fileName = file.getName();
        if (file.isDirectory() && fileName.equals(target)) {
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
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                delete(path + "/" + files[i].getName());
            }
        }
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