import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class ChallengeCompare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Part 1: StringBuilder vs StringBuffer");
        String str = "hello";
        int repetitions = 1000000;

        long startBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repetitions; i++) {
            sb.append(str);
        }
        long endBuilder = System.nanoTime();
        System.out.println("StringBuilder time: " + (endBuilder - startBuilder) / 1_000_000 + " ms");

        long startBuffer = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < repetitions; i++) {
            sbf.append(str);
        }
        long endBuffer = System.nanoTime();
        System.out.println("StringBuffer time: " + (endBuffer - startBuffer) / 1_000_000 + " ms");

        System.out.println("\nPart 2: FileReader vs InputStreamReader");

        System.out.print("Enter file path for reading (100MB file): ");
        String filePath = scanner.nextLine();

        try {
            long startFileReader = System.nanoTime();
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            int wordCountFR = 0;
            String lineFR;
            while ((lineFR = br.readLine()) != null) {
                wordCountFR += lineFR.split("\\s+").length;
            }
            br.close();
            fr.close();
            long endFileReader = System.nanoTime();
            System.out.println("FileReader Word Count: " + wordCountFR);
            System.out.println("FileReader Time: " + (endFileReader - startFileReader) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.out.println("FileReader Error: " + e.getMessage());
        }

        try {
            long startInputStreamReader = System.nanoTime();
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br2 = new BufferedReader(isr);
            int wordCountISR = 0;
            String lineISR;
            while ((lineISR = br2.readLine()) != null) {
                wordCountISR += lineISR.split("\\s+").length;
            }
            br2.close();
            isr.close();
            fis.close();
            long endInputStreamReader = System.nanoTime();
            System.out.println("InputStreamReader Word Count: " + wordCountISR);
            System.out.println("InputStreamReader Time: " + (endInputStreamReader - startInputStreamReader) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.out.println("InputStreamReader Error: " + e.getMessage());
        }

        scanner.close();
    }
}
