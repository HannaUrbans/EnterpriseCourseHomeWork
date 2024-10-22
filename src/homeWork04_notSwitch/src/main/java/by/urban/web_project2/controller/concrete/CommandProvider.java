package by.urban.web_project2.controller.concrete;

import java.util.HashMap;
import java.util.Map;

import by.urban.web_project2.controller.concrete.implementation.DoAuth;
import by.urban.web_project2.controller.concrete.implementation.DoRegistration;
import by.urban.web_project2.controller.concrete.implementation.GoToAuthentificationPage;
import by.urban.web_project2.controller.concrete.implementation.GoToRegistrationPage;
import by.urban.web_project2.controller.concrete.implementation.NoSuchCommand;
import by.urban.web_project2.controller.concrete.implementation.ShowStub;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put(CommandName.DO_AUTH, new DoAuth());
		commands.put(CommandName.DO_REGISTRATION, new DoRegistration());
		commands.put(CommandName.GO_TO_REGISTRATION_PAGE, new GoToRegistrationPage());
		commands.put(CommandName.GO_TO_AUTHENTIFICATION_PAGE, new GoToAuthentificationPage());
		commands.put(CommandName.SHOW_STUB, new ShowStub());
		commands.put(CommandName.NO_SUCH_COMMAND, new NoSuchCommand());
	}
	
	public Command takeCommand(String userCommand) {
		CommandName commandName;
		Command command;
		
		try {
			commandName = CommandName.valueOf(userCommand.toUpperCase());
			command = commands.get(commandName);
		}catch(IllegalArgumentException | NullPointerException e) {
			command = commands.get(CommandName.NO_SUCH_COMMAND);
		}
		
		return command;		
	}
}
