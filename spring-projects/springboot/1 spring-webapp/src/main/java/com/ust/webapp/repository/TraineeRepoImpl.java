package com.ust.webapp.repository;

import com.ust.webapp.model.Trainee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TraineeRepoImpl implements TraineeRepo{
    List<Trainee> list;

    @PostConstruct
    void init(){
        list = new ArrayList<>();
        Trainee t1 = new Trainee(1, "Kodi", "Sklm");
        Trainee t2 = new Trainee(2, "Bharadwaj", "AP");
        list.add(t1);
        list.add(t2);
    }

    public Trainee save(Trainee trainee){
        list.add(trainee);
        System.out.println(trainee);
        return trainee;
    }

    @Override
    public List<Trainee> getAllTrainees() {
        return list;
    }

    @Override
    public Optional<Trainee> getTraineeById(int id) {
        return list.stream().filter(i->i.getId() == id).findFirst();
    }

    @Override
    public Optional<Trainee> getTraineeByName(String name) {
        return list.stream().filter(i->i.getName().toLowerCase().contains(name.toLowerCase())).findFirst();
    }

    @Override
    public void deleteTraineeById(int id) {
        list.removeIf(i->i.getId() == id);
    }

    @Override
    public Trainee updateTrainee(int id, Trainee trainee) {
        deleteTraineeById(id);
        Trainee trainee1 = new Trainee(id, trainee.getName(), trainee.getLocation());
        return save(trainee1);
    }

}
