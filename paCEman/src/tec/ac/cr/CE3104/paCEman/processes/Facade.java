package tec.ac.cr.CE3104.paCEman.processes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import tec.ac.cr.CE3104.paCEman.network.SimpleSocketClient;

public class Facade {

	SimpleSocketClient socket;
	JsonObject jsonToSend;
	public Facade() {
		socket = null;
		// TODO Auto-generated constructor stub
	}
	
	public void setSockValues(int PORT, String IP) {
		socket = new SimpleSocketClient(PORT, IP);
	}
	
	public String getStartMat() {
		if (socket != null) {
			jsonToSend = new JsonObject();
			jsonToSend.addProperty("message_type", "begin_game");
			try {
				String json = socket.writeToAndReadFromSocket(jsonToSend.toString());
				JsonObject tmpJSON = new JsonParser().parse(json).getAsJsonObject();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
		}
		return null;
	}
}
