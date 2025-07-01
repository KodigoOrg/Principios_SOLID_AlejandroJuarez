package MODEL;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase Project representa un proyecto que contiene una lista de tareas.
 * Principio aplicado:
 * - SRP (Single Responsibility): Esta clase solo maneja datos relacionados al proyecto.
 */
public class Project {
    private String name;
    private List<Task> tasks;

    public Project(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return name;
    }
}