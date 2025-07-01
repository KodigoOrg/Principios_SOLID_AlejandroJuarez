package MODEL;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase User representa a un usuario con una lista de tareas asignadas.
 * Principio aplicado:
 * - SRP: Solo maneja datos y operaciones relacionadas al usuario.
 */
public class User {
    private String name;
    private List<Task> tasks;  // Declarar la lista de tareas

    public User(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();  // Inicializar la lista
    }

    public String getName() {
        return name;
    }

    public void addTask(Task task) {
        tasks.add(task);  // Ya no habrá error
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return name;
    }
}
