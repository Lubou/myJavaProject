package org.kalbeka;

public class AppData {

    private String[] header = new String[3];
    private int[][] data = new int[2][3];

    public void setHeader(String[] arr) {
        this.header = arr;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public int[][] getData() {
        return this.data;
    }

    public String[] getHeader() {
        return this.header;
    }

    public void printData() {
        for (String h : header) {
            System.out.print(h + " ");
        }
        System.out.println();
        for (int[] row : data) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}