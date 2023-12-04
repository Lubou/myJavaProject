package org.kalbeka;

import java.io.*;

public class Operations {
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
            System.out.println("CSV saved");
        } catch (Exception e) {
            System.out.println("CSV don't save");
        }
    }

    public static void read(AppData data) {
        try (BufferedReader br = new BufferedReader(new FileReader("example.csv"))) {

            String[] header = br.readLine().split(";");
            data.setHeader(header);

            int y = 0;
            String line;
            int[][] temp = new int[2][3];
            String[] cols;
            while ((line = br.readLine()) != null) {
                cols = line.split(";");
                for (int i = 0; i < cols.length; i++) {
                    temp[y][i] = Integer.parseInt(cols[i]);
                }
                y++;
            }
            data.setData(temp);
        } catch (IOException | NumberFormatException e) {
            System.out.println("CSV don't read");
        }

    }
}
