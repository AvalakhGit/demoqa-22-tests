package examples;

import org.junit.jupiter.api.*;

public class JUnit5TestExamples {
    @BeforeAll
    static void setUP(){
        System.out.println("-Setup");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("--before each");
    }
    @Test
    public void FirstTest(){

        System.out.println("----1 test");
    }

    @Test
    public void SecondTest(){
        System.out.println("----2 test");
    }

    @AfterEach
    void afterEach(){
        System.out.println("--after each");
    }
    @AfterAll
    static void tearDown(){
        System.out.println("-TearDown");
    }
}
