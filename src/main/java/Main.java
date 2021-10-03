
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        HashMap<String, TestSubject> hashMap = new HashMap<>();
        String selectedString = "";
        for (int i = 0; i < 100; i++) {
            TestSubject subject = new TestSubject(i);
            hashMap.put(subject.getId(), subject);
            if (i == 27) {
                selectedString = subject.getId();

            }
        }

        /*System.out.println(hashMap.get(selectedString).getId());
        if (hashMap.get(selectedString).getId() == selectedString) {
            System.out.println("TRUE");
        }else{
                System.out.println("FALSE");*/

        TreeMap<Integer, TestSubject> subjectTreeMap = new TreeMap<>(new TestComparator());
        for (int i = 0; i < 100; i++) {
           TestSubject subject = new TestSubject(i);
           subjectTreeMap.put(subject.getOrdinal(), subject);
            }

        Parser parser = new Parser();
        ArrayList<String> list = null;
        File file = new File("Voina_i_mir.txt");
        try {
            list = parser.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        {int wordCount = getWordCount(list);
            System.out.println(wordCount + " Вхождений на слово \"Страдание\"");}
        System.out.println("Таблица умножения: ");
        for (int i=1; i<=10; i++) {
            for(int j=1; j<=10; j++) {
                System.out.print(i * j + " ");}
            System.out.println("");


        }

            Scanner scanner = null;
            String wordPattern = "страдан";
            int count = 0;
            Pattern pattern = Pattern.compile(wordPattern, Pattern.CASE_INSENSITIVE);
            try {
                scanner = new Scanner(new File("Voina_i_mir.txt"));

                while (scanner.hasNextLine ()){
                    if (scanner.findInLine(pattern) !=null) {
                        ++count;
                    }
                    scanner.nextLine();

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println(count + " scanner");

        }

        private static int getWordCount(ArrayList<String> list) {
            int wordCount = 0;
            String wordPattern = "страдан";
            Pattern pattern = Pattern.compile(wordPattern, Pattern.CASE_INSENSITIVE);
            for (String s : list) {
                Matcher matcher = pattern.matcher(s);
                while (matcher.find()) {
                    wordCount++;
                }
            }
            return wordCount;
        }
}





