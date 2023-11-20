package entity;

public abstract class DataObject {
    private final String id;
    private final String name;

    public DataObject(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
