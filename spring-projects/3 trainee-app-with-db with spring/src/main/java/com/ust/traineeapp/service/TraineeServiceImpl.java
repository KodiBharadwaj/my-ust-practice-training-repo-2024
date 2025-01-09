package com.ust.traineeapp.service;

import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeServiceImpl implements TraineeService{

    @Autowired
    private TraineeRepository traineeRepository;


    @Override
    public Trainee saveTrainee(Trainee trainee) {
        return traineeRepository.save(trainee);
    }

    @Override
    public List<Trainee> getAllTrainees() {
        return traineeRepository.getAllTrainees();
    }

    @Override
    public Trainee getTraineeById(int id) {
        return traineeRepository.getTrainee(id);
    }

    public void deleteTrainee(int id){
        traineeRepository.deleteTrainee(id);
    }
}
