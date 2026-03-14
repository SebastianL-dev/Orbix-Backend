package co.edu.uptc.orbix_backend.model;
import java.util.ArrayList;
import java.util.List;


public class NodeTask {

  private String name;
  private List<Object> children;

  public NodeTask(String name) {
    this.name = name;
    children = new ArrayList<>();
  }

  public void add(Object task){
    children.add(task);
  }

  public List<Object> getChildren() {
    return children;
  }

  public String getNombre() {
    return name;
  }

}
