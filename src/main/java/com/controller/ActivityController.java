package com.controller;

import com.service.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/activity")
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService){
        this.activityService = activityService;
    }

    @GetMapping("/getUsersInGamePerformance")
    public ResponseEntity<Object> getUsersInGamePerformance() {
        System.out.println("getUsersInGamePerformance");
        return new ResponseEntity<>(activityService.getUsersInGamePerformance(), HttpStatus.OK);
    }

    @GetMapping("/getUserGameTime")
    public ResponseEntity<Object> getUserGameTime(@RequestParam String username){
        System.out.println("getUserGameTime");
        return new ResponseEntity<>(activityService.getUserGameTime(username), HttpStatus.OK);
    }

    @GetMapping("/getAllUserGameTime")
    public ResponseEntity<Object> getAllUserGameTime(){
        System.out.println("getAllUserGameTime");
        return new ResponseEntity<>(activityService.getAllUserGameTime(), HttpStatus.OK);
    }

    @GetMapping("/getLevelPassedTimeCostStatistics")
    public ResponseEntity<Object> getLevelPassedTimeCostStatistics(){
        System.out.println("getLevelPassedTimeCostStatistics");
        return new ResponseEntity<>(activityService.getLevelPassedTimeCostStatistics(), HttpStatus.OK);
    }

    @GetMapping("/getAllUserActivityByDate")
    public ResponseEntity<Object> getAllUserActivityByDate(){
        System.out.println("getAllUserActivityByDate");
        return new ResponseEntity<>(activityService.getAllUserActivityByDate(), HttpStatus.OK);
    }
}
