import java.io.*;

public class LargeFileReading {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter File Size in MB: ");
        int fileSize = sc.nextInt();

        long startTime, endTime;

        startTime = System.nanoTime();
        fileReader(fileSize);
        endTime = System.nanoTime();
        System.out.println("FileReader Time: " + (endTime - startTime) / 1000000 + "ms");

        startTime = System.nanoTime();
        inputStreamReader(fileSize);
        endTime = System.nanoTime();
        System.out.println("InputStreamReader Time: " + (endTime - startTime) / 1000000 + "ms");

        sc.close();
    }

    static void fileReader(int fileSize) throws IOException {
        FileReader fr = new FileReader("testFile.txt");
        char[] buffer = new char[fileSize * 1024 * 1024];
        fr.read(buffer);
        fr.close();
    }

    static void inputStreamReader(int fileSize) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("testFile.txt"));
        char[] buffer = new char[fileSize * 1024 * 1024];
        isr.read(buffer);
        isr.close();
    }
}
