package darian.test;

import java.sql.Timestamp;
import java.util.Date;

public class Test {

    @org.junit.Test
    public void testTime(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        Timestamp timestamp1 = new Timestamp(new Date().getTime());
        System.out.println(timestamp1);
    }
}
