package tests.unittests.base;

import org.testng.annotations.Test;


public class TestTimeout {
    @Test(timeOut = 500)
    public void timeTestOne() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Time test method one");
    }

    @Test(timeOut = 500)
    public void timeTestTwo() throws InterruptedException {
        Thread.sleep(400);
        System.out.println("Time test method two");
    }
}







//public class TestTimeout {
//    @Test
//    public void testParallel1() {checkTime();
//        sleep(2);
//    }
//    @Test
//    public void testParallel2() {checkTime();
//        sleep(2);
//    }
//
//    private void checkTime() {
//        System.out.println("Current time: " + new Date(System.currentTimeMillis()));
//    }
//}
