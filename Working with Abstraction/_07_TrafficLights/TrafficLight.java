package com.company._07_TrafficLights;

public class TrafficLight {
    enum Signal {
        RED,
        GREEN,
        YELLOW;
    }

    private Signal signal;

    TrafficLight(Signal signal) {
        this.signal = signal;
    }

    public void update() {
        switch (this.signal) {
            case RED:
                this.signal = Signal.GREEN;
                break;
            case GREEN:
                this.signal = Signal.YELLOW;
                break;
            case YELLOW:
                this.signal = Signal.RED;
                break;
        }
    }

    public Signal getSignal() {
        return signal;
    }
}
