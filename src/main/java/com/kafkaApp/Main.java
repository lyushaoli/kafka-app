package com.kafkaApp;

import com.kafkaApp.twitter.TwitterProducer;

public class Main {

    public static void main(String[] args) {

        TwitterProducer twitterProducer = new TwitterProducer();
        twitterProducer.run();
    }
}