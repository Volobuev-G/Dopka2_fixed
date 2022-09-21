package com.dop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(fileReader(Path.of("results.txt")));
    }
    public static Map<String, Integer> fileReader(Path file) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<Integer>> mapList = new HashMap<>();
        Files.lines(file).map(s -> s.split("\\s+"))
                .forEach(array -> {StudentsTasksAttempts student = new StudentsTasksAttempts(array[0]
                        ,Integer.parseInt(array[1])
                        ,Integer.parseInt(array[2])
                        ,Integer.parseInt(array[3]));
                    List<Integer> list = new ArrayList<>();
                    list.add(student.getTaskNumber());
                    list.add(student.getAttemptNumber());
                    list.add(student.getScore());
                    if (mapList.containsKey(student.getLastName())) {
                        mapList.put(student.getLastName(),listUpdater(mapList.get(student.getLastName()),list));
                    }
                    mapList.putIfAbsent(student.getLastName(),list);
                });
        mapList.keySet().stream().forEach(x -> map.put(x,scoreCounter(mapList.get(x))));
        return map;
    }
    public static int scoreCounter(List<Integer> list) {
        if (list.get(1) < 5) {
            return list.get(2) * list.get(0);
        } else if (list.get(1) >=5 && list.get(1) < 10) {
            return list.get(2)/2 * list.get(0);
        } else {
            return 1;
        }
    }
    public static List<Integer> listUpdater(List<Integer> old, List<Integer> update) {
        List<Integer> finalList = new ArrayList<>();
        finalList.add(old.get(0) + 1);
        finalList.add(old.get(1) + update.get(1));
        finalList.add(old.get(2) + update.get(2));
        return finalList;
    }
}
