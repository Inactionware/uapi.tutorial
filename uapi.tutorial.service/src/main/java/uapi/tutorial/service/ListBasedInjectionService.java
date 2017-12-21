package uapi.tutorial.service;

import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.OnActivate;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

import java.util.ArrayList;
import java.util.List;

@Service(autoActive = true)
@Tag("ListBasedInjection")
public class ListBasedInjectionService {

    @Inject
    protected ILogger _logger;

    @Inject
    protected List<IListItem> _items = new ArrayList<>();

    @OnActivate
    public void activate() {
        if (this._items.size() == 2) {
            this._logger.info("The service is injected into the list!");
        } else {
            this._logger.error("The server is NOT injected into the list!");
        }
    }
}
