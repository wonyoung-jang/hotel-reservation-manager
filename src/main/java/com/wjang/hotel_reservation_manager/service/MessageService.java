package com.wjang.hotel_reservation_manager.service;

import org.springframework.stereotype.Service;

import java.util.ResourceBundle;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class MessageService {

    private static final ResourceBundle enBundle = ResourceBundle.getBundle("welcome_en_US");
    private static final ResourceBundle frBundle = ResourceBundle.getBundle("welcome_fr_CA");

    public String[] getMessages() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Fetch messages using threads
        Future<String[]> enMessagesFuture = executorService.submit(getMessageTask(enBundle));
        Future<String[]> frMessagesFuture = executorService.submit(getMessageTask(frBundle));

        try {
            // Get results from threads
            String[] enMessages = enMessagesFuture.get();
            String[] frMessages = frMessagesFuture.get();

            // Combine messages into a single array
            return new String[]{enMessages[1], frMessages[1]}; // Assuming index 1 has the 'welcome' message
        } catch (Exception e) {
            e.printStackTrace();
            return new String[]{"Error fetching messages", "Erreur lors de la récupération des messages"};
        } finally {
            executorService.shutdown();
        }
    }

    private Callable<String[]> getMessageTask(ResourceBundle bundle) {
        return () -> new String[]{bundle.getString("hello"), bundle.getString("welcome")};
    }
}
