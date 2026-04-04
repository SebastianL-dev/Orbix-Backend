package co.edu.uptc.orbix_backend.model;

public class Task implements TaskComp {

    private String name;
    private int duration;
    private double cost;
    private String status;

    public Task() {}

    public Task(String name, int duration, double cost, String status) {
        this.name = name;
        this.duration = duration;
        this.cost = cost;
        this.status = status;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public double getCost() {
        return cost;
    }

    public String getStatus() {
        return status;
    }
}