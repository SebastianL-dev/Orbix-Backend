package co.edu.uptc.orbix_backend.model;

public class Mission {

    private String name;
    private String description;
    private NodeTask root;

    public Mission() {}

    public Mission(String name, String description) {
        this.name = name;
        this.description = description;
        this.root = new NodeTask(name);
    }

    public NodeTask getRoot() {
        return root;
    }

    public void setRoot(NodeTask root) {
        this.root = root;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}