package com.controller;

import com.model.UserEvent;
import com.service.UserEventService;
import org.bson.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/user/event")
public class UserEventController {

    private final UserEventService userEventService;

    public UserEventController(UserEventService userEventService){
        this.userEventService = userEventService;
    }

    /**
     * Student Event Log
     * @return Response
     */
    @PostMapping("logUserEvent")
    public ResponseEntity<Object> logUserEvent(HttpServletRequest request,
                                                  @RequestParam("username") String username,
                                                  @RequestParam("eventName") String eventName,
                                                  @RequestParam("eventContent") String eventContent) {
        System.out.println("logUserEvent : ");
        // System.out.println("username : " + username);
        System.out.println( eventName + ": " + eventContent);   
        System.out.println("------------------------------------");                            
        Object result = userEventService.logUserEvent(request, username, eventName, eventContent);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Get student Event
     * @return Response
     */
    @GetMapping("getUserEvents")
    public ResponseEntity<Object> getUserEvents(@RequestParam("username") String username) {
        System.out.println("getUserEvents : ");
        System.out.println("username : " + username);
        Object result = userEventService.getUserEvents(username);
        
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Get student Event
     * @return Response
     */
    @GetMapping("getUserEventsFilterLevelPassed")
    public ResponseEntity<Object> getUserEventsFilterLevelPassed(@RequestParam("username") String username) {
        System.out.println("getUserEventsFilterLevelPassed : ");
        // System.out.println("username : " + username);
        List<UserEvent> result = userEventService.getUserEventsFilterLevelPassed(username);
        // List getLevelData = new ArrayList();
        // result.forEach((resultObj)->{
        //     Document eventContent = resultObj.getEventContent();
        //     getLevelData.add(eventContent.get("level"));
        // });
        // System.out.println("getLevelData: " + getLevelData);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    /**
     * Get student Event
     * @return Response
     */
    @GetMapping("getUserEventFilterConsoleInput")
    public ResponseEntity<Object> getUserEventFilterConsoleInput(@RequestParam("username") String username) {
        System.out.println("getUserEventFilterConsoleInput : ");
        // System.out.println("username : " + username);
        List<UserEvent> result = userEventService.getUserEventFilterConsoleInput(username);
        List getLevelData = new ArrayList();
        result.forEach((resultObj)->{
            Document eventContent = resultObj.getEventContent();
            getLevelData.add(eventContent.get("input"));
        });
        System.out.println("getLevelData: " + getLevelData);
        return new ResponseEntity<>(getLevelData, HttpStatus.OK);
    }
}
