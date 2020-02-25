package com.kafkaApp;

import com.kafkaApp.debug.DebugProducer;

public class Main {

    public static void main(String[] args) {
        //TwitterProducer twitterProducer = new TwitterProducer();
        //twitterProducer.run();
        DebugProducer debugProducer = new DebugProducer();
        debugProducer.run();
    }
}