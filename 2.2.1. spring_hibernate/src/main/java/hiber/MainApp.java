package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car1 = new Car("Toyota", 100);
        Car car2 = new Car("Lada", 2110);
        Car car3 = new Car("Ford", 3);
        Car car4 = new Car("Mercedes", 200);

        User user1 = new User("Dimon", "Balkonsky", "Dimon@mail.ru");
        User user2 = new User("Jeka", "Savelsky", "Jeka@mail.ru");
        User user3 = new User("Olya", "Balkonsky1", "Olya@mail.ru");
        User user4 = new User("Pechenka", "Drobilka", "Pechenka@mail.ru");

        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);
        user4.setCar(car4);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }


        context.close();
    }
}