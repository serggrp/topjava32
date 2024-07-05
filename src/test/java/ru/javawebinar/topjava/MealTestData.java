package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final Meal adminMeal1 = new Meal(null, "Завтрак админа", 500);
    public static final Meal adminMeal2 = new Meal(null, "Обед админа", 1000);
    public static final Meal adminMeal3 = new Meal(null, "Ужин админа", 400);
    public static final Meal adminMeal4 = new Meal(null, "Завтрак админа", 800);
    public static final Meal adminMeal5 = new Meal(null, "Обед админа", 1000);
    public static final Meal adminMeal6 = new Meal(null, "Ужин админа", 1000);

    public static Meal getNew() {
        return new Meal(null, LocalDateTime.now(), "test generated meal", 1001);
    }

//    public static User getUpdated() {
//        User updated = new User(user);
//        updated.setEmail("update@gmail.com");
//        updated.setName("UpdatedName");
//        updated.setCaloriesPerDay(330);
//        updated.setPassword("newPass");
//        updated.setEnabled(false);
//        updated.setRoles(Collections.singletonList(Role.ADMIN));
//        return updated;
//    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).usingRecursiveComparison().ignoringFields("dateTime").isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingRecursiveFieldByFieldElementComparatorIgnoringFields("dateTime","id", "userId").isEqualTo(expected);
    }
}
