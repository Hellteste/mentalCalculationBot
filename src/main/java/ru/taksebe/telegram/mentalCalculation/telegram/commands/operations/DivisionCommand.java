package ru.taksebe.telegram.mentalCalculation.telegram.commands.operations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import ru.taksebe.telegram.mentalCalculation.Utils;
import ru.taksebe.telegram.mentalCalculation.enums.OperationEnum;

import java.util.Collections;

/**
 * Команда получение файла с заданиями на деление
 */
public class DivisionCommand extends OperationCommand {
    private Logger logger = LoggerFactory.getLogger(PlusCommand.class);

    public DivisionCommand(String identifier, String description) {
        super(identifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String userName = Utils.getUserName(user);

        logger.debug(String.format("Пользователь %s. Начато выполнение команды %s", userName,
                this.getCommandIdentifier()));
        sendAnswer(absSender, chat.getId(), Collections.singletonList(OperationEnum.DIVISION), this.getDescription(),
                this.getCommandIdentifier(), userName);
        logger.debug(String.format("Пользователь %s. Завершено выполнение команд %s", userName,
                this.getCommandIdentifier()));
    }
}