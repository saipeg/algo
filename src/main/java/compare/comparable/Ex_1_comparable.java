package compare.comparable;

import java.util.Comparator;
import java.util.List;

public class Ex_1_comparable {
    public static void main(String[] args) {

        List<Person> people = List.of(new Person("Petr", 23),
                new Person("Zetr", 23),
                new Person("Aetr", 23),
                new Person("Abtr", 23));

        people.stream().
                min(Comparator.naturalOrder())
                .ifPresentOrElse(
                        p -> System.out.println("person = " + p),
                        () -> System.out.println("не найден"));
    }
}

record Person(String name, int age) implements Comparable<Person> {

    @Override
    public int compareTo(final Person other) {
        System.out.println("Сравниваю - - - >  ");
        return this.name.compareTo(other.name);
    }
}


