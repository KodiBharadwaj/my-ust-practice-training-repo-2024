package com.springapp.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Network {
    @Value("${network.available}")
    private boolean available;

    public Network(boolean available) {
        this.available = available;
    }
    public Network() {
    }

    public boolean isAvailable() {
        return available;
    }
}
