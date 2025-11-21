package week12.LabWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VocManager {
    String userName;
    List<Word> voc = new ArrayList<>();

    VocManager(String userName) {
        this.userName = userName;
    }

    void addWord(Word word) {
        voc.add(word);
    }

    String makeVoc(String fileName) {
        try (Scanner scan = new Scanner(new File(fileName))) {
            while (scan.hasNextLine()) {
                String str = scan.nextLine();
                String[] temp = str.split("\t");
                this.addWord(new Word(temp[0].trim(), temp[1].trim()));
            }
            return userName + "의 단어장 생성이 완료되었습니다.";

        } catch (FileNotFoundException e) {
            return "단어장이 생성되지 않았습니다. \n파일명을 확인하세요.";
        }
    }

    public List<Word> searchVoc2(String sWord) {
        List<Word> list = new ArrayList<>();
        sWord = sWord.trim();
        boolean flag = false;
        for (Word word : voc) {
            if (word != null) {
                if (word.eng.indexOf(sWord) == 0) {
                    flag = true;
                    System.out.println(word);
                    list.add(word);
                }
            }
        }
        if (!flag) {
            System.out.println("단어장에 등록되어 있지 않습니다.");
        }
        return list;
    }

    public Word searchVoc(String sWord) {
        sWord = sWord.trim();
        for (Word word : voc) {
            if (word != null) {
                if (word.eng.equals(sWord)) {
                    System.out.println("단어의 뜻 : " + word.kor);
                    return word;
                }
            }
        }
        System.out.println("단어장에 등록되어 있지 않습니다.");
        return null;
    }
}








