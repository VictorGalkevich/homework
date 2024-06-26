package edu.java.bot.processor;

import edu.java.bot.command.Command;
import edu.java.bot.command.HelpCommand;
import edu.java.bot.formatter.Formatter;
import edu.java.bot.tgbot.model.BotUpdate;
import edu.java.bot.tgbot.request.SendMessage;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HelpMessageProcessor extends UserMessageProcessor {
    private final List<Command> commands;
    private final String help;
    private final Formatter formatter;

    @Override
    public SendMessage process(Command command, BotUpdate update) {
        if (command instanceof HelpCommand) {
            StringBuilder message = new StringBuilder("Available commands: \n");
            for (Command cmd : commands) {
                message.append(help.formatted(cmd.command(), cmd.description()));
            }
            return new SendMessage(update.id(), message.toString())
                    .parseMode(formatter.parseMode());
        } else {
            return null;
        }
    }
}
