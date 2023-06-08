package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import org.greenrobot.eventbus.EventBus;

import il.cshaifasweng.OCSFMediatorExample.client.ocsf.AbstractClient;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SimpleClient extends AbstractClient {
	
	private static SimpleClient client = null;
	private Socket clientSocket;
	private ObjectOutputStream outputStream;
	private SimpleClient(String localhost, int port) {
		super(port);
		try {
			clientSocket = new Socket("localhost", 3000);
			outputStream = new ObjectOutputStream(clientSocket.getOutputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void handleMessageFromServer(Object msg) {
		EventBus.getDefault().post(msg);
	}
	public static SimpleClient getClient() {
		if (client == null) {
			client = new SimpleClient("localhost", 3000);
		}
		return client;
	}

}
