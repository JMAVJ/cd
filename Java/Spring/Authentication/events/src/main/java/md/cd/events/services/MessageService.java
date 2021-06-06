package md.cd.events.services;

import org.springframework.stereotype.Service;

import md.cd.events.models.Message;
import md.cd.events.repositories.MessageRepository;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message add(Message message) {
        return messageRepository.save(message);
    }
}
