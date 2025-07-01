package MODEL;

/**
 * La clase Task representa una tarea con título, descripción y estado.
 * Principio aplicado:
 * - SRP: Solo se encarga de la lógica de una tarea individual.
 */
public class Task {
    private String title;
    private String description;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return title + " - " + (completed ? "COMPLETADA" : "PENDIENTE");
    }
}
