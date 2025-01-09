package com.ust.webapp.service;

import com.ust.webapp.dto.TraineeDto;
import com.ust.webapp.model.Trainee;
import com.ust.webapp.repository.TraineeRepo;
import com.ust.webapp.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeServiceImpl implements TraineeService{

    @Autowired
    private TraineeRepo traineeRepo;

    @Override
    public TraineeDto save(TraineeDto trainee) {
        Trainee obj1 = EntityDtoUtil.convertToEntity(trainee);
        Trainee obj2 = traineeRepo.save(obj1);
        return EntityDtoUtil.convertToDto(obj2);
    }

    @Override
    public List<TraineeDto> getAllTrainees() {
        return traineeRepo.getAllTrainees().stream().map(i->EntityDtoUtil.convertToDto(i)).toList();
    }


    @Override
    public TraineeDto getTraineeById(int id) {
        return traineeRepo.getTraineeById(id).map(i->EntityDtoUtil.convertToDto(i)).orElse(null);
    }

    @Override
    public TraineeDto getTraineeByName(String name) {
        return traineeRepo.getTraineeByName(name).map(i->EntityDtoUtil.convertToDto(i)).orElse(null);
    }

    @Override
    public void deleteTraineeById(int id) {
        traineeRepo.deleteTraineeById(id);
    }

    @Override
    public TraineeDto updateTrainee(int id, TraineeDto trainee) {
        Trainee obj3 = EntityDtoUtil.convertToEntity(trainee);
        Trainee obj4 = traineeRepo.updateTrainee(id, obj3);
        return EntityDtoUtil.convertToDto(obj4);
    }

}
