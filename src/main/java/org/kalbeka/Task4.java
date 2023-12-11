package org.kalbeka;

import java.util.*;
import java.util.stream.Collectors;

//4. Создай класс со следующим содержимым: (СМ. СКРИНШОТ)
//
//4.1. Необходимо узнать средний возраст студентов мужского пола;
//4.2. Кому из студентов грозит получение повестки в этом году при условии,
// что призывной возраст установлен в диапазоне от 18 до 27 лет;

public class Task4 {

    static Collection<Student> students = Arrays.asList(
            new Student("Дмитрий", 17, Gender.MAN),
            new Student("Максим", 20, Gender.MAN),
            new Student("Екатерина", 20, Gender.WOMAN),
            new Student("Михаил", 28, Gender.MAN)
    );

    private enum Gender {
        MAN,
        WOMAN
    }

    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;

        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return (name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    Objects.equals(gender, student.gender);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }
    }

    public static void checkAge() {

        double age = (double) students.stream().filter((s) -> s.getGender() == Gender.MAN).
                mapToInt(Student::getAge).average().getAsDouble();
        System.out.println("средний возраст студентов мужского пола - " + Math.floor(age));

        List<Student> army = students.stream().filter((s) -> s.getAge() >= 18 && s.getAge() < 27 && s.getGender() == Gender.MAN).
                collect(Collectors.toList());

        System.out.println(army.get(0) + " получит повестку");

    }
}
