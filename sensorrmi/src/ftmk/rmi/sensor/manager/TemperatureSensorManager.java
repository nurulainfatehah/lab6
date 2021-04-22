package ftmk.rmi.sensor.manager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class manage the value of temperature from the sensor.
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureSensorManager extends UnicastRemoteObject implements TemperatureSensor {

	public TemperatureSensorManager() throws RemoteException {
		super();
	}

	@Override
	public int getTemperature() throws RemoteException {
		
		return 35;
	}
	
	public HashMap loadTemp() {
		
		
		HashMap<String, Integer> temps = new HashMap<>();
		
		temps.put("Monday", 32);
		temps.put("Tuesday", 31);
		temps.put("Wednesday", 33);
		temps.put("Thursday", 35);
		temps.put("Friday", 36);
		temps.put("Saturday", 33);
		temps.put("Sunday", 33);
		
		
		
		return temps;
	}

	public int getTemperatureOfDay(String day) throws RemoteException{
		int temp;
		
		HashMap HashMapTemps = loadTemp();
		
		String dayT = day;
		
		temp = (int) HashMapTemps.get(dayT);
		
		return temp;
	}
	
	
	public float getWeeklyAverageTemp() {
		int totalDay = 7;
		float avgTemp = 0;
		
		HashMap<String, Integer> HashMapsTemps = loadTemp();
		
		for(int temp: HashMapsTemps.values()) {
			
			avgTemp = avgTemp + temp;
		}
		
		avgTemp = avgTemp/totalDay;
		
		return avgTemp;
		
	}
	
}
