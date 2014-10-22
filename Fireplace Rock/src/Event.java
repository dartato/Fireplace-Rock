public class Event
{
    static final int CARD_PLAYED = 1;
    static final int MINION_PLAYED = 2;
    static final int SPELL_PLAYED = 3;
    static final int TURN_END = 4;
    static final int TURN_START = 5;
    static final int ALLIED_MINION_DEATH = 6;
    static final int ALLIED_DAMAGE_TAKEN = 7;
    static final int ALLIED_MINION_HEALED = 8;
    static final int CHECK_FOR_MINION_DEATH = 9;
    int type;
    String eventName;
    public Event(int EventType)
    {
        type = EventType;
    }
    public Event(int EventType, String name)
    {
        type = EventType;
        eventName = name;
    }
}
