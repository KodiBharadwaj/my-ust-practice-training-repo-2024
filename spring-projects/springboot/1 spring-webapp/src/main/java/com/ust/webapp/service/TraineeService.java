package com.ust.webapp.service;

import com.ust.webapp.dto.TraineeDto;
import com.ust.webapp.model.Trainee;

import java.util.List;

public interface TraineeService {

    public TraineeDto save(TraineeDto trainee);

    public List<TraineeDto> getAllTrainees();


    public TraineeDto getTraineeById(int id);

    public TraineeDto getTraineeByName(String name);

    public void deleteTraineeById(int id);

    public TraineeDto updateTrainee(int id, TraineeDto trainee);

}
