package org.example;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Класс CSVReader предназначен для чтения данных из CSV файлов и преобразования их в список объектов заданного типа.
 */
public class CSVReader {

    /**
     * Метод для чтения данных из CSV файла и преобразования их в список объектов указанного типа.
     *
     * @param filename имя файла CSV (без пути, предполагается, что файл находится в директории src/main/resources)
     * @param type класс, в который будут преобразованы строки из CSV файла
     * @param <T> тип объектов, которые будут созданы из строк CSV
     * @return список объектов типа T, созданных из данных в CSV файле
     * @throws IOException если произошла ошибка при чтении файла
     */
    public static <T> List<T> getListFromCSVFile(String filename, Class<T> type) throws IOException {
        // Открываем Reader для чтения файла
        try (Reader reader = new BufferedReader(new FileReader("src/main/resources/" + filename))) {
            // Создаем CsvToBean для парсинга CSV файла
            CsvToBean<T> csvReader = new CsvToBeanBuilder<T>(reader)
                    .withType(type)
                    .withSeparator(';')
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build();
            // Парсим данные и возвращаем список объектов
            return csvReader.parse();
        }
    }
}
