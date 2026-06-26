package com.in28minutes.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Component
public class UserDaoService {
    // Database - H2/Hibernate
    // Static List - UserDaoService

    private static List<User> users = new ArrayList<>();

    private static int count = 0;

    static {
        users.add(new User(++count, "Rohan", LocalDate.now().minusYears(20)));
        users.add(new User(++count, "Ritika", LocalDate.now().minusYears(20)));
        users.add(new User(++count, "pranav", LocalDate.now().minusYears(30)));
    }

    public List<User> findALl(){
        return users;
    }

    public User save(User user){
        user.setId(++count);
        users.add(user);
        return user;
    }

    public User findOne(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return (User) users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User DeleteById(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
        return null;
    }

}
