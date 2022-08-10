package com.controller;

import com.service.AchievementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/achievement")
public class AchievementController {

    private final AchievementService achievementService;

    public AchievementController(AchievementService achievementService){
        this.achievementService = achievementService;
    }

    @PostMapping("logAchievement")
    public ResponseEntity<Object> logAchievement(@RequestParam("username") String username,
                                                 @RequestParam("achievement") String achievement) {
        System.out.println("logAchievement : ");
        System.out.println("username : " + username);
        System.out.println("achievement : " + achievement);
        Object result = achievementService.logAchievement(username, achievement);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("getUserAchievements")
    public ResponseEntity<Object> getUserAchievements(@RequestParam("username") String username) {
        System.out.println("getUserAchievements : ");
        System.out.println("username : " + username);
        Object result = achievementService.getUserAchievements(username);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
