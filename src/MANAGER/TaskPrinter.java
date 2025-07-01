package MANAGER;

import INTERFACES.ITaskPrinter;
import MODEL.Task;

/**
 * TaskPrinter es responsable de imprimir detalles de las tareas.
 * Principio aplicado:
 * - SRP: Solo maneja la representación textual de tareas.
 * - OCP: Puede ser extendida sin modificar el código existente.
 */
public class TaskPrinter implements ITaskPrinter {
    @Override
    public void printTask(Task task) {
        // Imprime detalles de la tarea, incluyendo título y descripción
        System.out.println("Título: " + task.getTitle());
        System.out.println("Descripción: " + task.getDescription());
        System.out.println("Estado: " + (task.isCompleted() ? "Completada" : "Pendiente"));
        System.out.println("----------------------------------");
    }
}