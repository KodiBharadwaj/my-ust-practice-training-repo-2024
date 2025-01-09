package com.ust;

import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.repository.TraineeRepositoryImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TraineeRepositoryImplTest {

    private TraineeRepositoryImpl trainee;



    @BeforeEach
    void setup(){
        trainee = new TraineeRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
        trainee = null;
    }

    Trainee traineeObj = new Trainee(1,"Gautham", "Bengaluru", LocalDate.of(2024,8,11));
    @Test
    @EnabledOnJre(JRE.JAVA_21)
    @EnabledOnOs(OS.MAC)
    void save() {
        Assertions.assertEquals(traineeObj, trainee.save(traineeObj));
    }


    @Test
    void getTrainee(){
        Trainee trainee1 = new Trainee(1,"Gautham","Bengaluru", LocalDate.of(2024,8,11));
        Trainee trainee2 = new Trainee(2,"Kodi","srikakulam", LocalDate.of(2024,7,10));
        Trainee trainee3 = new Trainee(3,"Bharadwaj","andhra pradesh", LocalDate.of(2023,8,9));


        Assertions.assertEquals(trainee1.id(),trainee.getTrainee(trainee1.id()).id());
        Assertions.assertEquals(trainee2.id(),trainee.getTrainee(trainee2.id()).id());
        Assertions.assertEquals(trainee3.id(),trainee.getTrainee(trainee3.id()).id());
    }


    @Test
    void getAllTrainees(){
        Trainee trainee1 = new Trainee(1,"Gautham","Bengaluru", LocalDate.of(2024,8,11));
        Trainee trainee2 = new Trainee(2,"Kodi","srikakulam", LocalDate.of(2024,7,10));
        Trainee trainee3 = new Trainee(3,"Bharadwaj","andhra pradesh", LocalDate.of(2023,8,9));
        List<Trainee> list = new ArrayList<>();
        list.add(trainee1);
        list.add(trainee2);
        list.add(trainee3);
        Assertions.assertEquals(list.get(0).id(),trainee.getAllTrainees().get(0).id());
        Assertions.assertEquals(list.get(1).name(),trainee.getAllTrainees().get(1).name());
        Assertions.assertEquals(list.get(2).location(),trainee.getAllTrainees().get(2).location());
    }

    @Test
    void deleteTrainee(){
        trainee.deleteTrainee(1);
        Assertions.assertEquals(2,trainee.getAllTrainees().size());
    }

}
