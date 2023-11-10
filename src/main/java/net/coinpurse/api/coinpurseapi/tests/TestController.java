package net.coinpurse.api.coinpurseapi.tests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/test")
@CrossOrigin
public class TestController {

    @Autowired
    public TestService testService;

    @GetMapping
    public ResponseEntity<String> getHealth() {
        return new ResponseEntity<String>(testService.checkHealth(), HttpStatus.OK);
    }
}
