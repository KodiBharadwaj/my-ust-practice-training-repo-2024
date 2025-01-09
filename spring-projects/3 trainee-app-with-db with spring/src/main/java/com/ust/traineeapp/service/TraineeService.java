package com.ust.traineeapp.service;

import com.ust.traineeapp.model.Trainee;

import java.util.List;

public interface TraineeService {
    public Trainee saveTrainee(Trainee trainee);

    public List<Trainee> getAllTrainees();

    public Trainee getTraineeById(int id);

    public void deleteTrainee(int id);
}
