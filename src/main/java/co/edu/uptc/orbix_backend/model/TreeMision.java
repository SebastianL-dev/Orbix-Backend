package co.edu.uptc.orbix_backend.model;

public class MisionTree {

  private NodeTask root;

  public MisionTree(String name) {
    root = new NodeTask(name);
  }

  public NodeTask getRoot() {
    return root;
  }
  
}
