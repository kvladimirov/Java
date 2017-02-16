//package StreamApi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Path studentsDataPath = Paths.get("src/resources/StudentData.txt");
        List<String> data = new ArrayList<>();

        try {
            data = Files.readAllLines(studentsDataPath);
        } catch (IOException e) {
            e.printStackTrace();
        }


        List<Student> students = new ArrayList<>();

        for (int i = 1; i < data.size(); i++) {
            String[] tokens = data.get(i).split("\\s+");

            String facultyNumber = tokens[0];
            String firstName = tokens[1];
            String lastName = tokens[2];
            String email = tokens[3];
            Integer age = Integer.parseInt(tokens[4]);
            Integer group = Integer.parseInt(tokens[5]);

            List<Integer> grades = new ArrayList<>();
            //Stream.of(tokens).skip(6).limit(4).mapToInt(Integer::parseInt).forEach(grades::add);

//            Student student = new Student(facultyNumber, firstName, lastName, email, age, group, grades, phone);
//
//            for (int gradeIndex = 6; gradeIndex <= 9; gradeIndex++) {
//                Integer grade = Integer.parseInt(tokens[gradeIndex]);
//                student.getGrades().add(grade);
//            }
            for (int gradeIndex = 6; gradeIndex < 10; gradeIndex++) {
                grades.add(Integer.parseInt(tokens[gradeIndex]));
            }

            String phone = tokens[10];

            Student student = new Student(facultyNumber, firstName, lastName, email ,age, group, grades, phone);

            students.add(student);

        }


        //1.Students by Group
//        students.stream()
//                .filter(g -> g.getGroup() == 2)
//                .sorted((a, b) -> a.getFirstName().compareTo(b.getFirstName()))
//                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));


        //2.Students by First and Last Name

//        students.stream()
//                .filter(s -> s.getFirstName().compareTo(s.getLastName()) < 0)
//                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));


        //3.Students by Age

//        students.stream()
//                .filter(s -> s.getAge() >= 18 && s.getAge() <= 24)
//                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getAge()));


        //4.Sort Students

//        Comparator<Student> lastAscending = (s1, s2) -> s1.getLastName().compareTo(s2.getLastName());
//        Comparator<Student> studentComparator =
//                lastAscending
//                        .thenComparing((s1, s2) -> s2.getFirstName().compareTo(s1.getFirstName()));
//
//        students.stream()
//                .sorted(studentComparator)
//                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));


        //5.Filter Students by Email Domain

//        students.stream()
//                .filter(s1 -> s1.getEmail().contains("@gmail.com"))
//                .forEach(s1 -> System.out.println(s1.getFirstName() + " " + s1.getLastName() + " " + s1.getEmail()));


        //6.Filter Students by Phone
//        Pattern pattern = Pattern.compile("(02|\\+3592)\\d+");
//
//        students.stream()
//                .filter(w -> w.getPhone().matches(String.valueOf(pattern)))
//                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getPhone()));


        //7.Excellent Students
//        students.stream()
//                .filter(s -> s.getGrades().contains(6))
//                .forEach(s -> {
//                    System.out.print(s.getFirstName() + " " + s.getLastName() + " ");
//                    s.getGrades().stream().sorted((a, b) -> b.compareTo(a))
//                            .forEach(w -> System.out.print(w + " "));
//                    System.out.println();
//                });


        //8.Weak Students
//        students.stream()
//                    .filter(s -> {
//                        int weakGradesCount = 0;
//                        for (Integer grade : s.getGrades()) {
//                            if (grade <= 3)
//                                weakGradesCount++;
//                        }
//
//                        if (weakGradesCount >= 2)
//                            return true;
//
//                        return false;
//                    }).sorted((s1, s2) -> Integer.compare(
//                            s1.getGrades().stream().mapToInt(g -> g).sum(),
//                            s2.getGrades().stream().mapToInt(g -> g).sum()))
//                    .forEach(s -> {
//                        System.out.print(s.getFirstName() + " " + s.getLastName() + " ");
//                        s.getGrades().stream()
//                                .sorted()
//                                .forEach(g -> System.out.print(g + " "));
//
//                        System.out.println();
//                    });


        //9.Students by Enrollment Year
//        Map<Integer, List<Student>> studentsByYear = students.stream()
//                .collect(Collectors.groupingBy(
//                        s -> Integer.valueOf(
//                                s.getFacultyNumber().substring(s.getFacultyNumber().length() - 2)
//                        )
//                ));
//
//        studentsByYear.entrySet().stream()
//                .sorted((e1, e2) -> Integer.compare(e1.getKey(), e2.getKey()))
//                .forEach(e -> {
//                    System.out.println("20" + e.getKey() + ":");
//                    e.getValue().stream()
//                            .sorted((s1, s2) -> (s1.getFirstName() + s1.getLastName())
//                            .compareTo(s2.getFirstName() + s2.getLastName()))
//                            .forEach(s -> System.out.println("-- " + s.getFirstName() + " " + s.getLastName()));
//                });

    }
}
