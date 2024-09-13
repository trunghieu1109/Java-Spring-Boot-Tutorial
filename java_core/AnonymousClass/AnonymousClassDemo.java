interface Message {
    String message();
}

class MessageDispatcher {
    public void publicMessage(Message m) {
        System.out.println("Has message: " + m.message());
    }
}

public class AnonymousClassDemo {
    
    public void publicMessage(Message m) {
        System.out.println("Got message: " + m.message());
    }
    
    public static void main(String[] args) {
        AnonymousClassDemo anonClassDemo = new AnonymousClassDemo();
        anonClassDemo.publicMessage(new Message() {
            public String message() {
                return "This is new message";
            }
        });

        MessageDispatcher messageDispatcher = new MessageDispatcher() {
            // @overriding
            public void message(Message m) {
                System.out.println("Message: " + m.message());
            }
        };

        messageDispatcher.publicMessage(new Message() {
            public String message() {
                return "This is another message";
            }
        });
    }
}