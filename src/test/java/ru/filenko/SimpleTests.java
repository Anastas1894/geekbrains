package ru.filenko;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleTests {

    static final Logger log = LoggerFactory.getLogger(Test.class);

        @Test
        public void myTest(int a, int b) {
            log.info("\t\t\tSTART WORK TEST");
            //System.out.println("Test start");
            int s_result = Main.square(5, 6);
            Assertions.assertEquals((a * b) / 2, s_result);
            log.info("\t\t\tEND WORK TEST");
            //System.out.println("Test finish");


        }
    }


