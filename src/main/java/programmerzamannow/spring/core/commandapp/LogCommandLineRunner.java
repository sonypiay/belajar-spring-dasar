package programmerzamannow.spring.core.commandapp;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class LogCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(LogCommandLineRunner.class);

    @Override
    public void run(String... args) throws Exception {
        log.info("Log command runner : {}", Arrays.toString(args));
    }
}
