# Proyecto DocTic

Este proyecto, **DocTic**, es un sistema de gestión de documentos que permite almacenar, organizar, visualizar y valorar documentos. El sistema incluye funcionalidades para la administración de documentos, usuarios, categorías y permite realizar un seguimiento detallado de las interacciones de los usuarios con el contenido.

## Funcionalidades Principales

1. **Gestión de Documentos**: Permite agregar, editar y eliminar documentos, cada uno de los cuales puede tener una descripción, una URL, un estado de visibilidad (público o privado), y pertenecer a una o varias categorías.
2. **Visualización de Documentos**: Los usuarios pueden visualizar documentos, y el sistema lleva un registro de cada visualización.
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

## Consultas Destacadas

Se han implementado varias consultas avanzadas para obtener información detallada sobre el uso y la interacción con los documentos. Estas incluyen:

1. **Documentos con Opiniones Mixtas y Populares**: Consulta para encontrar documentos que han recibido tanto valoraciones positivas (>= 4) como negativas (<= 2) y que tienen un número de visualizaciones superior a un umbral específico. Esta consulta es útil para identificar documentos controversiales que generan debate.

2. **Documentos con Descargas Superiores al Promedio**: Consulta para listar documentos que tienen un número de descargas superior al promedio general de descargas. Esto permite destacar los documentos más populares.

Para más detalles sobre las consultas realizadas y su implementación, consulta el siguiente enlace: [Consultas en Google Docs](https://docs.google.com/document/d/1LAxwvMZnJH3SKNu27BQD3i5ePWEj5jyYX0q3xzPuiQE/edit?tab=t.0).

## Requisitos

- MongoDB Compass: Utilizado para almacenar y gestionar los datos del sistema.
- Node.js y MongoDB Shell (si se realizan consultas avanzadas en línea de comandos).

## Instalación

1. Clona el repositorio en tu máquina local.
2. Configura una base de datos MongoDB y carga las colecciones con la estructura definida en la carpeta de Google Drive.
3. Utiliza el cliente MongoDB para interactuar directamente con la base de datos.

## Uso

1. Realiza consultas en MongoDB para obtener análisis de popularidad, opiniones mixtas, y otras estadísticas.
2. Gestiona los documentos, usuarios y categorías directamente desde la base de datos o mediante postman.
---

**Nota**: Para obtener más detalles sobre las consultas específicas implementadas en el sistema, consulta el [documento de consultas en Google Docs](https://docs.google.com/document/d/1LAxwvMZnJH3SKNu27BQD3i5ePWEj5jyYX0q3xzPuiQE/edit?tab=t.0).
