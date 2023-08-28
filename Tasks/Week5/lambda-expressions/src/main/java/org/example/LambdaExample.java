package org.example;

import java.util.Comparator;
import java.util.function.Predicate;


public class LambdaExample {
    public static void main(final String[] args) {

        final UsersRepository repository = new UsersRepository();

        banner("Listing all users");
        repository.select(null, null);

        banner("Listing users with age > 5 sorted by name");
        // TODO once using anonymous objects and once using lambda expressions

        // using anonymous objects
        repository.select(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.age > 5;
            }
        }, new Comparator<User>(){
            public int compare(User u1, User u2) {
                return u1.name.compareTo(u2.name);
            }
        });

        // using lambda expressions
        repository.select(user -> user.age > 5,
                Comparator.comparing(user -> user.name)
        );

        banner("Listing users with age < 10 sorted by age");
        // TODO once using anonymous objects and once using lambda expressions

        // using anonymous objects
        repository.select(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.age < 10;
            }
        }, new Comparator<User>(){
            public int compare(User u1, User u2) {
                if (u1.age > u2.age) return 1;
                else if (u1.age == u2.age) return 0;
                return -1;
            }
        });

        // using lambda expressions
        repository.select(user -> user.age < 10,
                Comparator.comparing(user -> user.age)
        );

        banner("Listing active users sorted by name");
        // TODO once using anonymous objects and once using lambda expressions

        // using anonymous objects
        repository.select(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.active;
            }
        }, new Comparator<User>(){
            public int compare(User u1, User u2) {
                return u1.name.compareTo(u2.name);
            }
        });

        // using lambda expressions
        repository.select(user -> user.active,
                Comparator.comparing(user -> user.name)
        );

        banner("Listing active users with age > 8 sorted by name");
        // TODO once using anonymous objects and once using lambda expressions

        // using anonymous objects
        repository.select(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.active && user.age > 8;
            }
        }, new Comparator<User>(){
            public int compare(User u1, User u2) {
                return u1.name.compareTo(u2.name);
            }
        });

        // using lambda expressions
        repository.select(user -> user.active && user.age > 8,
                Comparator.comparing(user -> user.name)
        );
    }

    private static void banner(final String m) {
        System.out.println("\n#### " + m + " ####");
    }
}

