//package project.CarRental;
//import javax.jms.ConnectionFactory;
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class JmsConfig {
//
//    @Bean
//    public ActiveMQConnectionFactory jmsConnectionFactory() {
//        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
//        connectionFactory.setBrokerURL("tcp://localhost:61616");
//        return connectionFactory;
//    }
//
//    @Bean
//    public JmsTemplate jmsTemplate() {
//        JmsTemplate template = new JmsTemplate();
//        template.setConnectionFactory((ConnectionFactory) jmsConnectionFactory());
//        return template;
//    }
//
//}
//
