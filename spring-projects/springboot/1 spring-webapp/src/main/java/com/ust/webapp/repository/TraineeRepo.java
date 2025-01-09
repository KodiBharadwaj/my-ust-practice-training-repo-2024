package com.ust.webapp.repository;

import com.ust.webapp.dto.TraineeDto;
import com.ust.webapp.model.Trainee;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface TraineeRepo {
    public Trainee save(Trainee trainee);

    public List<Trainee> getAllTrainees();


    public Optional<Trainee> getTraineeById(int id);

    public Optional<Trainee> getTraineeByName(String name);

    public void deleteTraineeById(int id);

    public Trainee updateTrainee(int id, Trainee trainee);


}
