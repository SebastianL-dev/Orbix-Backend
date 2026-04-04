package co.edu.uptc.orbix_backend.utils;

import co.edu.uptc.orbix_backend.model.NodeTask;
import co.edu.uptc.orbix_backend.model.Task;
import co.edu.uptc.orbix_backend.model.TaskComp;

public class MissionUtils {

    // Duración total del árbol
    public static int calculateTotalDuration(TaskComp node) {

        if (node instanceof Task) {
            return ((Task) node).getDuration();
        } else if (node instanceof NodeTask) {
            int total = 0;
            NodeTask n = (NodeTask) node;
            
            // Sumar tareas directas
            for (Task t : n.getTasks()) {
                total += calculateTotalDuration(t);
            }

            // Sumar hijos nodos recursivamente
            for (NodeTask child : n.getChildren()) {
                total += calculateTotalDuration(child);
            }

            return total;
        }
        return 0;
    }

    // Costo total del árbol
    public static double calculateTotalCost(TaskComp node) {

        if (node instanceof Task) {
            return ((Task) node).getCost();

        } else if (node instanceof NodeTask) {
            double total = 0;
            NodeTask n = (NodeTask) node;
            
            for (Task t : n.getTasks()) {
                total += calculateTotalCost(t);
            }

            for (NodeTask child : n.getChildren()) {
                total += calculateTotalCost(child);
            }

            return total;
        }
        return 0;
    }

    // Tiempo restante considerando estado
    public static int calculateRemainingTime(TaskComp node) {
        if (node instanceof Task) {
            Task t = (Task) node;

            if (!t.getStatus().equalsIgnoreCase("Completed")) {
                return t.getDuration();
            }
            return 0;
            
        } else if (node instanceof NodeTask) {
            int total = 0;
            NodeTask n = (NodeTask) node;

            for (Task t : n.getTasks()) {
                total += calculateRemainingTime(t);
            }

            for (NodeTask child : n.getChildren()) {
                total += calculateRemainingTime(child);
            }

            return total;
        }
        return 0;
    }
}