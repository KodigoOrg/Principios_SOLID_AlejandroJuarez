package CONSOLE;

import MODEL.*;
import MANAGER.*;
import java.util.*;

/**
 * Clase principal de la aplicación de consola para gestión de tareas, proyectos y usuarios.
 * <p>
 * Permite crear usuarios, proyectos y tareas, asignarlas, visualizarlas y marcarlas como completadas
 * mediante un menú interactivo basado en consola. Aplica principios de diseño SOLID mediante el uso
 * de clases separadas como {@code TaskManager} y {@code TaskPrinter}.
 * </p>
 *
 * Funcionalidades disponibles:
 * <ul>
 *   <li>Crear usuarios</li>
 *   <li>Crear proyectos</li>
 *   <li>Crear tareas</li>
 *   <li>Asignar tareas a usuarios o proyectos</li>
 *   <li>Ver tareas asignadas por proyecto o usuario</li>
 *   <li>Marcar tareas como completadas</li>
 * </ul>
 *
 * @author
 */
public class Main {

    /**
     * Punto de entrada principal de la aplicación.
     * <p>
     * Muestra un menú en consola para interactuar con el sistema de tareas. Utiliza un bucle
     * infinito que solo se detiene cuando el usuario elige la opción 0 (salir).
     * </p>
     *
     * @param args Argumentos de línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        TaskPrinter printer = new TaskPrinter();

        List<Project> projects = new ArrayList<>();
        List<User> users = new ArrayList<>();
        List<Task> tasks = new ArrayList<>();

        while (true) {
            System.out.println("\n----------MENÚ PRINCIPAL----------");
            System.out.println("1. Crear usuario");
            System.out.println("2. Crear proyecto");
            System.out.println("3. Crear tarea");
            System.out.println("4. Asignar tarea a usuario");
            System.out.println("5. Asignar tarea a proyecto");
            System.out.println("6. Ver tareas por proyecto");
            System.out.println("7. Ver tareas por usuario");
            System.out.println("8. Marcar tarea como completada");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            String input = sc.nextLine();
            int opc;

            try {
                opc = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Seleccione una opción correcta.");
                continue;
            }

            switch (opc) {
                case 1:
                    System.out.print("Nombre de usuario: ");
                    users.add(new User(sc.nextLine()));
                    break;
                case 2:
                    System.out.print("Nombre del proyecto: ");
                    projects.add(new Project(sc.nextLine()));
                    break;
                case 3:
                    System.out.print("Título de la tarea: ");
                    String title = sc.nextLine();
                    System.out.print("Descripción: ");
                    String desc = sc.nextLine();
                    tasks.add(new Task(title, desc));
                    break;
                case 4:
                    if (tasks.isEmpty()) {
                        System.out.println("No hay tareas creadas aún.");
                        break;
                    }
                    if (users.isEmpty()) {
                        System.out.println("No hay usuarios creados aún.");
                        break;
                    }

                    List<Task> tareasAsignablesUsuario = tasks.stream()
                            .filter(t -> taskManager.getTaskUser(t) == null
                                    && taskManager.getTaskProject(t) == null
                                    && !t.isCompleted())
                            .toList();

                    if (tareasAsignablesUsuario.isEmpty()) {
                        System.out.println("No hay tareas disponibles para asignar a un usuario.");
                        break;
                    }

                    System.out.println("Seleccione tarea:");
                    Task t1 = selectFromList(tareasAsignablesUsuario, sc);
                    if (t1 == null) break;

                    System.out.println("Seleccione usuario:");
                    User u1 = selectFromList(users, sc);
                    if (u1 == null) break;

                    taskManager.assignTaskToUser(t1, u1);
                    break;
                case 5:
                    if (tasks.isEmpty()) {
                        System.out.println("No hay tareas creadas aún.");
                        break;
                    }
                    if (projects.isEmpty()) {
                        System.out.println("No hay proyectos creados aún.");
                        break;
                    }

                    List<Task> tareasAsignablesProyecto = tasks.stream()
                            .filter(t -> taskManager.getTaskProject(t) == null
                                    && taskManager.getTaskUser(t) == null
                                    && !t.isCompleted())
                            .toList();

                    if (tareasAsignablesProyecto.isEmpty()) {
                        System.out.println("No hay tareas disponibles para asignar a un proyecto.");
                        break;
                    }

                    System.out.println("Seleccione tarea:");
                    Task t2 = selectFromList(tareasAsignablesProyecto, sc);
                    if (t2 == null) break;

                    System.out.println("Seleccione proyecto:");
                    Project p1 = selectFromList(projects, sc);
                    if (p1 == null) break;

                    taskManager.assignTaskToProject(t2, p1);
                    break;
                case 6:
                    if (projects.isEmpty()) {
                        System.out.println("No hay proyectos creados aún.");
                        break;
                    }

                    System.out.println("Seleccione proyecto:");
                    Project p2 = selectFromList(projects, sc);
                    if (p2 == null) break;

                    if (p2.getTasks().isEmpty()) {
                        System.out.println("El proyecto seleccionado no tiene tareas asignadas.");
                        break;
                    }

                    p2.getTasks().forEach(printer::printTask);
                    break;
                case 7:
                    if (users.isEmpty()) {
                        System.out.println("No hay usuarios creados aún.");
                        break;
                    }

                    System.out.println("Seleccione usuario:");
                    User selectedUser = selectFromList(users, sc);
                    if (selectedUser == null) break;

                    List<Task> tareasDelUsuario = taskManager.getTasksByUser(selectedUser);

                    if (tareasDelUsuario.isEmpty()) {
                        System.out.println("Este usuario no tiene tareas asignadas.");
                        break;
                    }

                    tareasDelUsuario.forEach(printer::printTask);
                    break;
                case 8:
                    if (tasks.isEmpty()) {
                        System.out.println("No hay tareas creadas aún.");
                        break;
                    }

                    List<Task> tareasIncompletas = tasks.stream()
                            .filter(t -> !t.isCompleted())
                            .toList();

                    if (tareasIncompletas.isEmpty()) {
                        System.out.println("Todas las tareas ya están completadas.");
                        break;
                    }

                    System.out.println("Seleccione tarea a marcar como completada:");
                    Task t3 = selectFromList(tareasIncompletas, sc);
                    if (t3 == null) break;

                    t3.markCompleted();
                    System.out.println("Tarea completada correctamente.");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Seleccione una opción correcta.");
                    break;
            }
        }
    }

    /**
     * Metodo auxiliar genérico para seleccionar un elemento de una lista desde la consola.
     * <p>
     * Muestra todos los elementos de la lista con su índice correspondiente y pide al usuario
     * que seleccione uno. Si la selección es inválida, se muestra un mensaje de error y se retorna {@code null}.
     * </p>
     *
     * @param list Lista de elementos a mostrar.
     * @param sc Scanner para entrada del usuario.
     * @param <T> Tipo de los elementos de la lista.
     * @return El elemento seleccionado o {@code null} si la entrada fue inválida.
     */
    private static <T> T selectFromList(List<T> list, Scanner sc) {
        for (int i = 0; i < list.size(); i++)
            System.out.println((i + 1) + ". " + list.get(i));

        System.out.print("Ingrese una opción: ");
        try {
            int choice = Integer.parseInt(sc.nextLine()) - 1;

            if (choice < 0 || choice >= list.size()) {
                throw new IndexOutOfBoundsException("El dato ingresado no es válido.");
            }

            return list.get(choice);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
