package no.ntnu.osnap.com.testing;

import java.util.Random;
import java.util.concurrent.TimeoutException;
import no.ntnu.osnap.com.deprecated.ComLayer;

public class ProtocolTest {
    public static void main(String[] args) throws TimeoutException, InterruptedException {
        ComLayer arduino = new ComLayer();
		Thread th = new Thread(arduino);
		th.start();
		
		//System.out.println(arduino.getConnectionData().getAddress());
		
		boolean toggle = false;
		
		Random rand = new Random();
		
		System.out.println("Sensor 0: " + arduino.sensor(0));
		System.out.println("Sensor 1: " + arduino.sensor(1));
		
		arduino.print("WIN! :D", true);
        
        for (long i = 120; i < 1000; ++i){
		
		arduino.print("WIN! :D" + i, true);
            arduino.data(new byte[]{
				(byte)rand.nextInt(255),
				(byte)rand.nextInt(255),
				(byte)rand.nextInt(255),
				(byte)rand.nextInt(255),
				(byte)rand.nextInt(255),
				(byte)rand.nextInt(255)
			}, true);
			//Thread.sleep(10);
        }
		
		Thread.sleep(10000);
		arduino.disconnect();
		
		arduino.close();
        
        //arduino.print("ZooPark");
        //arduino.print("D");
		System.out.println("Done");
    }
    
}
