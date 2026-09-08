# Java Swing Calculator

Una calculadora de escritorio sencilla y funcional desarrollada en Java utilizando la biblioteca gráfica **Swing**. El proyecto implementa operaciones aritméticas básicas mediante una interfaz intuitiva organizada con gestores de diseño (`BorderLayout` y `GridLayout`).

---

## Características

- **Operaciones básicas:** Suma (`+`), resta (`-`), multiplicación (`*`) y división (`/`).
- **Manejo de errores:** Validación para división entre cero (muestra `Error`).
- **Limpieza de pantalla:** Botón `C` para reiniciar el estado y los valores almacenados.
- **Formato limpio:** Oculta decimales redundantes cuando el resultado es un número entero exacto (muestra `8` en vez de `8.0`).
- **Interfaz adaptada:** Ejecución sobre el *Event Dispatch Thread* (`SwingUtilities.invokeLater`) para garantizar estabilidad visual.

---

## Estructura del Proyecto

```text
.
├── bin/          # Archivos compilados (.class)
├── lib/          # Dependencias externas (no requeridas para este proyecto)
├── src/
│   └── App.java  # Código fuente principal de la aplicación
└── README.md