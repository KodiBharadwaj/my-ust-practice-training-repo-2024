package com.ust.webapp.controller;

import com.ust.webapp.dto.TraineeDto;
import com.ust.webapp.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trainees")
public class TraineeRestController {

    @Autowired
    private TraineeService traineeService;



//    @GetMapping("/{id}")
//    @ResponseStatus(code = HttpStatus.OK)
//    public Trainee getTrainee(@PathVariable("id") int id){
//        return traineeService.getTraineeById(id);
//    }
    @GetMapping("/{id}")
    //@ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<TraineeDto> getTrainee(@PathVariable("id") int id){
        TraineeDto gotTrainee = traineeService.getTraineeById(id);
        if(gotTrainee != null){
            return ResponseEntity.status(HttpStatus.OK).body(gotTrainee); // 200 ok
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(gotTrainee); // 404 Not Found
        }
    }






//    @GetMapping("/search")
//    @ResponseStatus(code = HttpStatus.OK)
//    public Trainee getTraineeByName(@RequestParam("name") String name){
//        return traineeService.getTraineeByName(name);
//    }
    @GetMapping("/search")
    //@ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<TraineeDto> getTraineeByName(@RequestParam("name") String name){
        TraineeDto nameTrainee = traineeService.getTraineeByName(name);
        if(nameTrainee != null){
            return ResponseEntity.status(HttpStatus.OK).body(nameTrainee); // 200 ok
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(nameTrainee); // 404 Not Found
        }
    }






//    @GetMapping
//    @ResponseStatus(code = HttpStatus.OK)
//    public List<Trainee> getAllTrainees(){
//        return traineeService.getAllTrainees();
//    }
    @GetMapping
    //@ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<TraineeDto>> getAllTrainees(){
        List<TraineeDto> listTrainees = traineeService.getAllTrainees();
        if(!listTrainees.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(listTrainees); // 200 ok
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listTrainees); // 404 Not Found
        }
    }







//    @PostMapping
//    @ResponseStatus(code = HttpStatus.CREATED)
//    public Trainee saveTrainee(@RequestBody Trainee trainee){
//        return traineeService.save(trainee);
//    }
    @PostMapping
    //@ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<TraineeDto> saveTrainee(@RequestBody TraineeDto trainee){

        if(traineeService.getTraineeById(trainee.id()) == null) {
            TraineeDto savedTrainee = traineeService.save(trainee);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedTrainee); // 201 created
        }
        else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null); // 409 Conflict
        }
    }






//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteTrainee(@PathVariable("id") int id){
//        traineeService.deleteTraineeById(id);
//    }
    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity deleteTrainee(@PathVariable("id") int id){
        if(traineeService.getTraineeById(id)!=null){
            traineeService.deleteTraineeById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null); // 204 No-Content
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 404 Not Found
        }
    }







//    @PutMapping("/{id}")
//    @ResponseStatus(code = HttpStatus.ACCEPTED)
//    public Trainee updateTrainee(@PathVariable("id") int id, @RequestBody Trainee trainee){
//        return traineeService.updateTrainee(id, trainee);
//    }

    @PutMapping("/{id}")
    //@ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResponseEntity<TraineeDto> updateTrainee(@PathVariable("id") int id, @RequestBody TraineeDto trainee){
        TraineeDto updatedTrainee = null;
        if(traineeService.getTraineeById(id) != null){
            updatedTrainee = traineeService.updateTrainee(id, trainee);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedTrainee); // 202 Accepted
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(updatedTrainee); // 404 Not Found
        }
    }

}
