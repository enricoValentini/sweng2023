package sweng2023.sweng;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	GreetingResponse greetServer(String name) throws IllegalArgumentException;
	String register(String username, String password);
	String login(String username, String password);
}
