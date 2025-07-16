package StreamsPractice;

import java.util.stream.Stream;

public class StreamExercise1 {
    public static void main(String[] args) {
        // print all number in intNumberStreem
        StreamSources.intNumberStream().forEach(e -> System.out.println(e));
        System.out.println("----------------------");

        //print number from intNumberStream that is less than equal to 6
        StreamSources.intNumberStream().filter(x-> x <=6).forEach(System.out::println);
        System.out.println("----------------------");

        //print second and third number from intNumberStream that is greater than to 5
        StreamSources.intNumberStream().filter(x-> x>5)
                .skip(1)
                .limit(2)
                .forEach(x-> System.out.println(x));
        System.out.println("----------------------");

        // print the first number from intNumberStream that is greater than 5
        // if nothing is found print -1
        Integer result1 = StreamSources.intNumberStream().filter(x -> x > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(result1);
        System.out.println("----------------------");

        // print the first name of all the users from userStream 1) print directly 2) use map to get firstname then print
        StreamSources.userStream().forEach(user -> System.out.println(user.getFname()));
        System.out.println("----------------------");
        StreamSources.userStream().map(user ->user.getFname()).forEach(fname -> System.out.println(fname));
        System.out.println("----------------------");

        //print first name from user stream for the users that has id in intNumberStream
        StreamSources.intNumberStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(user -> user.getFname())
                .forEach(firstname -> System.out.println(firstname));
        System.out.println("----------------------");

        // another way to match it.  Filter will return the user.
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumberStream().anyMatch(id-> id ==user.getId()))
                .forEach(user-> System.out.println(user.getFname()));
        System.out.println("----------------------");


    }
}
