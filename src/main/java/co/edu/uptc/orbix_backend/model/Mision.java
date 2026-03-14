package co.edu.uptc.orbix_backend.model;

public class Mision {
  private String name;
  private String description;
  private MisionTree tree;

  public Mision(String name, String description, MisionTree tree) {
    this.name = name;
    this.description = description;
    this.tree = tree;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public MisionTree getTree() {
    return tree;
  }

  public void setTree(MisionTree tree) {
    this.tree = tree;
  }
  
}