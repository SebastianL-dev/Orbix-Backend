package co.edu.uptc.orbix_backend.model;

import java.util.ArrayList;
import java.util.List;

public class NodeTask implements TaskComp {

    private String name;
    private NodeTask parent;
    private List<TaskComp> children = new ArrayList<>();

    public NodeTask() {}

    public NodeTask(String name) {
        this.name = name;
    }

    
    public void add(TaskComp comp) {
        if (comp instanceof NodeTask) {
            ((NodeTask) comp).parent = this;
        }
        children.add(comp);
    }

    public List<TaskComp> getChildren() {
        return children;
    }

    public NodeTask getParent() {
        return parent;
    }

    @Override
    public String getName() {
        return name;
    }

    
    @Override
    public double getCost() {
        double total = 0;
        for (TaskComp c : children) {
            total += c.getCost();
        }
        return total;
    }

    @Override
    public int getDuration() {
        int total = 0;
        for (TaskComp c : children) {
            total += c.getDuration();
        }
        return total;
    }
}