package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealService {

    private MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }
    public Meal create(int userId, Meal meal) {
        return repository.save(userId, meal);
    }
    public void update(int userId, Meal meal) {
        checkNotFoundWithId(repository.save(userId, meal), meal.getId());
    }
    public Meal save(int userId, Meal meal){
        Meal result = repository.save(userId, meal);
        if (result == null)
            throw new NotFoundException("еда не принадлежит пользователю");
        return result;
    }

    public boolean delete(int userId, int id){
        return repository.delete(userId, id);
    }

    public Meal get(int userId, int id){
        Meal result = repository.get(userId, id);
        if (result == null)
            throw new NotFoundException("еда не принадлежит пользователю");
        return result;
    }

    public Collection<Meal> getAll(){
        return repository.getAll();
    }

}