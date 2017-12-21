package uapi.tutorial.service;

import uapi.service.IServiceFactory;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service
@Tag("FactoryBasedInjection")
public class AServiceFactory implements IServiceFactory<IAService> {

    @Override
    public IAService createService(Object serveFor) {
        return new IAService() { };
    }
}
