package com.yet.spring.core;


import com.yet.spring.core.beans.Client;
import com.yet.spring.core.loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private static EventLogger eventLogger;

    public App(Client client, EventLogger consoleEventLogger) {
        this.client = client;
        this.eventLogger = consoleEventLogger;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");
//        App app = new App();
//        app.client = new Client("1", "First");
//        eventLogger = new ConsoleEventLogger();
        app.logEvent("Some event for user 1");
    }

    public void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(),client.getFullName());
        eventLogger.logEvent(message);
    }
}
