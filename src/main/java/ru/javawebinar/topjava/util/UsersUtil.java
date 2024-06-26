package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.ArrayList;
import java.util.List;

public class UsersUtil {
    public static final List<User> usersList = new ArrayList<>();
    static{
        usersList.add(new User(null, "Admin", "admin@1.com", "pwd", Role.ADMIN));
        usersList.add(new User(null, "User", "user@1.com", "pwd", Role.USER));
    }

}
