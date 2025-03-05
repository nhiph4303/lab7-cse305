import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessagingService messagingService = new MessagingService();

        // sending messages
         messagingService.sendMessage("Hello, tenant!", "Property Manager", "Tenant A");
        messagingService.sendMessage("Important notice: Rent due next week.", "Property Owner", "Tenant A");
        messagingService.sendMessage("Maintenance request received.", "Tenant A", "Property Manager");

        // Lấy tin nhắn của Tenant A
        List<Message> tenantAMessages = messagingService.getMessagesForRecipient("Tenant A");
        for (Message message : tenantAMessages) {
            System.out.println(message);
        }

        // Calling the new method
        messagingService.sendMessage("", "Sender", "Recipient");

        messagingService.printAllMessages();
    }
}