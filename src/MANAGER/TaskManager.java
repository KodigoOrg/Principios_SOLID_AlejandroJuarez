package MANAGER;

import INTERFACES.ITaskManager;
import MODEL.Project;
import MODEL.Task;
import MODEL.User;

import java.util.*;

/**
 * TaskManager maneja la asignación de tareas a usuarios y proyectos.
 * Principios aplicados:
 * - SRP: Gestiona exclusivamente la lógica de asignación.
 * - DIP: Depende de la abstracción ITaskManager y no de clases concretas.
 */
public class TaskManager implements ITaskManager {

    private final Map<Task, User> taskUserMap = new HashMap<>();
    private final Map<Task, Project> taskProjectMap = new HashMap<>();

    @Override
    public void assignTaskToUser(Task task, User user) {
        taskUserMap.put(task, user);
        user.addTask(task); // asegúrate que el metodo addTask esté en la clase User
    }

    @Override
    public void assignTaskToProject(Task task, Project project) {
        taskProjectMap.put(task, project);
        project.addTask(task); // asegúrate que el metodo addTask esté en la clase Project
    }

    public User getTaskUser(Task task) {
        return taskUserMap.get(task);
    }

    public Project getTaskProject(Task task) {
        return taskProjectMap.get(task);
    }

    public List<Task> getTasksByUser(User user) {
        List<Task> tasks = new ArrayList<>();
        for (Map.Entry<Task, User> entry : taskUserMap.entrySet()) {
            if (entry.getValue().equals(user)) {
                tasks.add(entry.getKey());
            }
        }
        return tasks;
    }
}
