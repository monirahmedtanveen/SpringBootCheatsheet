package rc.bootsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rc.bootsecurity.db.UserRepository;
import rc.bootsecurity.model.User;

import java.util.List;

@RestController
@RequestMapping("api/public")
@CrossOrigin
public class PublicRestApiController {

    @Autowired
    private UserRepository userRepository;

    // Available to all authenticated users
    @GetMapping("test")
    public String test() {
        return "API Test";
    }

    // Available to ROLE_MANAGER
    @GetMapping("management/reports")
    public String report() {
        return "Some report data";
    }

    // Available to ROLE_ADMIN
    @GetMapping("admin/users")
    public List<User> users() {
        return this.userRepository.findAll();
    }
}
