package org.example.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Phone {

    @Autowired
    private Sim sim;

    public Phone() {
    }

    public Phone(Sim sim) {
        this.sim = sim;
    }

    public void call(String phnNo){
        sim.call(phnNo);
    }

    public void sendText(String phnNo, String message){
        sim.sendText(phnNo, message);
    }
}
