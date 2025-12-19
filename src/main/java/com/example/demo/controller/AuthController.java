@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AppUserService service;

    public AuthController(AppUserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public String register(@RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String role) {
        return service.register(email, password, role);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password) {
        return service.login(email, password);
    }
}
