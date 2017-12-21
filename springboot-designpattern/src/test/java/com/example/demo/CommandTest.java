package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommandTest {

	// This client method is a client
	@Test
	public void test() {
		Administrator admin = new Administrator();
		Server server = new Server();

		// start Apache
		admin.setCommand(new StartApache(server));
		admin.typeEnter();

		// start Tomcat
		admin.setCommand(new StartTomcat(server));
		admin.typeEnter();

		// check executed commands
		int executed = server.getExecutedCommands().size();
		assertTrue("Two commands should be executed but only "+
				executed+ " were", executed == 2);
	}

}

// commands
abstract class ServerCommand {

	protected Server server;

	public ServerCommand(Server server) {
		this.server = server;
	}

	public abstract void execute();
}

class StartTomcat extends ServerCommand {

	public StartTomcat(Server server) {
		super(server);
	}

	@Override
	public void execute() {
		server.launchCommand("sudo service tomcat7 start");
	}
}

class StartApache extends ServerCommand {

	public StartApache(Server server) {
		super(server);
	}

	@Override
	public void execute() {
		server.launchCommand("sudo service apache2 start");
	}
}

// invoker
class Administrator {

	private ServerCommand command;

	public void setCommand(ServerCommand command) {
		this.command = command;
	}

	public void typeEnter() {
		this.command.execute();
	}

}

// receiver
class Server {

	// as in common terminals, we store executed commands in history
	private List<String> executedCommands = new ArrayList<String>();

	public void launchCommand(String command) {
		System.out.println("Executing: "+command+" on server");
		this.executedCommands.add(command);
	}

	public List<String> getExecutedCommands() {
		return this.executedCommands;
	}

}
