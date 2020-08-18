import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        GameProgress save1 = new GameProgress(100, 1, 2, 4.7);
        GameProgress save2 = new GameProgress(87, 3, 4, 8.3);
        GameProgress save3 = new GameProgress(44, 4, 9, 13.8);

        
    }

    public void savegame(String path, GameProgress save) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(save);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void zipFiles(String path, List<String> listOfPaths) {
      try {
          FileOutputStream fileOutputStream = new FileOutputStream(path);
          ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
          try {
              for (String pathForEach : listOfPaths) {
                  FileInputStream fileInputStream = new FileInputStream(pathForEach);
                  ZipEntry zipEntry = new ZipEntry(pathForEach);
                  zipOutputStream.putNextEntry(zipEntry);
                  zipOutputStream.write(fileInputStream.read());
                  File file = new File(pathForEach);
                  file.delete();
              }
          } catch (FileNotFoundException e) {
              System.out.println(e.getMessage());
          }
          zipOutputStream.closeEntry();
      } catch (IOException e) {
          System.out.println(e.getMessage());
      }
    }
}
