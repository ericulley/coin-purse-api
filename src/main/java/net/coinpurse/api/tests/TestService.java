package net.coinpurse.api.tests;

import org.springframework.stereotype.Service;

@Service
public class TestService {
    public String checkHealth() {
        return "OK";
    }
}
