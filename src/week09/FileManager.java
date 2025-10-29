//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package week09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileManager {
    public static void fileWriter(Scanner file, PrintWriter outfile) {
        while(file.hasNextLine()) {
            String str = file.nextLine();
            outfile.println(str);
        }

    }

    public static void fileMerge(String filename1, String filename2, String filename3) {
        try {
            try (
                    Scanner file1 = new Scanner(new File(filename1));
                    Scanner file2 = new Scanner(new File(filename2));
                    PrintWriter outfile = new PrintWriter(filename3);
            ) {
                fileWriter(file1, outfile);
                fileWriter(file2, outfile);
                System.out.println("파일 합치기가 완료되었습니다.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("파일이 없음");
            throw new RuntimeException(e);
        }
    }
}
