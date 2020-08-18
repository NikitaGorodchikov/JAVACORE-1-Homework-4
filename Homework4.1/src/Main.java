import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder information = new StringBuilder();

        File src = new File("C:\\Users\\Nikita\\Desktop\\Архивы\\Программирование\\Проекты\\Домашние задания\\JAVACORE-1\\Homework 4\\Homework4.1\\Games\\src");
        if (src.mkdir()) information.append("Каталог ").append(src.getName()).append(" создан успешно!\n");

        File res = new File("C:\\Users\\Nikita\\Desktop\\Архивы\\Программирование\\Проекты\\Домашние задания\\JAVACORE-1\\Homework 4\\Homework4.1\\Games\\res");
        if (res.mkdir()) information.append("Каталог ").append(res.getName()).append(" создан успешно!\n");

        File savegames = new File("C:\\Users\\Nikita\\Desktop\\Архивы\\Программирование\\Проекты\\Домашние задания\\JAVACORE-1\\Homework 4\\Homework4.1\\Games\\savegames");
        if (savegames.mkdir()) information.append("Каталог ").append(savegames.getName()).append(" создан успешно!\n");

        File temp = new File("C:\\Users\\Nikita\\Desktop\\Архивы\\Программирование\\Проекты\\Домашние задания\\JAVACORE-1\\Homework 4\\Homework4.1\\Games\\temp");
        if (temp.mkdir()) information.append("Каталог ").append(temp.getName()).append(" создан успешно!\n");

        File main = new File(src, "main");
        if (main.mkdir()) information.append("Каталог ").append(main.getName()).append(" создан успешно!\n");

        File test = new File(src, "test");
        if (test.mkdir()) {
            information.append("Каталог ").append(test.getName()).append(" создан успешно!\n");
        }

        File mainfile = new File(main, "Main.java");
        File utilsfile = new File(main, "Utils.java");
        File drawables = new File(res, "drawables");

        if (drawables.mkdir()) {
            information.append("Каталог ").append(drawables.getName()).append(" создан успешно!\n");
        }
        File vectors = new File(res, "vectors");

        if (vectors.mkdir()) {
            information.append("Каталог ").append(vectors.getName()).append(" создан успешно!\n");
        }
        File icons = new File(res, "icons");

        if (icons.mkdir()) {
            information.append("Каталог ").append(icons.getName()).append(" создан успешно!\n");
        }
        File temptxt = new File(temp, "temp.txt");

        try (FileWriter tempwriter = new FileWriter(temptxt, false)) {
            information.append("Файл ").append(temptxt.getName()).append(" создан успешно!\n");
            if (mainfile.createNewFile()) {
                information.append("Файл ").append(mainfile.getName()).append(" создан успешно!\n");
            }
            if (utilsfile.createNewFile()) {
                information.append("Файл ").append(utilsfile.getName()).append(" создан успешно!\n");
            }
            tempwriter.write(String.valueOf(information));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
