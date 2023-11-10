package net.coinpurse.api.coinpurseapi.tests;

import org.springframework.stereotype.Service;

@Service
public class TestService {
    public String checkHealth() {
        return "OK";
    }
}
