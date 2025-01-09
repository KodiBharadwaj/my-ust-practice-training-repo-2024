package com.ust.webapp.util;

import com.ust.webapp.dto.TraineeDto;
import com.ust.webapp.model.Trainee;

public class EntityDtoUtil {
    public static TraineeDto convertToDto(Trainee trainee){
        TraineeDto traineeDto = new TraineeDto(trainee.getId(), trainee.getName(), trainee.getLocation());
        return traineeDto;
    }

    public static Trainee convertToEntity(TraineeDto traineeDto){
        Trainee trainee = new Trainee(traineeDto.id(), traineeDto.name(), traineeDto.location());
        return trainee;
    }
}
