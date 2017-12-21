package uapi.tutorial.service;

import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service(IListItem.class)
@Tag("ListBasedInjection")
public class ListItemB implements IListItem { }
