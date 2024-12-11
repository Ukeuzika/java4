package org.example;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            List<Employee> employees = CSVReader.getListFromCSVFile("foreign_names.csv", Employee.class);
            for(Employee i : employees){
                System.out.println(i.toString());
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}