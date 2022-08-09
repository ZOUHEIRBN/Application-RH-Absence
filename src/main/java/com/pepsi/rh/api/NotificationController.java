package com.pepsi.rh.api;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins = "*", allowedHeaders = "*")
// @RestController
// @RequestMapping("n")
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate template;

    private Notification notification;

    public NotificationController(String title, String text) {
        this.notification = new Notification(title, text);
    }


    // @GetMapping("/")
    public String getTestNotification() {

        // Increment Notification by one
        Notification notification = new Notification("Test notification", "Lorem ipsum dolor sit amet");

        // Push notifications to front-end
        template.convertAndSend("/topic/notification", notification);

        return "Notifications successfully sent to Angular !";
    }
    public String sendNotification() {

        
        // Push notifications to front-end
        template.convertAndSend("/topic/notification", this.notification);

        return notification.getText();
    }
    
}