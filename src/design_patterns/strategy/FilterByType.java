package design_patterns.strategy;

/*
 * An implementation of Strategy interface, which decides to filter
 * message by type.
 */
public class FilterByType implements FilteringStrategy {

    private MessageType type;

    public FilterByType(MessageType type) {
        this.type = type;
    }

    @Override
    public boolean isFilterable(Message msg) {
        return type == msg.getType();
    }

    @Override
    public String toString() {
        return "Filtering By type: " + type;
    }

}