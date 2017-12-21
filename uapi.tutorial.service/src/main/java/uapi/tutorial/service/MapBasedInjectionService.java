package uapi.tutorial.service;

import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.OnActivate;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

import java.util.HashMap;
import java.util.Map;

@Service(autoActive = true)
@Tag("MapBasedInjection")
public class MapBasedInjectionService {

    @Inject
    protected ILogger _logger;

    @Inject
    protected Map<String, IMapItem> _items = new HashMap<>();

    @OnActivate
    public void activate() {
        if (this._items.size() == 2) {
            this._logger.info("The services are injected into the map!");
        } else {
            this._logger.error("The services are NOT injected into the map!");
        }
    }
}
