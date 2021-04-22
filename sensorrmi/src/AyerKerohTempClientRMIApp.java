import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

import ftmk.rmi.sensor.TemperatureSensor;


public class AyerKerohTempClientRMIApp {

	public static void main(String[] args) {
		
		try {
			
			Registry rmiRegistry = LocateRegistry.getRegistry();
			
			TemperatureSensor  remoteSensor = (TemperatureSensor) rmiRegistry.lookup("SensorAyerKeroh");
			
			int temp = remoteSensor.getTemperature();
			
			System.out.println("Current temperature in Ayer Keroh is " + temp + " Celcius");
			
			System.out.println("\nTemperature on Monday in Ayer Keroh is " + remoteSensor.getTemperatureOfDay("Monday") + " Celcius");
			
			System.out.println("Temperature on Tuesday in Ayer Keroh is " + remoteSensor.getTemperatureOfDay("Tuesday") + " Celcius");
			
			System.out.println("\n\n======================Ayer Keroh======================\n\nWeekly average for temperature in Ayer Keroh is " 
					+ remoteSensor.getWeeklyAverageTemp() + " Celcius");
					System.out.println("\n====================================================");
			
			
		}catch(RemoteException | NotBoundException ex) {
			ex.printStackTrace();
		}

	}

}
