package org.kalbeka;

/*
 * Реализовать сохранение данных в csv файл; Реализовать загрузку данных из csv файла. Файл читается целиком.
 * Структура csv файла:
 * Строка заголовок с набором столбцов
 * Набор строк с целочисленными значениями
 * Разделитель между столбцами - символ точка с запятой (;)
 * (Пример см. на скриншоте)
 * Для хранения данных использовать класс вида:
 * public class AppData {
 * private String[] header;
 * private int[][] data;
 * // ...
 * }
 * Если выполняется save(AppData data), то старые данные в файле полностью перезаписываются.
 */

import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {

        AppData appData = new AppData();

        String[] arr = {"Value 1", "Value 2", "Value 3", "Value4"};
        int[][] data = {
                {100, 200, 123, 434},
                {300, 400, 500, 235}};

        appData.setHeader(arr);
        appData.setData(data);

        save(appData);
        read();
    }

    public static void save(AppData appData) {
        try (FileWriter writer = new FileWriter("example.csv")) {

            StringBuilder header = new StringBuilder();

            // Add header
            for (int i = 0; i < appData.getHeader().length; i++) {
                header.append(appData.getHeader()[i]);
                if (i != appData.getHeader().length - 1) {
                    header.append(';');
                }
            }
            header.append("\n");
            writer.write(header.toString());

            // Add numbers
            for (int[] num : appData.getData()) {
                StringBuilder line = new StringBuilder();
                for (int i = 0; i < num.length; i++) {
                    line.append(num[i]);
                    if (i != num.length - 1) {
                        line.append(';');
                    }
                }
                line.append("\n");
                writer.write(line.toString());
            }
            writer.close();
            System.out.println("CSV saved");
        } catch (Exception e) {
            System.out.println("CSV don't save");
        }
    }

    public static void read() throws IOException {
        BufferedReader br = null;

        br = new BufferedReader(new FileReader("example.csv"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}