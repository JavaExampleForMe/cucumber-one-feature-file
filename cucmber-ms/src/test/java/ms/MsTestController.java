package ms;

import core.CoreTestContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class MsTestController {
    private CoreTestContext testContext;

    public MsTestController(CoreTestContext retentionService) {
        this.testContext = retentionService;
    }

}
