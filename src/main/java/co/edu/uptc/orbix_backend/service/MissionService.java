package co.edu.uptc.orbix_backend.service;

import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.orbix_backend.model.Mission;
import co.edu.uptc.orbix_backend.model.NodeTask;
import co.edu.uptc.orbix_backend.model.Task;
import co.edu.uptc.orbix_backend.model.TaskComp;


public class MissionService {

    private List<Mission> missions = new ArrayList<>();

   
    public List<Mission> getAll() {
        return missions;
    }

    public Mission getByName(String name) {
        return missions.stream()
                .filter(m -> m.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public Mission create(Mission mission) {
        missions.add(mission);
        return mission;
    }

    public Mission update(String name, Mission updated) {
        Mission m = getByName(name);
        if (m != null) {
            m.setRoot(updated.getRoot());
        }
        return m;
    }

    public boolean delete(String name) {
        return missions.removeIf(m -> m.getName().equalsIgnoreCase(name));
    }

   
    public boolean addNode(String missionName, String parentName, NodeTask newNode) {
        Mission mission = getByName(missionName);
        if (mission == null) return false;

        NodeTask parent = findNode(mission.getRoot(), parentName);
        if (parent == null) return false;

        parent.add(newNode);
        return true;
    }

    public boolean addTask(String missionName, String parentName, Task task) {
        Mission mission = getByName(missionName);
        if (mission == null) return false;

        NodeTask parent = findNode(mission.getRoot(), parentName);
        if (parent == null) return false;

        parent.add(task);
        return true;
    }


    public boolean removeByName(String missionName, String targetName) {
        Mission mission = getByName(missionName);
        if (mission == null) return false;

      
        if (mission.getRoot().getName().equals(targetName)) return false;

        return removeRecursive(mission.getRoot(), targetName);
    }

    private boolean removeRecursive(NodeTask current, String targetName) {
        List<TaskComp> children = current.getChildren();

        for (TaskComp child : children) {

            
            if (child instanceof Task) {
                if (child.getName().equals(targetName)) {
                    children.remove(child);
                    return true;
                }
            }

            
            if (child instanceof NodeTask) {
                NodeTask node = (NodeTask) child;

                if (node.getName().equals(targetName)) {
                    children.remove(node);
                    return true;
                }

                if (removeRecursive(node, targetName)) {
                    return true;
                }
            }
        }
        return false;
    }


    private NodeTask findNode(NodeTask current, String name) {
        if (current.getName().equals(name)) {
            return current;
        }

        for (TaskComp child : current.getChildren()) {
            if (child instanceof NodeTask) {
                NodeTask result = findNode((NodeTask) child, name);
                if (result != null) return result;
            }
        }

        return null;
    }
}