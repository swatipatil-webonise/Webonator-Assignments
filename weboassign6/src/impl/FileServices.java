package impl;

import java.io.*;

public class FileServices {
    public void searchWord(BufferedReader bufferedReader, String searchWord) throws IOException{
        try {
            String inputlineFromFile = null, wordsFromLine[] = null;
            boolean flag = false;
            while ((inputlineFromFile = bufferedReader.readLine()) != null) {
                wordsFromLine = inputlineFromFile.split(" ");
                for (String word : wordsFromLine) {
                    if (word.equals(searchWord)) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                System.out.println(searchWord + " is present in the file.");
            } else {
                System.out.println(searchWord + " is not present in the file.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
    }

    public void copyOneFileIntoOther(BufferedReader bufferedReader, FileWriter fileWriter) throws IOException{
        String inputlineFromFile = null;
        try {
            while ((inputlineFromFile = bufferedReader.readLine()) != null) {
                fileWriter.write(inputlineFromFile);
                fileWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
            fileWriter.close();
        }
    }
}
