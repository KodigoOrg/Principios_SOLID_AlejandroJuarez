# TaskManagerSOLID in Console App

Una aplicación de consola desarrollada en Java que permite gestionar tareas, usuarios y proyectos. Implementa principios sólidos de diseño orientado a objetos (SOLID) para lograr un código limpio, modular y fácil de mantener.

---

## Características principales

- Crear usuarios y proyectos.
- Crear tareas con título y descripción.
- Asignar tareas a usuarios o a proyectos (pero no a ambos).
- Visualizar tareas por usuario o proyecto.
- Marcar tareas como completadas.
- Filtrado automático de tareas ya asignadas o completadas.

---

## Principios SOLID aplicados

Este proyecto fue diseñado siguiendo los principios **SOLID**:

- **S** — *Single Responsibility*: Cada clase tiene una única responsabilidad.  
  Ej: `Task`, `User`, `Project`, `TaskManager`, `TaskPrinter`, etc.
  
- **O** — *Open/Closed*: Uso de interfaces como `ITaskManager` y `ITaskPrinter` permite extender funcionalidades sin modificar código existente.

- **L** — *Liskov Substitution*: Las implementaciones pueden sustituir interfaces sin romper el comportamiento del sistema.

- **I** — *Interface Segregation*: Interfaces separadas para tareas específicas (`ITaskManager`, `ITaskPrinter`).

- **D** — *Dependency Inversion*: Uso de interfaces en lugar de depender directamente de clases concretas (aunque puede mejorarse con inyección de dependencias).

---

##  Estructura del proyecto

```
src/
│
├── CONSOLE/
│ └── Main.java ← Menú principal de la consola
│
├── MODEL/
│ ├── Task.java ← Modelo de tarea
│ ├── User.java ← Modelo de usuario
│ └── Project.java ← Modelo de proyecto
│
├── MANAGER/
│ ├── TaskManager.java ← Lógica para asignar tareas a usuarios/proyectos
│ └── TaskPrinter.java ← Lógica para imprimir detalles de tareas
│
├── INTERFACES/
│ ├── ITaskManager.java ← Interfaz para gestión de tareas
│ └── ITaskPrinter.java ← Interfaz para impresión de tareas
```

## Vista previa del Menu Principal

----------MENÚ PRINCIPAL----------
1. Crear usuario
2. Crear proyecto
3. Crear tarea
4. Asignar tarea a usuario
5. Asignar tarea a proyecto
6. Ver tareas por proyecto
7. Ver tareas por usuario
8. Marcar tarea como completada
0. Salir
Seleccione una opción:

## Compilación y Ejecución
Se realizo en JDK 21.

## Autor

Desarrollado por Alejandro Ernesto Juarez Argumedo - Estudiante de Java Developer 21.
