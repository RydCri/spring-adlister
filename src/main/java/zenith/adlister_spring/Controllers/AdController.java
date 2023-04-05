package zenith.adlister_spring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import zenith.adlister_spring.models.Ad;
import zenith.adlister_spring.models.Tag;
import zenith.adlister_spring.models.Tags;
import zenith.adlister_spring.repositories.AdRepository;
import zenith.adlister_spring.repositories.TagRepository;
import zenith.adlister_spring.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class AdController {
    private final AdRepository adsDao;
    private final UserRepository usersDao;
    private final TagRepository tagsDao;
    public AdController(AdRepository adsDao, UserRepository usersDao, TagRepository tagsDao)
    {
        this.usersDao = usersDao;
        this.adsDao = adsDao;
        this.tagsDao = tagsDao;
    }

    @GetMapping("/ads")
    public String adsIndex(Model model) {
        List<Ad> ads = adsDao.findAll();
        model.addAttribute("Modelads", ads);
        return "ads/index";
    }
    @GetMapping("/ads/create")
    public String adsGetPost() {
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public String adsPost(@RequestParam String title, @RequestParam String description,@RequestParam(name="tags")String tags) {
        Set<Tag> tagset = Tags.makeTagSet(tags);
        Ad newAd = new Ad(title, description);
        if (tagset.size() > 0){
            List<Tag> tagsToAdd = new ArrayList<>();
            for(Tag tag : tagset){
                Tag tagFromDb = tagsDao.findTagByName(tag.getName());
                if(tagFromDb == null){
                    tagsToAdd.add(tagsDao.save(tag));
                }else {
                    tagsToAdd.add(tagFromDb);
                }
            }
            tagset.clear();
            tagset.addAll(tagsToAdd);
            newAd.setTags(tagset);
        }
        adsDao.save(newAd);

        return "redirect:/ads";
    }
@GetMapping("/ads/{n}")
    public String thisAd(@PathVariable long n,Model model){
        List<Ad> ads = adsDao.findAll();
        model.addAttribute("modelID",n);
        model.addAttribute("ads",ads);
        return "ads/show";
}

}
