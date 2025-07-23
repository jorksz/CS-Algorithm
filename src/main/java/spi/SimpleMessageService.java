package spi;

public class SimpleMessageService implements MessageService{
    @Override
    public String getMessage() {
        System.out.println("SimpleMessageService");
        return "SimpleMessageService";
    }
}
