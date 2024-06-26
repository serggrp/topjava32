package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.Collection;

import static ru.javawebinar.topjava.util.ValidationUtil.assureIdConsistent;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNew;

@Controller
public class MealRestController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService service;

    public Collection<MealTo> getAll() {
        log.info("getAll");
        return MealsUtil.getTos(service.getAll(), MealsUtil.DEFAULT_CALORIES_PER_DAY);
    }

    public Meal get(int userId, int id) {
        log.info("get {}", id);
        return service.get(userId, id);
    }

    public MealTo create(int userId, Meal meal) {
        log.info("create {}", meal);
        checkNew(meal);
        return convertMeal(service.create(userId, meal));
    }

    public void delete(int userId, int id) {
        log.info("delete {}", id);
        service.delete(userId, id);
    }

    public void update(int userId, Meal meal, int id) {
        log.info("update {} with id={}", meal, id);
        assureIdConsistent(meal, id);
        service.update(userId, meal);
    }

    private MealTo convertMeal(Meal meal){
        return new MealTo(meal.getId(), meal.getDateTime(), meal.getDescription(), meal.getCalories(), meal.getCalories() > MealsUtil.DEFAULT_CALORIES_PER_DAY);
    }

}