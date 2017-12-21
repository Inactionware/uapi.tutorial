package uapi.tutorial.service;

import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.OnActivate;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service(autoActive = true)
@Tag("FactoryBasedInjection")
public class FactoryBasedInjectionService {

    @Inject
    protected ILogger _logger;

    @Inject
    protected IAService _svc;

    @OnActivate
    public void activate() {
        if (this._svc != null) {
            this._logger.info("The AService is injected!");
        } else {
            this._logger.error("The AService is NOT injected!");
        }
    }
}
