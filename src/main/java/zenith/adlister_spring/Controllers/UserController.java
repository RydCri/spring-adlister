package zenith.adlister_spring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zenith.adlister_spring.models.User;
import zenith.adlister_spring.repositories.AdRepository;
import zenith.adlister_spring.repositories.UserRepository;

import java.util.List;

@Controller
public class UserController {
    private final UserRepository usersDao;
    public UserController( UserRepository usersDao) {
        this.usersDao = usersDao;
    }
@GetMapping("/register")
public String getregisterUser() {
    return "ads/register";
}
@GetMapping("/users")
public String usersIndex(Model model){
    List<User> users = usersDao.findAll();
    model.addAttribute("users",users);
return "ads/userads";
}
    @PostMapping("/register")
    public String registerUser(@RequestParam(name="username")String username,@RequestParam(name="email")String email,@RequestParam(name="password")String password){
        User user = new User(username,email,password);
        usersDao.save(user);
        return "redirect:/ads/userads";
    }

    @GetMapping("/user/{id}/ads")
    public String userAds(@PathVariable long id){
    usersDao.findById(id);
    return "ads/index";
    }


}
