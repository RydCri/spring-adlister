package zenith.adlister_spring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zenith.adlister_spring.models.Ad;
import zenith.adlister_spring.repositories.AdRepository;
import zenith.adlister_spring.repositories.UserRepository;

import java.util.List;

@Controller
public class AdController {
    private final AdRepository adsDao;
    private final UserRepository usersDao;
    public AdController(AdRepository adsDao, UserRepository usersDao)
    {
        this.usersDao = usersDao;
        this.adsDao = adsDao;
    }

    @GetMapping("/ads")
    public String adsIndex(Model model) {
        List<Ad> ads = adsDao.findAll();
        model.addAttribute("Modelads", ads);
        return "ads/index";
    }
    @GetMapping("/ads/post")
    public String adsGetPost() {
        return "ads/create";
    }

    @PostMapping("/ads/post")
    public String adsPost(@RequestParam String title, @RequestParam String description) {
        Ad newAd = new Ad(title, description);
        adsDao.save(newAd);

        return "redirect:/ads";
    }



}
