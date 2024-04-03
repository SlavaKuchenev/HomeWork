package Lesson_6;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File file = new File("Test.csv");
        AppData appData = new AppData();
        save(appData, file);
        load(appData, file);
    }

    public static void save(AppData data, File file) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            StringBuilder header = new StringBuilder();
            for (String headerValue : data.getHeader()) {
                header.append(headerValue).append(";");
            }
            writer.write(header.toString());
            writer.newLine();

            for (int[] dataline : data.getData()) {
                for (int dataElements : dataline) {
                    writer.write(dataElements + ";");
                }
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load(AppData data, File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            String[] header = line.split(";");
            data.setHeader(header);
            System.out.println(Arrays.toString(header));
            int dataElementIndex = 0;
            int[][] arryData = data.getData();
            while ((line = reader.readLine()) != null) {
                String[] dataValues = line.split(";");
                int[] dataElement = new int[dataValues.length];
                for (int i = 0; i < dataValues.length; i++) {
                    dataElement[i] = Integer.parseInt(dataValues[i]);
                }
                arryData[dataElementIndex] = dataElement;
                System.out.println(Arrays.toString(dataElement));
                dataElementIndex++;
            }
            data.setData(arryData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class AppData {
    private String[] header = {"Value1", "Value2", "Value3"};
    private int[][] data = {{100, 200, 123}, {300, 400, 500}};

    public AppData() {
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public void setData(int[][] data) {
        this.data = data;
    }
}
