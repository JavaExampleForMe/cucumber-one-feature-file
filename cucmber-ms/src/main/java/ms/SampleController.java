package ms;

import core.CoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("Controller")
public class SampleController {
    @Autowired
    private CoreService coreService;

    @GetMapping("IsAlive")
    public boolean isAlive() {
        return coreService.isAlive();
    }

    @GetMapping("PrintSomething")
    public String printSomthing() {
        return coreService.printSomething();
    }
}
