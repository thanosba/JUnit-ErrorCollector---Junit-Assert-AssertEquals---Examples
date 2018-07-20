package Junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.concurrent.atomic.AtomicReference;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(JunitTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Results=="+result.wasSuccessful());

        AtomicReference<Result> result2;
        result2 = new AtomicReference<Result>(JUnitCore.runClasses(ErrorCollectorExample.class));
        for (Failure failure : result2.get().getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Result2=="+result.wasSuccessful());
    }
}