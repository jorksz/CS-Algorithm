package spi;

import cn.hutool.core.util.StrUtil;

public class SimpleMessageService4 implements MessageService {

    private static MessageService messageService1 = SPIManager.getInstance().getMs1();

    public SimpleMessageService4() {
        System.out.println("messageService1 is null:" + StrUtil.toString(messageService1 == null));
    }

    @Override
    public String getMessage() {
        System.out.println("SimpleMessageService4");
        System.out.println("messageService1 is null:" + StrUtil.toString(messageService1 == null));
        return "SimpleMessageService4";
    }
}
