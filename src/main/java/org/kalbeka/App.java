package org.kalbeka;

/*
  Реализовать сохранение данных в csv файл; Реализовать загрузку данных из csv файла. Файл читается целиком.
  Структура csv файла:
  Строка заголовок с набором столбцов
  Набор строк с целочисленными значениями
  Разделитель между столбцами - символ точка с запятой (;)
  (Пример см. на скриншоте)
  Для хранения данных использовать класс вида:
  public class AppData {
  private String[] header;
  private int[][] data;
  // ...
  }
 Если выполняется save(AppData data), то старые данные в файле полностью перезаписываются.
 */

import java.io.*;

import static org.kalbeka.Operations.read;
import static org.kalbeka.Operations.save;

public class App {
    public static void main(String[] args) throws IOException {

        AppData appData = new AppData();
        AppData appData2 = new AppData();

        String[] arr = {"Value 1", "Value 2", "Value 3"};
        int[][] data = {
                {100, 200, 123},
                {300, 400, 500}};

        appData.setHeader(arr);
        appData.setData(data);

        save(appData);
        read(appData2);

        appData2.printData();
    }
}