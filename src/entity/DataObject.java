package entity;

public abstract class DataObject {
    private final String id;
    private final String name;

    public DataObject(String id) {
        this.id = id;
        this.name = "";      // TODO: API Call to set the name
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
