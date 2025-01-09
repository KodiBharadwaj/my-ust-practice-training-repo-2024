package com.ust.traineeapp;

import com.ust.traineeapp.configuration.TraineeAppConfig;
import com.ust.traineeapp.repository.TraineeRepository;
import com.ust.traineeapp.repository.TraineeRepositoryImpl;
import com.ust.traineeapp.service.TraineeService;
import com.ust.traineeapp.service.TraineeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {


//        TraineeRepository repository = new TraineeRepositoryImpl();

        //Trainee trainee = new Trainee(1,"Gautham","Bengaluru", LocalDate.of(2024,8,11));
        //Trainee trainee = new Trainee(2,"Kodi","srikakulam", LocalDate.of(2024,7,10));
        //Trainee trainee = new Trainee(3,"Bharadwaj","andhra pradesh", LocalDate.of(2023,8,9));
        //repository.save(trainee);

//        repository.getAllTrainees().forEach(t-> System.out.println(t));

//        System.out.println(repository.getTrainee(1));

//        repository.save(trainee);

        ApplicationContext context = new AnnotationConfigApplicationContext(TraineeAppConfig.class);
        TraineeService service = context.getBean(TraineeServiceImpl.class);
        service.getAllTrainees().forEach(i-> System.out.println(i));

    }
}