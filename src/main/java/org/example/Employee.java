package org.example;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.Data;

import java.util.Date;

/**
 * Класс Employee представляет собой модель данных для сотрудника.
 * Он используется для хранения информации о сотрудниках, полученной из CSV файла.
 */
@Data
public class Employee {

    /**
     * Уникальный идентификатор сотрудника.
     */
    @CsvBindByName(column = "id")
    Long id;

    /**
     * Имя сотрудника.
     */
    @CsvBindByName(column = "name")
    String name;

    /**
     * Пол сотрудника (например, "мужской" или "женский").
     */
    @CsvBindByName(column = "gender")
    String male;

    /**
     * Дата рождения сотрудника.
     * Формат даты: "дд.мм.гггг".
     */
    @CsvBindByName(column = "BirtDate")
    @CsvDate("dd.MM.yyyy")
    Date birthdate;

    /**
     * Подразделение, в котором работает сотрудник.
     */
    @CsvBindByName(column = "Division")
    String division;

    /**
     * Зарплата сотрудника.
     */
    @CsvBindByName(column = "Salary")
    int salary;
}
