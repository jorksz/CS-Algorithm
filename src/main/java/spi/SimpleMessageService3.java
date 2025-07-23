package spi;

public class SimpleMessageService3 implements MessageService{
    @Override
    public String getMessage() {
        System.out.println("SimpleMessageService3");
        return "SimpleMessageService3";
    }
}
