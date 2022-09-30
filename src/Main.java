import java.io.*;

public class Main {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        sb.append(createNewFolder("C:/Games/src"));

        sb.append(createNewFolder("C:/Games/src/main"));

        sb.append(createNewFile("C:/Games/src/main", "main.java"));

        sb.append(createNewFile("C:/Games/src/main", "utils.java"));

        sb.append(createNewFolder("C:/Games/src/test"));

        sb.append(createNewFolder("C:/Games/res"));

        sb.append(createNewFolder("C:/Games/res/drawables"));

        sb.append(createNewFolder("C:/Games/res/vectors"));

        sb.append(createNewFolder("C:/Games/res/icons"));

        sb.append(createNewFolder("C:/Games/savegames"));

        sb.append(createNewFolder("C:/Games/temp"));

        sb.append(createNewFile("C:/Games/temp", "temp.txt"));

        String text = sb.toString();

        try (FileWriter writer = new FileWriter("C:/Games/temp/temp.txt", false)) {
            writer.write(text);
            writer.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static String createNewFolder(String path) {
        File folder = new File(path);
        if (folder.mkdir()) {
            return "Каталог создан ";
        } else {
            return "Каталог не создан ";
        }
    }

    public static String createNewFile(String path, String name) {
        File file = new File(path, name);
        try {
            if (file.createNewFile()) {
                return "Файл создан ";
            } else {
                return "Файл не создан ";
            }
        } catch(Exception ex) {
            return "Ошибка ";
        }
    }
}