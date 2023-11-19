package entity;

public abstract class DataObject {
    private final String id;
    private final String name;

    public DataObject(String id) {
        this.id = id;
        this.name = "";      // TODO: API Call to set the name (song/artist have "name"
                             // TODO: and user has "display_name")

                             // Why not initialize these with a name parameter as well?
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
