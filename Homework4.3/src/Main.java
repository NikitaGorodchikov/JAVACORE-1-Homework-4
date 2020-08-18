import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {
    public static void main(String[] args) {
    }

    public void openZip(String zipPath, String openPath) {
        try (FileInputStream fileInputStream = new FileInputStream(zipPath)) {
            ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
            int i = fileInputStream.read();
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                File file = new File(openPath, zipEntry.getName());
                FileOutputStream fout = new FileOutputStream(file);
                fout.write(i);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public GameProgress openProgress(String path) {
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            GameProgress progress = (GameProgress) objectInputStream.readObject();
            System.out.println(progress.toString());
            return progress;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
