package ajurakudroot.sucklet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NutletController {
    @GetMapping("/")
    public String cock() {
        return "<img src=\"https://pbs.twimg.com/profile_images/1004740774951575554/LcUfSGOj_400x400.jpg\"/>";
    }
}
