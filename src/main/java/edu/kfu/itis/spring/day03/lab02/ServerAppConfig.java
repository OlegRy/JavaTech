package edu.kfu.itis.spring.day03.lab02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class ServerAppConfig {

    @Bean
    public Greeter greeter() {
        return new GreeterImpl();
    }

    @Bean
    public RmiServiceExporter rmiServiceExporter() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(greeter());
        rmiServiceExporter.setServiceName("Greeter");
        rmiServiceExporter.setServiceInterface(Greeter.class);
        return rmiServiceExporter;
    }
}
