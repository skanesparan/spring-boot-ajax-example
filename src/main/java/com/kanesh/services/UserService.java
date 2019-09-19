package com.kanesh.services;

import org.springframework.stereotype.Service;

import com.kanesh.model.User;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private List<User> users;

    // Love Java 8
    public List<User> findByUserNameOrEmail(String username) {

        List<User> result = users.stream().filter(x -> x.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList());

        return result;

    }
    /*public List<User> findByUserNameOrEmail(String username, String email) {

        List<User> result = new ArrayList<User>();

        for (User user : users) {

            if ((!StringUtils.isEmpty(username)) && (!StringUtils.isEmpty(email))) {

                if (username.equals(user.getUsername()) && email.equals(user.getEmail())) {
                    result.add(user);
                    continue;
                } else {
                    continue;
                }

            }
            if (!StringUtils.isEmpty(username)) {
                if (username.equals(user.getUsername())) {
                    result.add(user);
                    continue;
                }
            }

            if (!StringUtils.isEmpty(email)) {
                if (email.equals(user.getEmail())) {
                    result.add(user);
                    continue;
                }
            }

        }

        return result;

    }*/

    // Init some users for testing
    @PostConstruct
    private void iniDataForTesting() {

        users = new ArrayList<User>();

        User user1 = new User("kanesh", "password111", "kanesh@yahoo.com");
        User user2 = new User("smith", "password222", "smith@yahoo.com");
        User user3 = new User("paran", "password333", "paran@yahoo.com");
        User user4 = new User("Lamsith", "password333", "lamsith@yahoo.com");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

    }

}
