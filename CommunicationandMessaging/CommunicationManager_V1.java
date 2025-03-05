import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Message {
    private final String content;
    private final String sender;
    private final String recipient;

    public Message(String content, String sender, String recipient) {
        this.content = content;
        this.sender = sender;
        this.recipient = recipient;
    }
    // Getters for message properties
    public String getContent() {
        return content;
    }
    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }
	public void display() {
        System.out.println("From: " + sender);
        System.out.println("To: " + recipient);
        System.out.println("Message: " + content);
    }

    @Override
    public String toString() {
        return "From: " + sender + " -> To: " + recipient + "\nMessage: " + content;
    }
}

class MessagingService {
    private final Map<String, List<Message>> inbox;

    public MessagingService() {
        this.inbox = new HashMap<>();
    }
    public void sendMessage(String content, String sender, String recipient) {
        if (content == null || content.trim().isEmpty() ||
            sender == null || sender.trim().isEmpty() ||
            recipient == null || recipient.trim().isEmpty()) {
            System.out.println("Invalid message! Content, sender, and recipient must not be empty.");
            return;
        }
        Message message = new Message(content, sender, recipient);
        inbox.computeIfAbsent(message.getRecipient(), k -> new ArrayList<>()).add(message);
    }

    public List<Message> getMessagesForRecipient(String recipient) {
        List<Message> messages = inbox.getOrDefault(recipient, new ArrayList<>());
        if (messages.isEmpty()) {
            System.out.println("No messages found for: " + recipient);
        }
        return messages;
    }

    public void printAllMessages() {
        if (inbox.isEmpty()) {
            System.out.println("Inbox is empty.");
            return;
        }
        for (List<Message> messages : inbox.values()) {
            for (Message message : messages) {
                message.display();
            }
        }
    }
}
