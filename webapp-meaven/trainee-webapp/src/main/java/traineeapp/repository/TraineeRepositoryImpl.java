package traineeapp.repository;

import traineeapp.model.Trainee;


import java.util.ArrayList;
import java.util.List;

public class TraineeRepositoryImpl implements TraineeRepository {

    List<Trainee> trainees = new ArrayList<>();

    public Trainee save(Trainee trainee) {

        trainees.add(trainee);
        return trainee;
    }

    public Trainee getTrainee(int id) {

        return trainees.stream().filter(trainee -> trainee.id() == id).findFirst().orElse(null);


    }

    public List<Trainee> getAllTrainees() {

        return trainees;
    }

    public void deleteTrainee(int id) {

    }


}
