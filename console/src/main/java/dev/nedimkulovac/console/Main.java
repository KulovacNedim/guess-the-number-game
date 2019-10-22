package dev.nedimkulovac.console;

import dev.nedimkulovac.AppConfig;
import dev.nedimkulovac.MessageGenerator;
import dev.nedimkulovac.NumberGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {
    //private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        // create context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //get number generator bean from contect (container)
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        // call method next() to get random number
        int number = numberGenerator.next();

        // log generator number
        log.info("number = {}", number);

        // get message generator bean from context (container)
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("getMainMessage = {}", messageGenerator.getMainMessage());
        log.info("getResultMessage = {}", messageGenerator.getResultMessage());

        // close context (container)
        context.close();
    }
}
