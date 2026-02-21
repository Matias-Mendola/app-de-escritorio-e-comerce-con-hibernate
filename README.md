# 🛒 Sistema de Gestión E-Commerce (Desktop)

Aplicación de escritorio desarrollada en Java utilizando Hibernate como framework de persistencia y MySQL como base de datos.

El sistema permite gestionar ventas, clientes, productos y empleados, simulando el flujo básico de un sistema de comercio electrónico.

---

## 🚀 Tecnologías Utilizadas

- Java 21
- Hibernate ORM
- MySQL
- Maven
- Swing (Interfaz gráfica)
- JPA Annotations

---

## 🧱 Arquitectura del Proyecto

El proyecto está estructurado en capas siguiendo buenas prácticas:

- **model/** → Entidades JPA
- **repository/** → Acceso a datos (DAO)
- **service/** → Lógica de negocio
- **controller/** → Manejo de eventos y conexión con la vista
- **view/** → Interfaz gráfica (Swing)

Esto permite mantener separación de responsabilidades y un código más mantenible.

---

## 📦 Funcionalidades Principales

- Registro de clientes
- Gestión de productos
- Control de stock automático
- Registro de ventas
- Asociación de ventas con cliente y empleado
- Cálculo automático de total y cantidad de artículos
- Relación OneToMany entre Venta y LineaDeVenta
- Consultas por ID de venta para obtener detalle

---

## 🗄️ Base de Datos

El proyecto utiliza MySQL.

### Crear base de datos:

sql
CREATE DATABASE ecomerce_db;
1️⃣ Ir al archivo:

src/main/resources/hibernate.cfg.xml

2️⃣ Configurar las credenciales:

<property name="connection.url">jdbc:mysql://localhost:3306/ecomerce_db</property>
<property name="connection.username">TU_USUARIO</property>
<property name="connection.password">TU_PASSWORD</property>
3️⃣ Verificar que el servicio de MySQL esté corriendo.

📌 Generación automática de tablas

El proyecto utiliza:

<property name="hbm2ddl.auto">update</property>

Esto permite que Hibernate cree o actualice automáticamente las tablas al iniciar la aplicación.

🧠 Conceptos Aplicados

ORM (Object Relational Mapping)

Relaciones @OneToMany y @ManyToOne

Manejo de transacciones con Hibernate

Lazy vs Eager loading

Separación por capas

Patrón Repository

Manejo de SessionFactory

Control de stock dentro de la lógica de negocio

📌 Mejoras Futuras

Implementar validaciones más robustas

Agregar manejo de excepciones personalizado

Implementar logging estructurado

Migrar a Spring Boot

Implementar autenticación

Implementar exportación de reportes


