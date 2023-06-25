import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("John", "Smith", 25));
        userList.add(new User("Alice", "Cooper", 30));
        userList.add(new User("Iga", "Swiatek", 22));
        userList.add(new User("Adam", "Sandler", 56));
        userList.add(new User("David", "Guetta", 55));
        userList.add(new User("Ridley", "Scott", 85));
        userList.add(new User("Olivia", "Wilde", 39));
        userList.add(new User("Amy", "Adams", 48));
        userList.add(new User("Mark", "Allen", 37));
        userList.add(new User("Avril", "Lavigne", 38));


        // Sort by age, record to new collection
        List<User> sortedByAge = userList.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());

        // Average users age
        double averageAge = userList.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0.0);

        // Sort by first name and age
        List<User> sortedByFirstNameAndAge = userList.stream()
                .sorted(Comparator.comparing(User::getFirstName).thenComparingInt(User::getAge))
                .collect(Collectors.toList());

        // Users with S or A
        boolean hasUsersWithSOrA = userList.stream()
                .anyMatch(user -> user.getSecondName().startsWith("S") || user.getSecondName().startsWith("A"));

        // Users over 18
        boolean usersOver18 = userList.stream()
                .allMatch(user -> user.getAge() > 18);

        // Output
        System.out.println("--- Sorted by age: ---");
        for(User item : sortedByAge) {
            System.out.println(item.getFirstName() + " " + item.getSecondName() + " " + item.getAge());
        }
        System.out.println();
        System.out.println("--- Average age: ---\n"  + averageAge);
        System.out.println();
        System.out.println("--- Sorted by first name and age: ---");
        for(User item : sortedByFirstNameAndAge) {
            System.out.println(item.getFirstName() + " " + item.getAge());
        }
        System.out.println();
        System.out.println("--- Users with S or A: ---\n" + hasUsersWithSOrA);
        System.out.println();
        System.out.println("--- Users over 18: ---\n" + usersOver18);

    }
}