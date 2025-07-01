package INTERFACES;

import MODEL.Task;

/**
 * Interfaz responsable de definir el contrato para impresión de tareas.
 * Principio aplicado:
 * - ISP: Una interfaz especializada y pequeña.
 */
public interface ITaskPrinter {
    void printTask(Task task);
}