# Proyecto DocTic

Este proyecto, **DocTic**, es un sistema de gestión de documentos que permite almacenar, organizar, visualizar y valorar documentos. El sistema incluye funcionalidades para la administración de documentos, usuarios, categorías y permite realizar un seguimiento detallado de las interacciones de los usuarios con el contenido.

## Funcionalidades Principales

1. **Gestión de Documentos**: Permite agregar, editar y eliminar documentos, cada uno de los cuales puede tener una descripción, una URL, un estado de visibilidad (público o privado), y pertenecer a una categoría.
2. **Visualización y Descarga de Documentos**: Los usuarios pueden visualizar y descargar documentos, el sistema lleva un registro de cada visualización y descarga.
3. **Valoración de Documentos**: Los usuarios pueden valorar documentos con un puntaje, permitiendo opiniones mixtas y evaluaciones que reflejan la relevancia del contenido.
4. **Comentarios y Debates**: El sistema permite agregar comentarios a los documentos, fomentando la discusión y el debate en torno a los contenidos.
5. **Consultas Personalizadas**: La plataforma incluye varias consultas personalizadas para obtener información sobre el uso de los documentos, opiniones de los usuarios, y popularidad de los documentos.

## Estructura de la Base de Datos

### Colecciones Principales

Las colecciones y sus esquemas detallados incluyen:

- **Usuarios**: Contiene la información de cada usuario registrado.
- **Contrasenas**: Almacena las contraseñas activas e inactivas de los usuarios.
- **Valoraciones**: Guarda las valoraciones que los usuarios dan a los documentos.
- **Documentos**: Contiene la información de cada documento, incluyendo su ID, nombre, descripción, URL, estado y categorías.
- **Publicaciones**: Almacena el historial de publicaciones de documentos realizadas por los usuarios.
- **Descargas**: Guarda un registro de cada descarga de documentos por los usuarios.
- **Visualizaciones**: Lleva un registro de cada visualización de los documentos.
- **Comentarios**: Contiene los comentarios que los usuarios dejan en los documentos.
- **Categorias**: Almacena las categorías y subcategorías de los documentos.

Para más detalles sobre las colecciones y consultas, revisa los archivos almacenados en la carpeta de Google Drive: [Colecciones y Consultas en Google Drive](https://drive.google.com/drive/u/1/folders/1CD-7wAIfdKQmvfXtXUNCFvDpwyP5HYPx).

### Modelo ER en Hackolade

El modelo entidad-relación para este proyecto está diseñado en Hackolade, donde se detalla la estructura y relaciones entre las colecciones. También puedes encontrar el archivo en la carpeta de Google Drive mencionada.

Este archivo de Hackolade define el modelo de datos para la base de datos del proyecto DocTic. Contiene la estructura de las colecciones como Usuarios, Documentos y Comentarios, especificando los campos y tipos de datos que cada una maneja. Asimismo, el modelo incluye subdocumentos y listas que organizan la información relacionada dentro de los documentos de cada colección. A través de claves foráneas, establece relaciones entre colecciones, facilitando conexiones entre los datos como por ejemplo la asociación de documentos a usuarios o la asignación de comentarios a documentos específicos. Estas definiciones ayudan a garantizar la integridad de los datos mediante reglas de validación, como campos obligatorios y tipos de datos requeridos.

Al abrir este archivo en Hackolade, se puede visualizar y documentar el diseño de la base de datos a través de diagramas. Estos muestran de manera gráfica la estructura y las relaciones entre las colecciones.






## Consultas Destacadas

Se han implementado varias consultas avanzadas para obtener información detallada sobre el uso y la interacción con los documentos. 

Estas consultas de MongoDB utilizan agregaciones para obtener información clave de la base de datos, permitiendo analizar el comportamiento y las preferencias de los usuarios en una plataforma de documentos. La mayoría de estas consultas buscan patrones de popularidad y calidad, como la identificación de las categorías de documentos más vistas, descargadas o valoradas, tanto en general como por regiones específicas, lo que facilita el ajuste del contenido a las demandas del público. Además, algunas consultas rastrean interacciones específicas, como la relación entre descargas y valoraciones de calidad, usuarios activos que no participan en publicaciones, y documentos populares que generan opiniones mixtas, útil para evaluar el impacto y la controversia del contenido.

Estas consultas ofrecen una funcionalidad robusta para gestionar y mejorar la experiencia del usuario en la plataforma, proporcionando estadísticas sobre el uso y el impacto del contenido. Esto permite tomar decisiones informadas, como mejorar la visibilidad de ciertos documentos, identificar usuarios influyentes, o detectar contenido que podría requerir promoción adicional o mejoras en su calidad.

Para más detalles sobre las consultas realizadas y su implementación, consulta el siguiente enlace: [Consultas en Google Docs](https://docs.google.com/document/d/1LAxwvMZnJH3SKNu27BQD3i5ePWEj5jyYX0q3xzPuiQE/edit?tab=t.0).


## Instalación

1. Clona el repositorio en tu máquina local.
2. Configura una base de datos MongoDB y carga las colecciones con la estructura definida en la carpeta de Google Drive.
3. Utiliza el cliente MongoDB para interactuar directamente con la base de datos.

## Uso

1. Realiza consultas en MongoDB para obtener análisis de popularidad, opiniones mixtas, y otras estadísticas.
2. Gestiona los documentos, usuarios y categorías directamente desde la base de datos o mediante postman.
