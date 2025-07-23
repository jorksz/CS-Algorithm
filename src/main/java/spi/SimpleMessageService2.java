package spi;

import cn.hutool.core.util.StrUtil;

public class SimpleMessageService2 implements MessageService{

    private static MessageService messageService3 = SPIManager.getInstance().getMs3();

    public SimpleMessageService2() {
        System.out.println("messageService1 is null:" + StrUtil.toString(messageService3 == null));
    }

    @Override
    public String getMessage() {
        System.out.println("SimpleMessageService2");
        return "SimpleMessageService2";
    }
}
