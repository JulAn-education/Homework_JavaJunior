package Homework1;

// Напишите программу, которая использует Stream API для обработки списка чисел.
// Программа должна вывести на экран среднее значение всех четных чисел в списке.

import java.io.InputStream;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = List.of(2, 5, 1, 9, 4, 7, 0, 8);

        double average = list.stream().filter(integer -> integer % 2 == 0)
                .mapToDouble(e -> e).average().orElse(-1);
        System.out.println(String.format("%.2f", average));

    }
}
