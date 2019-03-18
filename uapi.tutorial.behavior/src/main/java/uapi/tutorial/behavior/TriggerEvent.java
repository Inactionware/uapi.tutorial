package uapi.tutorial.behavior;

import uapi.behavior.BehaviorEvent;

public class TriggerEvent extends BehaviorEvent {

    public static final String TOPIC    = "MyEventTopic";

    public TriggerEvent(String sourceName) {
        super(TOPIC, sourceName);
    }
}
