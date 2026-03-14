package co.edu.uptc.orbix_backend.model;
public class Task {
  private String name;
  private int duration;
  private double cost;
  private String status;

  public Task(String name, int duration, double cost, String status) {
    this.name = name;
    this.duration = duration;
    this.cost = cost;
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  
  
}