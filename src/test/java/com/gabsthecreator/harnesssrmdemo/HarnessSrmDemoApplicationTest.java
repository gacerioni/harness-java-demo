package com.gabsthecreator.harnesssrmdemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HarnessSrmDemoApplicationTest {

    @Test
    void main() {
    }

    @Test
    void scheduleFixedDelayTask() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}