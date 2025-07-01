package INTERFACES;

import MODEL.Task;
import MODEL.User;
import MODEL.Project;

/**
 * Interfaz que define operaciones de asignación de tareas.
 * Principio aplicado:
 * - ISP: Solo define métodos esenciales de asignación, sin forzar implementación innecesaria.
 */
public interface ITaskManager {
    void assignTaskToUser(Task task, User user);
    void assignTaskToProject(Task task, Project project);
}