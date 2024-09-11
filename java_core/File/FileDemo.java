import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileReader;

public class FileDemo {
    public static void main(String[] args) {
        File f = null;
        String filepath = "../AnonymousClass/AnonymousClassDemo.java";

        try {
            f = new File(filepath);

            boolean executable = f.canExecute();
            System.out.println("This file is executable? " + executable);

            String absolutePath = f.getAbsolutePath();
            System.out.println("Absolute path: " + absolutePath);

            boolean isDir = f.isDirectory();
            System.out.println("Is directory? " + isDir);

            boolean isFile = f.isFile();
            System.out.println("Is file? " + isFile);

            int[] numbers = {5, 6, 2, 4, 6};

            String filepath2 = "./file.txt";

            OutputStream out = new FileOutputStream(filepath2);
            for (int n : numbers) {
                out.write(n);
            }

            out.close();
            InputStream in = new FileInputStream(filepath2);
            int size = in.available();
            for (int i = 0; i < size; i++) {
                System.out.println((int) in.read() + " ");
            }

            in.close();

            File file2 = new File("./file2.txt");
            file2.createNewFile();

            int c;

            if (file2.exists()) {
                file2.delete();
            }

            FileReader reader = new FileReader(filepath2);
            while((c = reader.read()) != -1) {
                int ch = (int) c;
                System.out.print(ch + " ");
            }



        } catch (Exception e) {
            System.out.println("File not found");
        }

        
        
    }
}