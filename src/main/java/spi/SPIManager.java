package spi;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class SPIManager {

    private static volatile SPIManager spiManager;

    private final List<MessageService> messageServices;

    private SPIManager() {
        messageServices = new ArrayList<>();
        intSPI();
    }

    private void intSPI() {
        // 加载所有 MessageService 的实现
        ServiceLoader<MessageService> services = ServiceLoader.load(MessageService.class);
        // 遍历并使用所有实现
        for (MessageService service : services) {
            messageServices.add(service);
        }
    }

    public List<MessageService> getMessageServices() {
        return new ArrayList<>(this.messageServices);
    }

    public MessageService getMs1() {
        return this.messageServices.get(0);
    }

    public MessageService getMs2() {
        return this.messageServices.get(1);
    }

    public MessageService getMs3() {
        return this.messageServices.get(2);
    }

    public MessageService getMs4() {
        return this.messageServices.get(3);
    }

    public static SPIManager getInstance() {
        // 第一次检查，避免不必要的同步
        if (spiManager == null) {
            synchronized (SPIManager.class) {
                // 第二次检查，确保只有一个实例被创建
                if (spiManager == null) {
                    System.out.println("初始化了");
                    spiManager = new SPIManager();
                }
            }
        }
        return spiManager;
    }

}
