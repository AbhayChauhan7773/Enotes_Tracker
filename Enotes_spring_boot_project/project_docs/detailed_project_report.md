# Running head: SECURE NOTES MANAGEMENT SYSTEM

# Secure Notes Management System with Spring Security

## Project Report

### Student Details

Name: Abhay Singh Chouhan  
Program: MCA  
Project Area: Cloud Security  
Project Title: Secure Notes Management System with Spring Security  

---

## Abstract

This project report presents the design, development, and functional study of a secure web-based notes management application developed using Spring Boot. The project was chosen because note management is a simple daily activity, yet it involves many important software engineering concepts such as authentication, authorization, data storage, user experience, security hardening, session-based access control, and database connectivity. Instead of selecting a topic that remains only theoretical, I wanted to build a project that can be understood clearly, tested practically, and explained confidently during evaluation. The result is a working application in which users can register, sign in securely, create their own notes, view previously saved notes, update note content, and delete notes when no longer needed.

The application solves a practical problem. Many users still store notes in notebooks, random files, unsecured text documents, or scattered applications. These methods create issues such as poor organization, weak access control, accidental deletion, and inconvenience in retrieval. In academic and professional environments, even a small amount of information can become important later. Therefore, a centralized and authenticated system for storing personal notes can improve usability and basic security. This project focuses on building such a system with user-based data separation. A note created by one user is connected to that specific user, and other users cannot edit or delete it through the normal application flow.

The project uses Java 17, Spring Boot, Spring MVC, Spring Security, Spring Data JPA, Hibernate, Thymeleaf, Bootstrap, MySQL, and Maven. These technologies were selected because they support modern enterprise-style development while still being suitable for an academic mini-project. Spring Boot helps in rapid application setup and reduces manual configuration. Spring MVC supports request handling and page navigation. Spring Security provides the login framework and request protection. Spring Data JPA simplifies database operations. Hibernate performs object-relational mapping. Thymeleaf renders dynamic web pages. MySQL stores user and note data. Maven manages project dependencies and build configuration.

One of the major strengths of the project is the inclusion of security logic beyond basic login. Passwords are not stored in plain text. Instead, BCrypt hashing is used before persistence. In addition, the application tracks failed login attempts. If invalid credentials are entered repeatedly, the account is temporarily locked for fifteen minutes. This feature demonstrates how even a student-level project can move beyond ordinary CRUD functionality and include meaningful defensive behavior. When the lock duration is over, the account can be unlocked automatically during a later authentication attempt. This improves the educational value of the project and also aligns the application with real security practices.

The development approach followed a layered structure. The entity layer contains the `User` and `Notes` models. The repository layer manages persistence using `UserRepository` and `NotesRepository`. The service layer includes core business logic related to user registration, password encryption, failed-attempt tracking, reset behavior, account locking, and unlock timing. The controller layer is divided into a public-facing `HomeController` and an authenticated `UserController`. Configuration classes define security filters, password encoding, custom authentication behavior, and user details integration. This separation made the project easier to understand, implement, and maintain.

From a research point of view, the study uses a descriptive and exploratory methodology. It is descriptive because the project documents the structure, features, and behavior of the system. It is exploratory because it investigates how a secure notes application can be implemented using Spring Boot and related technologies. The report explains the rationale for topic selection, objectives, hypotheses, literature support, methodology, system design, implementation, findings, limitations, and future scope. The work therefore combines a practical software product with academic presentation.

The final application successfully demonstrates user registration, secure login, password protection, account lock handling, note ownership, and note CRUD operations. The project also shows the importance of environment-based configuration through the use of database environment variables. Although the current scope is limited to single-user-role note management and does not include advanced features such as search, attachments, note sharing, or admin dashboards, the application is stable enough to serve as a meaningful academic case study and a solid foundation for future extension.

Overall, this project proves that a secure notes management system can be implemented effectively using Spring Boot with a clean structure and understandable logic. It also reflects my learning in backend development, UI integration, data persistence, and application security. The project is relevant to both technology and business because secure information handling is a common requirement across industries. The report that follows explains the entire project in detail, from idea selection to architecture, implementation, testing, findings, and future opportunities.

## Chapter 1: Introduction

### 1.1 Background of the Study

In the digital age, people create and handle information continuously. Students make notes from lectures, professionals write reminders and quick records, and individuals store personal observations for later use. Even though digital devices are widely used, the way many people manage notes is still unstructured. Some rely on paper notebooks, while others use text files, messaging apps, or unorganized documents. These methods often lack consistency, searchability, and security. A person may forget where the information was written, accidentally lose a file, or expose personal data through poor access control. These concerns become more important when the information is academic, professional, or semi-confidential in nature.

This project was developed to address that situation in a practical and understandable way. Instead of choosing a complex enterprise domain that would be difficult to implement within academic time limits, I selected a problem that is simple to understand but rich in technical value. A notes management system seems basic at first, but when implemented as a secure multi-user web application, it becomes a strong learning project. It involves frontend rendering, backend request processing, database persistence, security configuration, session-aware user handling, and data ownership enforcement. Because of that, the topic provides both practical relevance and educational depth.

The project builds a secure notes application using Spring Boot. The system allows a new user to register, sign in using an email and password, and then manage personal notes. Each note belongs to the logged-in user. The system prevents normal unauthorized access to note operations by securing user routes under Spring Security. The project also tracks failed sign-in attempts and temporarily locks the account after repeated invalid logins. This addition strengthens the project's specialization relevance because the selected stream is cloud security, and the application demonstrates basic authentication hardening.

### 1.2 Context of the Problem

The problem addressed in this project is not limited to students alone. In a business setting, employees maintain daily task notes, small operational records, issue descriptions, and reminders. In academic settings, learners keep lecture notes, lab observations, and topic summaries. A secure application for storing such information helps improve organization and basic privacy. Although many commercial note-taking products already exist, building such a system from scratch is valuable in a learning environment because it allows the developer to understand underlying mechanisms rather than simply using a ready-made tool.

The context of this project is therefore both educational and practical. Educationally, it helps demonstrate concepts taught in software engineering, web development, database management, and information security. Practically, it provides a working example of how a secure CRUD application can be built for personalized data handling. The system is not designed for very large-scale enterprise deployment, but it is well suited for academic demonstration and future extension.

### 1.3 Purpose of the Project

The main purpose of this project is to design and implement a secure web-based notes management system that supports individual users. The project aims to show how a Spring Boot application can combine security, persistence, and user interaction in a structured way. It also aims to document the complete development process in a report format suitable for project evaluation.

This purpose can be viewed at two levels. The first is the software level, where the aim is to develop a functional application that supports registration, login, add note, view notes, edit notes, and delete notes. The second is the academic level, where the aim is to demonstrate conceptual understanding of system design, layered architecture, research methodology, security integration, testing, and report preparation. The report therefore acts as a bridge between the working software and the academic evaluation process.

### 1.4 Relevance to Specialization

The chosen project area is cloud security. Even though the application is a traditional server-rendered web application, it aligns with the specialization because secure user access and data protection are core concerns in any cloud-based or network-accessible system. The use of Spring Security, password hashing, role-based route restrictions, and account locking directly relates to foundational security concepts. The project does not attempt to implement advanced cloud-native security mechanisms such as distributed identity, zero-trust policy, or multi-factor authentication, but it demonstrates core secure design ideas in a controlled project scope.

By selecting this topic, I was able to create a project that fits both application development and security learning. This combination was important because a strong academic project should not only work technically but should also relate to the domain of specialization in a clear way. Secure note management provides that connection.

### 1.5 Significance of the Study

The significance of this project lies in its balance between simplicity and depth. The topic is familiar enough that a guide, examiner, or reader can quickly understand its purpose. At the same time, the implementation includes several important technical layers. The project is significant because it demonstrates:

1. A real-world problem translated into a web application.
2. Secure user registration and login.
3. Password protection using BCrypt.
4. User-based data ownership for notes.
5. Failed login tracking and temporary account locking.
6. Database-driven application behavior.
7. Separation of concerns through layered design.
8. Academic documentation of a practical software project.

The study is also significant for personal learning. It strengthened my understanding of the Spring ecosystem and taught me how configuration, entities, repositories, services, controllers, templates, and security logic work together. It improved my confidence in explaining a complete application from concept to implementation.

### 1.6 Structure of the Report

This report is organized into multiple chapters to make the project easy to follow. After the introduction, the next chapter explains the problem statement, aims, objectives, and scope. The literature review summarizes relevant concepts from web development, security, and data management. The methodology chapter explains how the study was carried out. Subsequent chapters describe system analysis, architecture, module design, database design, implementation details, test observations, findings, limitations, recommendations, and conclusion. This structure ensures that both technical and academic expectations are covered in a systematic way.

## Chapter 2: Problem Statement, Aim, Objectives, and Scope

### 2.1 Problem Statement

The central problem addressed in this project is the lack of a simple, secure, and personalized system for managing notes through the web. Many note-handling methods are either manual or weakly secured. Physical notebooks are easy to lose or damage. Basic digital files may not provide authentication. Scattered note storage makes retrieval difficult. Insecure handling of personal information can also lead to unauthorized access.

The problem becomes more important when viewed from a software engineering angle. Many student projects focus only on basic CRUD features without giving enough attention to security and ownership. As a result, they do not fully represent the requirements of a realistic application. This project addresses that gap by building a notes management application that includes both functional behavior and security features. The problem statement can therefore be formulated as follows:

How can a secure, simple, and user-specific notes management application be designed and implemented using Spring Boot, MySQL, and Spring Security so that authenticated users can manage personal notes efficiently while maintaining basic access control and account protection?

### 2.2 Need for the Study

The study is needed for several reasons. First, note-taking remains a universal activity, but people do not always handle notes in an organized or protected manner. A secure digital solution can reduce disorder and improve reliability. Second, from an academic perspective, students require projects that demonstrate applied learning rather than only theoretical discussion. A secure notes system provides the right level of complexity for this purpose. Third, this project shows how security can be integrated even in a small system, which makes it valuable for cloud security specialization.

Another reason for the study is that secure application development is best understood through implementation. Reading about authentication and access control is useful, but actual understanding becomes stronger when a student configures secure routes, hashes passwords, checks user ownership, handles failed attempts, and observes the result in a running application. This study therefore transforms textbook concepts into a practical learning experience.

### 2.3 Aim of the Project

The main aim of the project is to develop a secure web-based notes management system using Spring Boot that allows authenticated users to create, view, edit, and delete personal notes safely and efficiently.

### 2.4 Objectives of the Project

The project objectives are listed below:

1. To create a registration system for new users.
2. To allow secure user login through Spring Security.
3. To encrypt passwords using BCrypt before storing them in the database.
4. To assign an application role to the registered user.
5. To enable authenticated users to add notes.
6. To enable users to view only their own notes.
7. To support editing and deleting of notes by the owner.
8. To implement failed login attempt tracking.
9. To lock the user account temporarily after repeated failed login attempts.
10. To unlock the account automatically after the configured duration has expired.
11. To use MySQL for persistent storage of users and notes.
12. To use Thymeleaf and Bootstrap for a clear browser-based interface.
13. To document the development and findings of the project in a formal report.

### 2.5 Research Questions

This project is guided by the following research questions:

1. Can a secure notes management system be developed effectively using Spring Boot and MySQL?
2. Does the use of authentication, password hashing, and user-specific note mapping improve application security compared with unsecured note handling?
3. Can account locking after repeated failed login attempts be integrated into a student-level project in a simple but meaningful way?
4. Does a layered application design make the system easier to understand and maintain?
5. Is the resulting project suitable as an academic demonstration of both application development and security concepts?

### 2.6 Hypotheses

Null Hypothesis (H0): The implementation of a secure web-based notes management system does not significantly improve note management efficiency and access control when compared with conventional note handling methods.

Alternative Hypothesis (H1): The implementation of a secure web-based notes management system significantly improves note management efficiency and access control when compared with conventional note handling methods.

### 2.7 Scope of the Project

The scope of the project is intentionally defined so that the work remains realistic and complete within the available time. The system supports user registration, secure login, note creation, note retrieval, note modification, note deletion, user-note mapping, password protection, and account lock handling. The application is browser-based and uses a server-side rendered interface. It is designed primarily for individual users rather than teams or organizations.

The report also covers the conceptual and technical scope. It explains the business relevance, supporting literature, research methodology, system architecture, module flow, and implementation decisions. It includes references and evaluative observations. This makes the scope both software-oriented and academically documented.

### 2.8 Limitations of the Scope

The project does not include every feature that a commercial notes platform might offer. It does not support note sharing, role hierarchy beyond one user role, search, sorting, tagging, file attachments, reminders, password reset by email, audit dashboard, or REST API clients. It also does not implement distributed architecture, microservices, containerization, or cloud deployment. These exclusions are deliberate because the aim is to demonstrate a secure and well-structured academic application rather than a complete enterprise platform.

## Chapter 3: Literature Review

### 3.1 Introduction to the Literature Review

The literature review provides theoretical support for the project and situates the developed system within the broader context of information systems, secure web application development, and database-driven architecture. A literature review in a project of this type does not only summarize books or articles. It also connects prior concepts and recognized practices with the implemented application. In this project, the main literature themes include digital information management, structured software architecture, authentication and authorization, secure password handling, relational persistence, and web application usability.

### 3.2 Digital Information Management

Modern organizations and educational environments depend heavily on digital information. Literature on information systems emphasizes that digital data becomes more useful when it is organized, searchable, and easy to maintain. When notes are stored in a structured system rather than scattered across disconnected files, retrieval becomes easier and consistency improves. Researchers and practitioners often highlight the importance of centralization because fragmented information handling increases both operational inefficiency and the risk of data loss.

This project follows that principle by creating a centralized application in which notes are stored in a database and accessed through authenticated workflows. The system demonstrates how even a small information system can provide structure and control compared with unorganized methods of record keeping.

### 3.3 Structured Software Architecture

Software engineering literature frequently recommends layered architecture because it separates responsibilities and improves maintainability. When application logic is divided into presentation, business, data access, and configuration layers, developers can understand and modify the system more easily. Such architecture also supports better testing and cleaner code organization.

The developed project reflects this idea by using entity classes for models, repository interfaces for persistence, service classes for business logic, controllers for request handling, and configuration classes for security and infrastructure concerns. This structure is widely recognized as a good practice in enterprise Java development. The literature supports such modular design because it reduces tight coupling and increases clarity.

### 3.4 Authentication and Authorization

Authentication and authorization are central topics in information security. Authentication verifies the identity of the user, while authorization determines what the authenticated user is allowed to access. Literature in web security repeatedly points out that weak authentication mechanisms create serious risk. If a system does not validate users properly, or if it allows unrestricted access to protected resources, the confidentiality and integrity of data can be compromised.

In this project, Spring Security is used to manage authentication and route protection. User-specific routes under `/user/**` are restricted to users with the `USER` role. This follows recognized practice by separating public and protected resources. Although the project uses a simple single-role model, it still demonstrates the essential distinction between anonymous and authenticated access.

### 3.5 Secure Password Storage

Password storage is one of the most basic but most important aspects of application security. Security literature strongly discourages plain text password storage because anyone with database access can immediately misuse the credentials. Even weak hash mechanisms are considered risky because they can be attacked using precomputed tables or fast brute-force tools. As a result, secure hash algorithms with salting and computational cost are commonly recommended.

BCrypt is one of the most accepted approaches for password hashing in application development. It is designed to be intentionally slower than ordinary hashing, which makes brute-force attacks more difficult. This project uses `BCryptPasswordEncoder` for password protection. The literature supports this choice because BCrypt is simple to integrate and widely trusted in practical systems. Including BCrypt in the project strengthens both the application and the academic explanation of security controls.

### 3.6 Login Attempt Monitoring and Account Locking

Another recurring idea in security literature is defense against repeated login attempts. If an attacker can try passwords without restriction, even a protected login system becomes vulnerable to brute-force behavior. One basic mitigation is account lock or temporary delay after multiple failed attempts. Although such mechanisms are not perfect and must be balanced against user convenience, they remain a common defensive measure.

This project adopts that concept by incrementing a failed attempt counter for the user. When the failed attempt count reaches the defined threshold, the account is marked as locked and the lock time is stored. The system then checks whether enough time has passed to unlock the account. This pattern is simple but meaningful, and it reflects how theoretical security ideas can be introduced into a student project without making the implementation too complex.

### 3.7 Object-Relational Mapping and Persistence

Database literature emphasizes the importance of structured storage and data relationships. In relational databases, entities are organized into tables with keys and constraints. In object-oriented programming, data is represented through classes and objects. Object-relational mapping bridges these two worlds by allowing developers to work with objects while the framework manages SQL generation and data persistence.

Hibernate and JPA are widely used for this purpose in Java ecosystems. They reduce boilerplate code and make data access more readable. In this project, JPA entities represent users and notes, while repositories provide persistence operations. The `Notes` entity includes a many-to-one relationship with `User`, which supports the concept of note ownership. Literature supports this model because it reflects normalized data design and clean domain mapping.

### 3.8 Server-Side Rendering and Usability

Web application literature often distinguishes between client-heavy interfaces and server-side rendered applications. For academic projects, server-side rendering remains a practical choice because it reduces frontend complexity while still enabling dynamic views. Thymeleaf is frequently recommended in Java-based systems for this purpose because it integrates directly with Spring MVC and supports straightforward template binding.

Usability is also a recognized requirement in system success. A secure application that is too difficult to use may fail in practice because users choose easier but less secure alternatives. This project therefore uses Bootstrap and Thymeleaf to provide readable forms and simple page flows. The aim is not to build a highly stylized interface but to create one that is functional, understandable, and suitable for demonstration.

### 3.9 Academic and Practical Gap

Many academic mini-projects demonstrate only CRUD operations with little attention to security. On the other hand, enterprise systems often include security frameworks that may seem too large or abstract for a student-level implementation. This project fills the gap by showing that meaningful security can be introduced into a moderate-sized academic application. It does not claim to solve all security problems, but it demonstrates authentic concepts such as password hashing, route protection, failed login monitoring, and ownership-based data handling.

### 3.10 Summary of Literature Review

The literature review supports the key design choices of the project. It shows that centralized information management improves organization, layered architecture improves maintainability, authentication and authorization are essential for access control, BCrypt is a suitable approach for password protection, temporary account locking is a recognized defense against repeated failures, ORM simplifies persistence, and usability matters alongside security. These ideas collectively justify the design of the secure notes management system presented in this report.

## Chapter 4: Research Methodology

### 4.1 Introduction

Research methodology explains how the project was planned, developed, studied, and evaluated. In a software project, methodology does not only mean statistical analysis. It also includes the overall approach used to transform a problem into a working solution and to document that solution in an academically meaningful way. This chapter explains the design type, data sources, sampling logic, development flow, and analytical approach used in the present project.

### 4.2 Research Design

The project follows a descriptive and exploratory research design.

It is descriptive because it documents the design, structure, modules, and behavior of the developed system. The report describes how the application is organized, how the security logic functions, how notes are stored, and how users interact with the application.

It is exploratory because the project investigates how a secure note management solution can be built using Spring Boot, Spring Security, JPA, Thymeleaf, and MySQL. Rather than beginning with a finished standard model, the work explores an implementation path based on the selected technology stack and project goals.

This mixed descriptive-exploratory design is suitable because the project has both practical implementation and analytical explanation.

### 4.3 Nature of the Study

The study is primarily applied in nature. Its purpose is not to produce abstract theory alone but to build a functioning software solution and then analyze that solution in relation to the original objectives. The project is also qualitative in explanation, because much of the discussion involves system behavior, design rationale, module interaction, and findings derived from observation of application functionality. However, the project also includes a limited logical basis for hypothesis discussion through comparison between secured and unsecured note-handling approaches.

### 4.4 Sources of Data

The project uses both primary and secondary sources of data.

Primary sources include:

1. Observations during implementation and execution of the application.
2. Functional testing of registration, login, note creation, note viewing, note editing, and note deletion.
3. Observation of account locking after repeated failed login attempts.
4. Review of application responses and page flow during normal use.

Secondary sources include:

1. Official Spring Boot documentation.
2. Official Spring Security documentation.
3. Spring Data JPA documentation.
4. Hibernate ORM references.
5. Thymeleaf documentation.
6. Bootstrap documentation.
7. Java documentation.
8. MySQL documentation.
9. Standard academic textbooks on Java, databases, and information systems.

These sources support both the implementation and the academic explanation of the project.

### 4.5 Sampling Technique

The project uses a non-probability approach in the sense that system behavior is evaluated through representative use cases rather than through random sampling of a population. This is common in software project studies where the objective is to validate whether key operations work correctly. The selected use cases include:

1. New user registration.
2. Registration with an existing email.
3. Login with correct credentials.
4. Login with incorrect credentials.
5. Account lock after repeated failures.
6. Unlock behavior after the configured time.
7. Add note after successful login.
8. View notes linked to the logged-in user.
9. Edit a note owned by the logged-in user.
10. Delete a note owned by the logged-in user.

These use cases provide practical coverage of the application's major features.

### 4.6 Data Collection Tools

The project uses several tools and mechanisms for data collection and validation:

1. Manual functional testing through browser interaction.
2. Observation of redirected pages and messages.
3. Inspection of application classes and configuration.
4. Verification of stored values in the database.
5. Review of the source code for implemented logic.

In addition, the project includes a minimal test class for application context loading. Although automated testing is limited in the present version, the application still supports structured validation at the implementation level.

### 4.7 Data Preparation

Data preparation in this project refers to organizing observations and functionality into structured modules so that each feature can be described and evaluated clearly. The system was divided into registration, authentication, security and account-lock logic, notes CRUD, persistence, and presentation. Each module was then studied through its inputs, processing logic, and outputs. This classification helped prepare the material for analysis and report writing.

### 4.8 Data Analysis

The project uses logical and functional analysis rather than complex statistical analysis. The observed behavior of the system was compared against the intended objectives. If a new user registers with a fresh email, the record should be saved. If the email already exists, registration should be blocked. If the password is stored, it should appear in hashed form rather than plain text. If login succeeds, the user should be redirected to the notes area. If login fails repeatedly, the account should be locked. If a user accesses note operations, only owned notes should be editable or deletable. This comparison-based analysis is suitable for a project where the purpose is to evaluate whether implemented features behave as designed.

### 4.9 Methodological Justification

The selected methodology is appropriate because the project is both practical and explanatory. A purely statistical approach would not capture the value of architecture, module structure, and security configuration. At the same time, a purely descriptive narrative without validation would weaken the technical credibility of the project. The current methodology balances both needs by combining documentation, module-based validation, and functional observation.

### 4.10 Ethical and Originality Considerations

The project has been developed as an original academic work based on my own implementation and understanding of the selected technologies. References have been included for conceptual and technical sources used during development and study. The report is written to explain the actual project that has been built, rather than presenting an unrelated theoretical document. This alignment between implementation and documentation is important for academic honesty and meaningful project evaluation.

### 4.11 Summary of Methodology

The methodology chapter shows that the project uses a descriptive and exploratory design, relies on both primary and secondary data, validates representative use cases, and analyzes the application based on intended versus observed behavior. This approach is suitable for a software project that aims to demonstrate secure application development in an academically acceptable form.

## Chapter 5: System Analysis

### 5.1 Existing Scenario

Before developing the proposed system, it is useful to consider the existing scenario of note management. In many situations, users write notes on paper or keep them in basic digital files. While these methods may seem quick and simple, they have limitations. Physical notebooks can be misplaced or damaged. Text files may be scattered across folders and devices. Some users keep notes in messaging applications, where retrieval becomes difficult later. Other users store notes in unsecured documents that can be opened by anyone with device access. These methods are usually not built around authenticated personal access or structured retrieval.

From a software engineering perspective, the existing scenario also reflects a common student-level weakness: many simple note projects do not protect user data properly. They may allow all notes to be viewed together or may not enforce user ownership in the data model. This reduces the educational value of the system because real applications must consider who can see and modify specific records.

### 5.2 Problems in the Existing Scenario

The main problems in the existing scenario are lack of centralization, weak or absent access control, poor organization and retrieval, risk of accidental loss, no structured user-note relationship, absence of authentication hardening, and limited demonstration of software engineering practices. These problems justify the need for a secure and structured system.

### 5.3 Proposed System

The proposed system is a web-based notes management application developed using Spring Boot. It provides a secure environment where users can register and then sign in to manage their personal notes. The system uses authentication to ensure that only logged-in users can access note-related pages. It maps each note to a specific user in the database. It hashes passwords before saving them and uses login attempt monitoring to lock the account temporarily after repeated failures.

The system is designed to be simple for the user but meaningful from a technical point of view. The interface is based on Thymeleaf templates and Bootstrap styling. The backend handles requests through controllers, services, repositories, and configuration classes.

### 5.4 Functional Requirements

The functional requirements of the proposed system are:

1. The system shall allow a new user to register.
2. The system shall check whether the email already exists.
3. The system shall save the user with a default role.
4. The system shall encrypt the password before saving it.
5. The system shall allow a registered user to sign in.
6. The system shall allow the user to add a new note.
7. The system shall allow the user to view all notes linked to that user.
8. The system shall allow the user to update an existing owned note.
9. The system shall allow the user to delete an existing owned note.
10. The system shall track failed login attempts.
11. The system shall lock the account after repeated login failures.
12. The system shall unlock the account after the lock period has expired.

### 5.5 Non-Functional Requirements

The non-functional requirements include security, reliability, usability, maintainability, performance, and portability. User authentication and password hashing must be enabled. The system should save and retrieve data consistently. Forms and pages should be simple and understandable. Code should be structured in logical layers. The system should respond quickly for a small number of users. The project should run on a standard Java and MySQL environment.

### 5.6 Feasibility Analysis

Technical feasibility is high because the required tools and frameworks are widely available and suitable for academic use. Spring Boot supports rapid development, MySQL is easy to install and use, and Thymeleaf works smoothly with server-side rendering. Economic feasibility is also positive because the project uses mostly open-source tools and frameworks with low development cost. Operational feasibility is strong because the expected users can understand and use the system easily. Schedule feasibility is also satisfactory because the selected feature set remains realistic for an academic timeline.

### 5.7 Summary of System Analysis

The analysis shows that the existing methods of note management are often insecure or unstructured, while the proposed system addresses these limitations with a secure and user-specific web application. The project is technically, economically, operationally, and schedule-wise feasible.

## Chapter 6: System Design and Architecture

### 6.1 Overview of the Design

The system follows a layered design approach. This design was selected because it is easier to understand, explain, and maintain. The application is divided into the presentation layer, controller layer, service layer, repository layer, entity layer, and configuration layer. Each layer has a specific responsibility. This separation reduces confusion and supports cleaner development.

### 6.2 High-Level Architecture

At a high level, the system works as follows. The user interacts with the browser interface rendered through Thymeleaf templates. Requests are sent to Spring MVC controllers. Controllers call service methods or repositories as needed. Services execute business rules such as password encoding and account lock logic. Repositories communicate with the database through Spring Data JPA. Entities represent database tables and relationships. Spring Security filters protect routes and control authentication behavior. This flow demonstrates how user actions move through the application from the interface to persistence and back.

### 6.3 Presentation Layer Design

The presentation layer uses Thymeleaf templates located in the `templates` directory. The major pages include `index.html` for the home page, `register.html` for user registration, `login.html` for sign in, `add_notes.html` for note creation, `view_notes.html` for displaying saved notes, `edit_notes.html` for updating existing notes, and `base.html` as a reusable layout. The pages are designed to keep the interaction simple. This is appropriate for an academic project where readability and clear flow are more important than complex visual design.

### 6.4 Controller Layer Design

The controller layer contains the classes that receive user requests and decide what response should be returned. The `HomeController` manages public routes such as the home page, registration page, user save request, and sign-in page. The `UserController` manages authenticated routes under `/user`. It loads the currently logged-in user through the `Principal`, adds the user to the model, and supports note operations including add, view, edit, update, and delete. This separation of public and protected responsibilities makes the application easier to understand.

### 6.5 Service Layer Design

The service layer is represented mainly by `UserService` and `UserServiceImpl`. This layer contains business rules such as setting the default role for a new user, encoding the password using BCrypt, initializing failed login counters, increasing the failed attempt count on login failure, resetting the failed attempt count on login success, locking the user account, and unlocking the account if the lock duration has expired. Placing this logic in the service layer improves clarity. Controllers remain focused on request handling while the service handles business behavior.

### 6.6 Repository Layer Design

The repository layer uses Spring Data JPA interfaces. The `UserRepository` supports operations like checking whether an email exists and finding a user by email. The `NotesRepository` supports retrieving notes by user as well as standard persistence operations through inherited JPA methods. This layer abstracts direct database interaction. Instead of writing manual SQL for basic operations, the project uses repository methods that are readable and concise.

### 6.7 Entity Layer Design

The entity layer contains two main classes: `User` and `Notes`. The `User` entity stores fields such as name, qualification, email, address, gender, password, role, failed attempt count, account lock status, and lock time. The `Notes` entity stores note ID, title, description, creation date, and a many-to-one relationship to `User`. The relationship is important because it forms the basis of user-specific note ownership. A single user can have many notes, but each note belongs to one user.

### 6.8 Security Design

Security is one of the core aspects of the project. The security design includes route protection using Spring Security, user detail loading through a custom user details service, password hashing using BCrypt, custom authentication success handling, custom authentication failure handling, and account lock after repeated failed login attempts. The `SecurityConfig` class restricts access to `/user/**` routes so that only users with role `USER` can access them. The login page is custom-defined at `/signin`, and the processing URL is `/userLogin`.

The success handler resets failed attempts and redirects the user to the note creation page. The failure handler checks whether the account should be locked or unlocked and updates the exception message accordingly.

### 6.9 Database Design

The database design is intentionally simple but correct for the project scope. The `User` table stores user-specific data and authentication-related attributes. The `Notes` table stores note content and includes a foreign key relationship to the user. This design supports key application needs. Each user can have multiple notes. Notes can be retrieved based on the current user. Security-related account attributes remain attached to the user record.

### 6.10 Design Principles Followed

The project follows several useful design principles such as separation of concerns, role-based route restriction, entity relationship clarity, business logic centralization, reusability of layout through a base template, and simplicity in UI flow. These principles help the project remain understandable and maintainable.

### 6.11 Summary of System Design

The system design chapter shows that the project uses a well-organized layered architecture. Each component has a defined responsibility, and the design supports secure, user-specific note management.

## Chapter 7: Technology Stack and Development Environment

### 7.1 Introduction

The choice of technology stack plays an important role in project success. For this project, I selected tools and frameworks that are widely used in Java web development and that provide a good balance between learning value and implementation feasibility. The technology stack was chosen to support security, maintainability, dynamic page rendering, and relational persistence.

### 7.2 Java 17

Java 17 is used as the programming language for the project. Java is known for portability, object-oriented structure, extensive framework support, and strong enterprise adoption. The use of Java in this project is appropriate because Spring Boot is built for the Java ecosystem and integrates naturally with standard language features. Java also supports clean class-based modeling, which is useful for representing users, notes, and service behavior.

### 7.3 Spring Boot

Spring Boot is the core framework used in the project. It simplifies setup by reducing boilerplate configuration and offering opinionated defaults. Instead of manually configuring a large number of components, Spring Boot allows developers to build web applications quickly through starter dependencies and auto-configuration. In this project, Spring Boot provides application bootstrapping, dependency integration, embedded server support, web MVC support, security integration, and JPA plus data access support. Its use is justified because it makes the project manageable while still reflecting enterprise-style architecture.

### 7.4 Spring MVC

Spring MVC handles the request-response flow of the web application. It maps routes to controller methods, binds form data to objects, and passes data to views. The `HomeController` and `UserController` use MVC concepts directly. Spring MVC is important because it connects the user interface and backend logic in a clean manner.

### 7.5 Spring Security

Spring Security is used to protect the application. It supports authentication, authorization, and customization of login success and failure behavior. For this project, it enables a custom login page, role-based route restriction, integration with user details, and security-aware login success and failure handling. This framework adds significant value because it transforms the project from a simple CRUD application into a secure web application.

### 7.6 Spring Data JPA and Hibernate

Spring Data JPA simplifies persistence by allowing repositories to handle common operations without manual SQL for every case. Hibernate acts as the ORM engine beneath JPA. Together, they manage table mapping, entity persistence, query support, and relationship handling. In this project, these frameworks help store and retrieve user and note data efficiently. They also simplify development because repository methods such as finding a user by email or notes by user are easy to define.

### 7.7 Thymeleaf and Bootstrap

Thymeleaf is used as the server-side template engine. It supports dynamic page rendering, model attribute display, and form binding. Thymeleaf fits well with Spring Boot and is appropriate for a college project because it keeps the frontend manageable while still allowing meaningful interaction. Bootstrap is used for basic styling and layout support. It helps create forms and pages that are readable and responsive. While the project does not aim for a highly customized UI design, Bootstrap improves the professional appearance and usability of the application.

### 7.8 MySQL and Maven

MySQL is used as the relational database management system. It stores user records and note records persistently. The application uses environment variables for database connection through `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD`. Maven is used for dependency management and project build configuration. The `pom.xml` file defines all required libraries, plugin configuration, Java version, and project metadata. Maven improves organization because the project can be built and run consistently using a standard structure.

### 7.9 Summary

The technology stack used in this project is appropriate, modern, and aligned with the topic. It supports secure, database-driven web development while keeping the project understandable and maintainable.

## Chapter 8: Detailed Implementation of the Project

### 8.1 Introduction

This chapter explains how the project has been implemented in code. The objective here is not only to mention the names of files but to explain the role played by each component and how the overall application flow is achieved. Since the project is a working application, a proper understanding of implementation is necessary for accurate evaluation.

### 8.2 Application Entry Point

The application starts from the main class `EnotesSpringBootProjectApplication`. This class contains the `main` method that launches the Spring Boot application using `SpringApplication.run(...)`. From the user's perspective, this is the starting point that makes the application available on the configured port. From the framework perspective, it initializes the Spring context and loads configuration, controllers, services, repositories, and templates.

### 8.3 Configuration Through Properties

The `application.properties` file defines key settings for the project. It includes the application name, server port, database connection properties, driver class, JPA DDL behavior, SQL display, and Thymeleaf template location settings. The use of environment variables for database connection is a positive design choice because it avoids storing sensitive credentials directly in source code. The properties file uses placeholders for `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD`.

### 8.4 User Entity Implementation

The `User` entity is central to the system. It includes fields for ID, name, qualification, email, address, gender, password, role, failed attempt count, account non-locked status, and lock time. These fields support both profile information and security logic. The email acts as the login identity. The password stores the BCrypt-hashed value. The role is required for authorization. The fields related to failed attempts and lock time are used for the account protection mechanism.

### 8.5 Notes Entity Implementation

The `Notes` entity stores data related to user-created notes. It includes note ID, title, description, creation date, and user reference. The `date` field uses `@CreationTimestamp`, which allows Hibernate to automatically store creation time. The `user` field is marked with `@ManyToOne`, linking the note to the corresponding user. This relationship is essential because it supports retrieval of notes by user and enforces application-level ownership checks.

### 8.6 Repository Implementation

The `UserRepository` and `NotesRepository` provide data access. The `UserRepository` supports methods such as `existsByEmail(...)` and `findByEmail(...)`. These methods are used during registration and authentication-related workflows. The `NotesRepository` supports standard CRUD through inherited JPA methods and `findByUser(User user)` for retrieving notes that belong to a particular user.

### 8.7 Service Implementation for User Logic

The `UserServiceImpl` class contains some of the most meaningful business logic in the project. The `saveUser(...)` method assigns a default role, hashes the password, initializes failed attempt values, sets the account as unlocked, and saves the user. The class also supports checking whether an email already exists, increasing failed login attempts, resetting failed attempts after successful login, locking a user account, and unlocking the account after the lock period expires.

### 8.8 HomeController Implementation

The `HomeController` handles public-facing routes. Its methods map to the home page, registration page, user save request, and sign-in page. The registration method checks whether the email already exists. If it does, a session message is set. Otherwise, the service saves the user. The use of session messages provides simple feedback on the registration result.

### 8.9 UserController Implementation

The `UserController` manages note operations for authenticated users. It includes a `@ModelAttribute` method that loads the currently logged-in user from the `Principal` and places it in the model. This is useful because user information becomes available in the protected views without repeating the same code manually in every handler. The controller supports displaying the add-note page, saving a newly created note, viewing all notes for the current user, opening the edit page for a specific note if it belongs to the user, updating a note if the user owns it, and deleting a note if the user owns it.

### 8.10 Security Configuration Implementation

The `SecurityConfig` class defines the main access rules of the application. It uses a `SecurityFilterChain` bean to restrict `/user/**` routes to users with role `USER`. Other routes are permitted publicly. The configuration also defines a custom login page at `/signin`, a login processing URL `/userLogin`, a custom success handler, and a custom failure handler. The `DaoAuthenticationProvider` is configured with the custom `UserDetailsService` and the BCrypt password encoder. This allows Spring Security to validate credentials against user records stored in the database.

### 8.11 Custom User Details and Authentication Handlers

The project includes a custom user details model and service. The custom user object adapts the application `User` entity to Spring Security's `UserDetails` interface. The custom details service loads the user from the repository using the email address. It also checks whether a locked account should be unlocked if enough time has passed. The custom authentication success handler resets failed attempts and redirects the user to `/user/addNotes`. The custom authentication failure handler performs lock-state checks and updates failed attempt counts. These classes together make the security flow more complete and better aligned with the project objective.

### 8.12 View Layer and Build Configuration

The view layer uses Thymeleaf templates combined with a base layout. The home page displays an image, the registration page allows users to enter profile and credential details, and the sign-in page supports login. After successful authentication, the user reaches the notes area. Add, edit, and view operations are handled through dedicated templates. The `pom.xml` file defines all major dependencies including starters for data JPA, security, Thymeleaf, and web, plus the MySQL driver, Lombok, and testing support. The build section includes the Spring Boot Maven plugin and PMD plugin configuration.

### 8.13 Implementation Summary

The implementation shows that the project is not a superficial UI-only application. It includes persistent storage, layered backend logic, route protection, custom security flow, and note ownership handling. The components are reasonably organized and aligned with the objectives of the project.

## Chapter 9: Module-Wise Explanation

### 9.1 Introduction

To make the project easier to evaluate, this chapter explains the application in terms of modules rather than classes alone. A module-oriented explanation is useful because it shows how the system behaves from the user's point of view and how the code supports that behavior.

### 9.2 Registration Module

The registration module allows new users to create an account. The user enters details such as name, qualification, email, address, gender, and password. When the form is submitted, the request reaches the controller. The controller checks whether the email already exists in the database. If it does, the system informs the user that the email already exists. If it does not, the service prepares the user record for storage.

At the service level, the password is encoded using BCrypt. The role is set to `ROLE_USER`. Failed attempt count is initialized to zero, the account is marked as unlocked, and the lock time is cleared. The user record is then saved. This module demonstrates input handling, validation logic, service processing, and persistence. From an academic perspective, the registration module is important because it shows the difference between raw form submission and secure user creation. A proper project should not store a password as entered by the user.

### 9.3 Login and Authentication Module

The login module begins at the sign-in page. Users enter their email and password. The form submits to the security processing URL. Spring Security then uses the custom user details service and authentication provider to validate the credentials. If the credentials are correct, the success handler resets failed attempts and redirects the user to the notes area. If the credentials are incorrect, the failure handler is invoked. Depending on the state of the account, failed attempts may increase or a lock-related message may be returned.

This module is central to the project because it transforms a normal web application into a secure one. It also shows how a standard security framework can be customized to support project-specific behavior.

### 9.4 Account Lock Security Module

This module is one of the strongest features of the project. When the login process fails, the failure handler checks whether the user exists. If the user exists and the account is not currently locked, the failed attempt count increases. Once the maximum number of failed attempts is reached, the account is locked, and the lock time is saved.

If the user attempts login again while locked, the system checks whether the lock duration has expired. If it has, the account is unlocked, failed attempts are reset, and the user can try again. If it has not, the user remains locked. This module is useful for several reasons. First, it demonstrates security thinking. Second, it adds a clear talking point during viva or project presentation. Third, it differentiates the application from ordinary CRUD projects.

### 9.5 Note Creation Module

After login, the user can create a note from the add-note page. The page contains a form for title and description. On submission, the controller receives the note object and also accesses the `Principal` to identify the logged-in user. The controller then retrieves the user entity from the database and links the note to that user before saving it. This module is important because it shows how user-specific ownership is enforced. Without mapping the note to the current user, the system would not be able to separate notes correctly later.

### 9.6 Note Viewing Module

The note viewing module allows the authenticated user to see all notes associated with their account. The controller retrieves the current user's email, loads the user entity, then fetches notes through `findByUser(user)`. The resulting note list is passed to the view and rendered on the page. This module demonstrates relational data access. It also supports the user experience by allowing previously stored information to be reviewed.

### 9.7 Note Editing Module

The note editing module begins when the user selects a note to modify. The controller loads the note by ID. Before allowing editing, the code checks whether the note exists and whether the email of the note's owner matches the current logged-in user. If the check passes, the edit page is opened with note details. On submission, the existing note is loaded again, and title and description are updated. This module highlights secure update behavior. It is not enough to edit a note by ID alone. Ownership should be verified, and the project correctly includes such a check.

### 9.8 Note Deletion Module

The deletion module follows a similar security pattern. The note is loaded by ID, and the user ownership is checked before deletion. If the logged-in user owns the note, the note is deleted. Otherwise, the request is redirected without deletion. From a learning point of view, this module reinforces the idea that delete operations must also respect ownership.

### 9.9 Layout and User Interface Module

The UI module includes the reusable layout and page templates. Even though the user interface is simple, it plays an important role in usability. The base layout provides a common visual structure. Individual pages are focused and easy to navigate. Since the application is intended as an academic project, the interface avoids unnecessary complexity and remains consistent with the system's purpose.

### 9.10 Session Message and Feedback Handling

The registration flow uses session-based messages to inform users of outcomes such as successful registration or duplicate email. The service class also includes a method for removing session messages. This is a small but useful implementation detail because applications should provide feedback to users rather than failing silently.

### 9.11 Module Integration

Although each module has been explained separately, the real value of the system comes from integration. Registration supports user creation. Authentication validates access. Security policy protects routes. CRUD modules manage notes. The database preserves state. Templates render user interactions. Together, these modules form a complete web application rather than isolated code fragments.

### 9.12 Summary of Module Explanation

This chapter shows that the project has clear functional modules with meaningful responsibilities. Each module contributes directly to the project objectives, and together they create a secure and organized note management system.

## Chapter 10: Database Design and Data Flow

### 10.1 Introduction

The database is a core part of the application because it stores all persistent information. A secure notes management system is meaningful only if user and note data can be saved, retrieved, updated, and linked correctly. This chapter explains the data model and how information moves through the system.

### 10.2 User Table Design

The user table is designed to support both profile and security information. The major fields include user ID, name, qualification, email, address, gender, password, role, failed attempt count, account non-locked status, and lock time. This design is efficient because it keeps all user-related security state in one place. The email acts as the login identity. The password stores a hashed value. The role supports authorization. The remaining fields support the account lock mechanism.

### 10.3 Notes Table Design

The notes table stores note ID, title, description, creation date, and user reference. The user reference forms a many-to-one relationship to the user table. This means many notes can belong to one user. This is the correct relationship for the problem domain because each user may create multiple notes over time.

### 10.4 Relationship Design

The user-note relationship is one of the most important parts of the database design. It ensures that notes are not floating independent records. Instead, they are owned by a specific user. This relationship supports retrieval of all notes for a given user, ownership checks before edit or delete, and clear data organization. Without this relationship, the application would struggle to enforce user-specific note handling.

### 10.5 Data Flow During Registration

During registration, the user enters profile and credential details in the form. The data is submitted to the controller, checked for email duplication, processed by the service, encoded where necessary, and finally stored in the user table. The result of this flow is a new user record ready for future authentication.

### 10.6 Data Flow During Login

During login, the entered email is used to load the matching user record through the custom user details service. The stored hashed password is compared with the entered password through Spring Security and BCrypt. If the login is successful, failed attempt data may be reset. If it fails, failed attempt count may increase, and the lock state may change. This flow shows that the login process is not just a simple comparison but a structured security-aware interaction with the stored user data.

### 10.7 Data Flow During Note Creation

During note creation, the user submits a title and description. The controller identifies the currently authenticated user, loads the corresponding user entity, assigns it to the note, and stores the note in the notes table. A creation date is also recorded automatically. This data flow is important because it ensures that every note has an owner.

### 10.8 Data Flow During Note Retrieval

When the user opens the view-notes page, the controller retrieves the current user and then fetches all notes mapped to that user. These notes are placed in the model and displayed. This flow keeps data restricted to the logged-in owner.

### 10.9 Data Flow During Note Update

When a note is edited, the note ID is used to find the existing note. The system checks ownership. If the note belongs to the current user, the new title and description are applied and the record is saved again. This flow combines data retrieval, validation, and persistence.

### 10.10 Data Flow During Note Deletion

Deletion follows a similar pattern. The note is loaded by ID, ownership is checked, and then the note is deleted if the user is authorized. This shows that data deletion is controlled and linked to security checks.

### 10.11 Importance of Data Integrity

Data integrity is important even in a small project. If user-note relationships are not handled properly, one user could potentially modify another user's data. By keeping notes linked to users and validating ownership in controller methods, the project maintains better integrity. The use of JPA entities and relationship mapping reduces manual errors and improves clarity.

### 10.12 Summary

The database design and data flow of the project are simple but effective. The chosen model supports the required features clearly, and the relationship between users and notes is correctly handled.

## Chapter 11: Security Analysis of the Project

### 11.1 Introduction

Security is one of the main reasons this project is more valuable than a basic note-taking application. In many student projects, the system is functionally correct but lacks protective controls. This chapter discusses how security has been considered in the current project and what its strengths and limitations are.

### 11.2 Authentication

Authentication is the process of verifying user identity. In this project, authentication is handled by Spring Security using a custom login page and a custom user details service. The user signs in with email and password. The system then loads the corresponding user record and validates the credentials. This is a strong choice for the project because it uses a professional framework rather than a manually written login comparison.

### 11.3 Authorization

Authorization determines what an authenticated user can access. The project restricts routes under `/user/**` to users with the `USER` role. This ensures that note operations are not openly available. Public pages such as home, registration, and sign-in remain accessible without login. Although the project uses only a single user role, this is still a valid and useful demonstration of authorization.

### 11.4 Password Hashing

Plain text passwords are unsafe because anyone who gains access to the database can read them directly. This project avoids that issue by using BCrypt password hashing. The password entered during registration is encoded before storage. Later, during login, Spring Security uses the same encoder logic to verify the password safely. This is one of the most important security features of the application.

### 11.5 Account Lock Mechanism

The account lock mechanism adds another layer of protection. If the user enters invalid credentials multiple times, the failed attempt counter increases. Once the threshold is reached, the account is locked for fifteen minutes. The lock time is stored in the user record. This feature reduces the risk of uncontrolled repeated login attempts. While it is not a complete brute-force defense on its own, it is a meaningful safeguard for a project of this scale.

### 11.6 Ownership-Based Note Protection

Route protection alone is not enough in a multi-user application. Even after login, one user should not be able to edit or delete another user's note simply by guessing an ID. The project addresses this by checking whether the current user's email matches the note owner's email before allowing edit or delete operations. This is a very important aspect of security because it adds object-level control, not just route-level control.

### 11.7 Configuration Security

The use of environment variables for database connection improves configuration handling. Rather than hard-coding database URL, username, and password directly into the properties file, placeholders are used. This encourages better practice and reduces accidental exposure of credentials through source code.

### 11.8 Security Strengths and Limitations

The main security strengths of the project are framework-based authentication, route authorization for user pages, BCrypt password hashing, failed login tracking, temporary account lock, ownership checks for note modification and deletion, and environment variable based database configuration. Like any controlled academic project, the current implementation also has limitations such as no multi-factor authentication, no password reset through secure email workflow, no rate limiting by IP address, no audit log dashboard, no advanced session management analytics, no encryption of note content at rest beyond database controls, and no dedicated admin role.

### 11.9 Security Relevance to Cloud Security Specialization

This project is relevant to cloud security specialization because any cloud-accessible system must deal with identity, access control, credential protection, and misuse resistance. Even though the project is a single application rather than a distributed cloud platform, the same core ideas apply. Identity must be verified. Access must be restricted. Credentials must be protected. Repeated unauthorized attempts should be controlled. These are foundational security principles, and the project demonstrates them clearly.

### 11.10 Summary

The project includes meaningful security measures that go beyond ordinary CRUD logic. Authentication, authorization, password hashing, account locking, and ownership checks make the system more realistic and educationally stronger.

## Chapter 12: Functional Flow and Working of the System

### 12.1 Introduction

To explain how the system works in practice, this chapter describes the end-to-end user flow. This kind of explanation is important because a guide or evaluator may want to understand not just the code structure but the actual sequence of behavior from the moment a user visits the application to the point where notes are managed securely.

### 12.2 Home Page Flow

When the application starts, the user can access the home page. This page acts as the public entry point. It provides the first visual impression of the project and helps the user navigate toward registration or sign-in. The home page uses a simple image-based presentation and works within the shared base layout structure.

### 12.3 Registration Flow

The registration flow begins when a new user opens the registration page and fills in the form. The entered information includes personal details and credentials. After form submission, the backend checks whether the email already exists. If it does, the registration does not proceed, and the user receives a message. If it does not, the system creates the user account after encoding the password and assigning the role. This flow is easy to understand and demonstrates correct user onboarding.

### 12.4 Sign-In Flow

After registration, the user can open the sign-in page and enter valid credentials. The login request is processed through Spring Security. If the credentials match the stored account, authentication succeeds, failed attempts are reset, and the user is redirected to the note management area. If invalid credentials are entered, the failure logic is triggered. Depending on the failed attempt count and lock state, the user may eventually be locked out temporarily.

### 12.5 Add Note Flow

Once authenticated, the user can open the add-note page. The form captures note title and description. When the user submits the note, the system attaches the current user to the note and saves it to the database. The user is then redirected to view the saved notes. This flow shows how the application connects authentication identity with database records.

### 12.6 View Notes Flow

In the view-notes flow, the application retrieves only those notes that belong to the current user. This is done by using the current email to load the user and then fetching notes mapped to that user. The result is displayed in a list through the view template. This flow is one of the clearest demonstrations of secure personalization.

### 12.7 Edit Note Flow

The edit flow begins when the user selects a note to modify. The application retrieves the note by ID and verifies ownership. If the logged-in user owns the note, the edit page opens. If not, the system redirects safely without exposing edit functionality. The user can then change note title and description and submit the update. The existing note is updated in the database. This flow supports data maintenance while respecting access control.

### 12.8 Delete Note Flow

The delete flow also requires ownership verification. The application loads the note by ID, checks whether the current user owns it, and deletes it only if the condition is true. The user is then redirected back to the notes list. This flow demonstrates safe deletion behavior.

### 12.9 Failed Login and Unlock Flow

If the user repeatedly enters the wrong password, the failed attempt count increases. Once the threshold is reached, the account is marked as locked. On later failed login attempts during the lock period, the user remains locked and receives an appropriate message. If the lock duration has already expired, the next relevant authentication check can unlock the account and reset the failed attempt count. This avoids permanent lockout and reflects a more user-friendly security approach.

### 12.10 Overall User Experience

The overall user experience is straightforward: open the application, register if not already registered, sign in securely, add notes, view notes, and edit or delete owned notes. This simplicity is intentional. The project aims to be clear, stable, and easy to evaluate.

### 12.11 Summary

The working flow of the system shows that the project is logically complete within its scope. Each major activity is connected to a defined backend process, and security checks are integrated at important points of interaction.

## Chapter 13: Testing, Validation, and Results

### 13.1 Introduction

Testing is necessary to verify whether the system behaves according to its objectives. In this project, testing has been approached mainly through functional validation and observation of module behavior. Because the application is intended as an academic project with a working interface, browser-based test flow and code inspection together provide meaningful evidence of correctness.

### 13.2 Testing Objectives

The main objectives of testing were to verify that registration works correctly, duplicate emails are not accepted, passwords are encoded, valid login succeeds, failed login attempts are counted, account locking occurs after repeated failures, notes can be added, viewed, updated, and deleted, note ownership is respected, and the application context loads correctly.

### 13.3 Types of Testing Used

The project mainly uses functional testing, manual integration testing, and basic context-load validation through the test class. Functional testing was performed by interacting with the application and observing whether it behaved as expected. Integration-level understanding was gained by checking how controllers, services, repositories, and security components worked together. The included test class confirms that the Spring context can load, though more automated tests can be added in future versions.

### 13.4 Test Observations

When a new user submits unique registration data, the application stores the user successfully and shows a success message. When the same email is submitted again, the registration does not proceed and an email-exists message is shown. When a registered user signs in with the correct password, authentication succeeds and the user is redirected to the add-note page. When an incorrect password is entered, the failed attempt count increases. After repeated failures, the account becomes locked. These observations confirm that the registration, authentication, and account-protection flows are functioning as intended.

### 13.5 Note Management Validation

The note creation flow works by linking the newly created note to the current authenticated user. The note can then be seen on the notes list page. Update and delete operations also work correctly when the note belongs to the logged-in user. If another user's note ID were attempted, the ownership checks in the controller would prevent unauthorized edit or delete action. These validations confirm that the note management modules are integrated correctly with authentication and data ownership.

### 13.6 Results of the Project

The project successfully meets its main functional objectives. It provides secure registration, authentication, note CRUD operations, and account lock logic. The application demonstrates that a Spring Boot based system can support secure personalized note management with a clean layered design. The results are both practical and educational. Practically, the application works as a small personal notes platform. Educationally, it demonstrates security integration, data persistence, controller-service separation, and user-specific access.

### 13.7 Testing Limitations

The current testing approach has some limitations. Automated unit tests are limited. Database-independent test configuration is not fully established. Load or performance testing is not included. Formal security penetration testing is not included. These limitations are acceptable for the present project scope but should be improved in later versions.

### 13.8 Summary

Testing and validation show that the application behaves in line with the project objectives. The major features work correctly, and the security controls are meaningfully integrated. This supports the success of the project as both a functional and academic submission.

## Chapter 14: Discussion of Findings

### 14.1 Introduction

The findings of the project should be interpreted not only as a list of working features but as evidence of how the selected technologies and design decisions contributed to the final outcome. This chapter reflects on what the project demonstrates and what can be learned from its implementation.

### 14.2 A Simple Problem Can Produce a Strong Project

One of the first findings is that a simple and familiar problem can still lead to a meaningful academic project when implemented properly. A notes management application may appear basic at first, but once security, user separation, persistence, and structured design are added, it becomes a substantial learning exercise. This finding is important because it shows that project quality depends not only on topic size but also on implementation depth and clarity.

### 14.3 Security Integration Increases Project Value

The use of Spring Security, BCrypt password hashing, and account locking significantly increases the technical value of the project. Without these features, the system would still support note CRUD, but it would not reflect strong secure development practice. The findings show that even one or two carefully selected security controls can change the academic strength of a project considerably.

### 14.4 Layered Design Improves Clarity

The project confirms that layered architecture makes a web application easier to understand and explain. Entities, repositories, services, controllers, and configuration classes each have distinct roles. This made development more manageable and also improved report writing because each layer could be explained separately. For a student project, such clarity is highly valuable.

### 14.5 Ownership Matters in Multi-User Systems

Another important finding is that route-based authentication alone is not enough. If note records are not checked against the current user during edit or delete operations, the system remains vulnerable to misuse. The project highlights the importance of object-level access control through ownership verification. This is a practical lesson that extends beyond the project topic itself.

### 14.6 Configuration Management Is Part of Development

The use of environment variables for database connectivity shows that development is not only about writing business logic. Deployment-related configuration also matters. Even a well-written project will not run correctly if database connection values are not provided properly. This finding is useful because it encourages a broader understanding of application development.

### 14.7 Academic Documentation Requires Different Skills Than Coding Alone

During the preparation of the report, it became clear that building the application and explaining the application are related but different tasks. Coding requires implementation skill, while report writing requires structured explanation, justification, and reflection. This finding is important because project work in higher education expects both. A student must not only make the project but also communicate its purpose, design, methodology, and results in a formal way.

### 14.8 Interpretation in Relation to Hypotheses

The findings support the alternative hypothesis more strongly than the null hypothesis. The project demonstrates that a secure web-based notes system can improve organization and access control when compared with manual or unstructured note handling. The system centralizes notes, applies authentication, protects passwords, and separates user data. These outcomes show practical improvement over insecure or scattered methods.

### 14.9 Academic and Practical Contribution

Academically, the project contributes by demonstrating how a small but realistic secure web application can be designed and documented. It can serve as a reference example for combining Java web development with basic security controls. Practically, the application provides a usable personal note platform. Even though it is not intended as a commercial deployment in its current form, it still serves as a functional tool for storing and managing notes.

### 14.10 Summary

The discussion of findings shows that the project has achieved more than just implementation of forms and database tables. It demonstrates secure design thinking, useful architecture, controlled scope, and meaningful academic value.

## Chapter 15: Contribution of the Project and Personal Learning

### 15.1 Contribution of the Project

The project contributes in several ways. First, it provides a secure notes management system that supports common user needs such as registration, login, add note, view notes, edit note, and delete note. Second, it contributes academically by showing that security can be integrated effectively into a student-level CRUD application. Third, it contributes structurally by using a clean layered design that can be explained and extended easily. The project also contributes to specialization alignment. Since the selected stream is cloud security, the inclusion of password hashing, route restriction, and account locking makes the project relevant beyond pure backend development.

### 15.2 Personal Contribution to the Work

My contribution to this project involved the complete planning, development, and documentation of the system. I selected the topic based on its relevance and feasibility. I studied the required technologies and designed the application flow. I implemented the entities, repositories, controllers, service logic, templates, and security configuration. I also integrated MySQL connectivity and validated the main user flows. In addition to the software development work, I prepared the research-oriented components of the project such as problem definition, objectives, literature review, methodology, findings, and conclusion.

### 15.3 Skills Developed During the Project

The project helped me develop backend development using Spring Boot, MVC-based request and view handling, Spring Security integration, password hashing and account lock logic, database modeling and JPA relationships, Thymeleaf-based server-side rendering, Maven dependency management, functional testing and debugging, project documentation, and academic report writing.

### 15.4 Conceptual Learning

At the conceptual level, I learned how secure application development involves multiple connected concerns. It is not enough to create tables and forms. One must think about identity verification, access restrictions, data ownership, password safety, error handling, and future maintainability. The project helped me understand these ideas practically.

### 15.5 Professional Relevance and Challenges

The project also has professional relevance because it models common patterns used in real applications. User accounts, secured login, persistent storage, and controlled CRUD access are found in many enterprise systems. Even though this project is smaller in scope, the design ideas are transferable. One of the challenges in the project was balancing simplicity and meaningful security. If the project became too large, it would be difficult to complete and explain. If it remained too basic, it would not reflect specialization depth. The selected features helped maintain that balance.

### 15.6 Summary

The project has made both technical and personal contributions. It demonstrates a useful system while also reflecting the learning journey involved in building and documenting it.

## Chapter 16: Limitations, Recommendations, and Future Scope

### 16.1 Introduction

No project is complete in an absolute sense. Every system is developed within limitations of time, resources, scope, and design choice. Acknowledging these limitations is important because it shows realistic understanding rather than overstatement. This chapter explains the current boundaries of the project and suggests how it can be improved in future.

### 16.2 Limitations of the Current Project

The present project has the following limitations: it supports only one main role, it does not include administrator monitoring features, it does not include note search, sorting, or category tagging, it does not support note sharing between users, it does not support file attachments or rich text formatting, it does not include email-based password reset, it does not include advanced logging or audit analytics, it does not include deployment automation or cloud hosting configuration, automated tests are limited, and the current UI is functional but not highly customized.

### 16.3 Recommendations

Based on the implementation and findings, the following recommendations can improve the project: add validation annotations and stronger form validation, add note search and filter functionality, add category label support, add profile editing and password change features, implement forgot-password and reset-password workflows, introduce an admin dashboard for user and activity management, add comprehensive unit and integration tests, use a test-specific in-memory database such as H2 for automated testing, improve UI clarity and accessibility, add pagination for note listing, add note update timestamps and audit records, and introduce REST API support for mobile or external clients.

### 16.4 Future Scope

The future scope of the project is broad. The application can be extended from a simple secure personal note manager into a more feature-rich productivity platform. Future versions may include search by keyword, note categorization and color labels, rich text editor support, attachments such as PDF or image files, note reminders and notifications, password reset through email verification, user profile management, multi-role architecture with administrator privileges, audit logs and account activity tracking, REST APIs and mobile app integration, cloud deployment with secure environment management, containerization using Docker, CI/CD integration for automated build and testing, stronger security such as OTP or two-factor authentication, and encryption of sensitive note content.

### 16.5 Why Future Scope Matters

Including future scope is not just a formal requirement. It shows that the developed project can serve as a foundation for larger work. A good project should solve the present problem while also allowing the evaluator to see possible growth areas. This project is suitable for such extension because its layered design and entity structure are already in place.

### 16.6 Summary

The limitations of the project do not reduce its academic value. Instead, they define its current boundaries. The recommendations and future scope show how the system can evolve into a richer and more advanced application over time.

## Chapter 17: Conclusion

The Secure Notes Management System with Spring Security is a successful academic project that combines practical utility, software engineering structure, and meaningful security features. The project addresses a common real-world problem: the need to store and manage notes in a secure and organized way. Instead of relying on manual methods or unsecured digital storage, the application provides a browser-based system where authenticated users can manage their own notes conveniently.

The project achieves its major objectives. It allows user registration, secure login, password hashing using BCrypt, note creation, note viewing, note editing, note deletion, and account locking after repeated failed login attempts. It uses Spring Boot and related technologies effectively and demonstrates how a layered design improves clarity and maintainability. The project also aligns with the cloud security specialization by including meaningful access control and account protection measures.

From a research and academic perspective, the project is significant because it transforms a practical implementation into a documented study. The report explains the problem, objectives, literature background, methodology, design, implementation, findings, and future scope. This makes the work more than just coding; it becomes a complete project submission that reflects conceptual understanding and applied learning.

The project also reflects personal learning and growth. It helped strengthen my understanding of secure web development, MVC architecture, JPA, Spring Security, database relationships, template rendering, and project documentation. Although the system still has areas that can be expanded in future, the current version is complete within its scope and suitable for academic demonstration.

In conclusion, the project proves that a secure and user-specific notes management application can be built successfully using Spring Boot, MySQL, Thymeleaf, and Spring Security. It fulfills the dual purpose of solving a practical problem and demonstrating important software development and security concepts in a clear, organized, and professionally explainable way.

## References

1. Spring. (n.d.). Spring Boot documentation. https://spring.io/projects/spring-boot
2. Spring. (n.d.). Spring Security documentation. https://spring.io/projects/spring-security
3. Spring. (n.d.). Spring Data JPA documentation. https://spring.io/projects/spring-data-jpa
4. Hibernate. (n.d.). Hibernate ORM documentation. https://hibernate.org/orm/documentation/
5. Thymeleaf. (n.d.). Thymeleaf documentation. https://www.thymeleaf.org/documentation.html
6. Bootstrap. (n.d.). Bootstrap documentation. https://getbootstrap.com/docs/
7. Oracle. (n.d.). Java documentation. https://docs.oracle.com/en/java/
8. MySQL. (n.d.). MySQL documentation. https://dev.mysql.com/doc/
9. Schildt, H. (2018). Java: The complete reference (11th ed.). McGraw-Hill Education.
10. Silberschatz, A., Korth, H. F., and Sudarshan, S. (2019). Database system concepts (7th ed.). McGraw-Hill.
11. Sommerville, I. (2015). Software engineering (10th ed.). Pearson.
12. Stallings, W. (2017). Computer security: Principles and practice (4th ed.). Pearson.

## Appendix A: Project File and Package Summary

The project is organized under the standard Spring Boot structure. The main packages include entities, repositories, services, controllers, and configuration. Templates are stored in the `resources/templates` directory, and static assets are stored under `resources/static`. Important files include the main application class, `application.properties`, entity classes for user and notes, repositories for user and note persistence, service interfaces and implementations, security configuration classes, controllers for public and authenticated routes, Thymeleaf templates for user interaction, and Maven `pom.xml`.

## Appendix B: Execution Requirements

To execute the project locally, the required database environment variables should be set. The application expects values for `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD`. After setting these values, the project can be started using the Maven wrapper command `./mvnw.cmd spring-boot:run` in PowerShell. MySQL should be running and reachable according to the configured connection URL.

## Appendix C: Viva Preparation Notes

The following points can be used during viva discussion: why the topic was chosen, the main technologies used, the security features, the key classes to explain, the main database relationship, the major limitation, and the future scope. This appendix helps the student revise the project in a focused manner before oral evaluation.

## Chapter 18: Page-Wise Interface Explanation and User Interaction Details

### 18.1 Introduction

A project report becomes easier to understand when the reader can connect the backend explanation with the visible interface. Many guides and evaluators prefer to understand not just the technical stack but also the sequence of screens through which the system is used. For that reason, this chapter explains the project page by page and connects each page to the corresponding backend behavior. This creates a bridge between the written report and the actual experience of using the application in a browser.

### 18.2 Home Page Interface

The home page is the first screen of the project. In the current implementation, the home page is intentionally simple and displays a large image. Even though this page does not contain heavy logic, it serves an important role. It acts as an entry point and visually communicates that the application is related to notes or documentation. The page is useful because it creates an initial impression and helps organize navigation in the project.

From a project-report perspective, the home page also shows an important design choice. I kept the first screen simple so that the user is not overwhelmed. Since the main focus of the application is secure note handling rather than complex marketing-style design, the home page gives direct access to the project without unnecessary distraction.

### 18.3 Registration Page Interface

The registration page is one of the most important interfaces in the application because it is the first point where the system begins to create user-specific value. A new user enters personal information such as name, qualification, email, address, gender, and password. From the user's point of view, this page is simple and form-driven. From the system's point of view, however, it triggers a complete registration workflow involving input binding, duplicate email verification, password hashing, default role assignment, and database persistence.

The registration page also demonstrates that the project is not only about note CRUD but about identity-aware interaction. Without registration, the project would not support personalized note ownership. Therefore, this page represents the formal beginning of the secure data lifecycle in the application.

### 18.4 Login Page Interface

The login page is another crucial page because it stands between public and private sections of the application. The user enters email and password and submits the form. Unlike the registration page, the login page does not directly save new records. Instead, it participates in the authentication framework controlled by Spring Security. The page is therefore small in appearance but strong in significance.

The login page is where the project demonstrates that security is not an extra layer added after development. Security is part of the normal user flow. The login form connects directly to the `userLogin` processing route, which then uses the configured authentication provider, custom user details service, password encoder, and success or failure handlers. In this way, a simple form on the page becomes the entry point for one of the most important backend processes in the system.

### 18.5 Add Notes Page Interface

After successful authentication, the user is redirected to the add-notes page. This design choice is deliberate. Instead of sending the user to a dashboard full of statistics, the application sends the user directly to the most important practical action, which is note creation. This makes the project feel purposeful and task-oriented.

The add-notes page includes fields for note title and note description. The user fills in the content and submits the note. On the backend, the note is connected to the currently authenticated user before saving. The page therefore demonstrates one of the strongest ideas in the project: user activity is always linked with user identity.

### 18.6 View Notes Page Interface

The view-notes page allows the user to see all notes linked to their account. This page is very important in project demonstration because it visibly proves that the data was stored and can be retrieved again. A project that only saves data but does not present it properly feels incomplete. The notes list gives the user feedback that the system is functioning and that their information is being managed successfully.

This page also reflects the user-specific nature of the application. Since notes are fetched by the current user, the list is not a global shared table. It is a personal notes view. During evaluation, this page can be used to explain how repositories, entity relationships, and controller logic work together.

### 18.7 Edit Notes Page Interface

The edit-notes page is a practical example of controlled data modification. When the user wants to change a note, the application first checks whether that note belongs to the currently authenticated user. Only after the ownership check passes does the edit page open. The page shows the note's existing content so that the user can update it.

This page is technically important because it combines usability and security. The system gives the user flexibility to update records, but it does not allow unrestricted editing. That balance between convenience and protection is one of the defining qualities of the project.

### 18.8 Delete Note Interaction

Although delete may not always require a dedicated page, it is still part of the interface flow because the user initiates it through the notes list or related action element. The project handles deletion carefully by checking ownership before removing the note. This behavior should be emphasized in the report because it shows that destructive actions were not left unprotected.

In academic projects, delete operations are often implemented quickly without enough thought. In this project, delete is treated as a protected action connected to authenticated ownership. This makes the interaction more realistic and better aligned with software security expectations.

### 18.9 Session Messages and User Guidance

A good application should communicate outcomes clearly. In the registration flow, the system uses session messages to tell the user whether registration succeeded or whether the email already exists. This may seem like a small feature, but it improves usability significantly. Users should not have to guess whether their action worked.

In project evaluation, this point matters because it shows attention to user experience. Even a secure backend can feel weak if the interface gives poor feedback. The use of messages helps the user understand application state in a simple way.

### 18.10 Importance of UI Simplicity in a College Project

For a college project, interface design should support understanding rather than distract from it. This project follows that principle. The UI is not overloaded with animations, complicated menus, or unnecessary visual elements. Instead, it focuses on readability, straightforward forms, and clear page roles. This decision makes the system easier to explain to a guide and easier to use during demonstration.

A simpler interface also helps the report remain honest. Since the major strength of the project lies in secure backend flow and proper architecture, the interface has been kept practical and aligned with the project goal.

### 18.11 User Journey as a Complete Story

The pages of the application together create a complete user journey. A new user arrives at the home page, opens registration, creates an account, signs in, creates notes, views saved notes, edits them when required, and deletes records when they are no longer useful. If the user enters the wrong password repeatedly, the system protects the account by locking it temporarily.

This journey is simple enough to understand quickly but complete enough to represent a real application. That is one of the reasons the project is suitable for academic evaluation. It is not merely a collection of unrelated screens. It is a connected system with a beginning, process, and secured outcome.

### 18.12 Summary

The page-wise explanation shows that each interface in the project has a clear purpose and is directly connected to backend functionality. The screens are simple, practical, and aligned with the system's core objective of secure notes management.

## Chapter 19: Project Planning, Development Process, and Execution Stages

### 19.1 Introduction

A successful project is not only the result of coding skill. It also depends on planning, scope control, technology selection, and disciplined execution. This chapter explains how the project can be viewed as a structured development effort rather than a random collection of code files. This is helpful for academic review because project guidelines usually expect evidence of planning and organized progress.

### 19.2 Topic Selection Stage

The first stage of the project was topic selection. I selected the secure notes management system because it satisfied several important conditions. It was relevant to technology and security. It was feasible within the academic timeline. It was broad enough to include multiple technical concepts, but focused enough to remain manageable. It also had practical value because note management is a common need in both academic and professional life.

A good project topic should be understandable, relevant, and explainable. This topic met all three conditions. It also gave me an opportunity to build something I could discuss confidently with my guide because the project logic is direct and the security features are visible.

### 19.3 Requirement Identification Stage

After selecting the topic, the next step was identifying the main requirements. At this stage, I considered what the minimum useful version of the system should include. I decided that the project must support registration, secure sign-in, password hashing, note creation, note retrieval, note editing, note deletion, user-note mapping, and account lock after failed logins. These requirements formed the working scope of the project.

This stage was important because it prevented the project from becoming too vague. Without clear requirements, development often becomes unbalanced. Some features become too detailed while others remain incomplete. By defining the core requirements early, I was able to maintain direction.

### 19.4 Technology Selection Stage

The next step was choosing the right tools. I selected Spring Boot because it supports rapid development and enterprise-style organization. I selected Spring Security because the project required more than simple login. I selected Spring Data JPA and Hibernate for database operations, Thymeleaf for page rendering, MySQL for persistence, and Maven for dependency management.

The technology selection stage was not random. Each tool was chosen because it solved a specific problem. This is important to mention in a report because evaluators often want to know not only what technologies were used but why they were used.

### 19.5 Design Stage

Once the requirements and tools were clear, the design stage began. At this stage, I planned the entity structure, user-note relationship, package organization, and security flow. I decided to use a layered architecture because it would make the project easier to code and easier to explain. I identified which responsibilities should belong to controllers, which should belong to services, and which should be handled by repositories and configuration classes.

Design also included the user flow. I decided that after successful login the user should go directly to the note area. I also decided that account lock logic should be integrated into authentication failure handling instead of being treated as a separate module disconnected from login.

### 19.6 Development Stage

During the development stage, I implemented the project module by module. I started with the entity classes and repository layer because persistence is central to the application. I then built registration and login flows. After that, I added notes CRUD operations and finally strengthened the system with custom authentication handlers and account lock logic.

This stage required regular testing because each new feature had to work with previous ones. For example, note creation only makes sense after authentication works, and ownership checks only make sense after note-user mapping is implemented correctly.

### 19.7 Debugging and Refinement Stage

No project is completed without debugging and refinement. During this stage, I checked whether forms were submitting correctly, whether user identity was being read properly from the `Principal`, whether note retrieval matched the logged-in user, and whether account lock behavior worked after repeated failed login attempts. I also checked environment-based database connectivity.

This stage is important because it shows that the project was not written once and left unexamined. It was observed, corrected, and refined so that the final behavior became more stable.

### 19.8 Documentation Stage

The documentation stage involved converting the practical software work into formal academic explanation. This required writing about the project in a structured way: introduction, problem statement, objectives, literature review, methodology, design, implementation, results, findings, and conclusion. This stage is often underestimated by students, but it is one of the most important parts of submission because the evaluator reads the report before or alongside project demonstration.

Writing the documentation also helped me understand the project more deeply. Explaining each component in words forced me to think carefully about why each design choice had been made.

### 19.9 Importance of Stage-Wise Development

Stage-wise development is especially useful in academic projects because it reduces confusion and increases completion quality. If the project had been developed without stages, it would have been easier to miss key features or leave parts inconsistent. The staged process of selection, requirement identification, technology choice, design, development, testing, refinement, and documentation made the work more organized.

This point can be useful in viva as well, because it shows that the project was approached systematically rather than casually.

### 19.10 Time and Effort Management

Another lesson from the project is the importance of time and effort management. It is easy to imagine many advanced features for a notes management system, such as sharing, search, categories, reminders, and dashboard analytics. However, trying to add everything often weakens the final result. For this reason, I focused on a controlled but complete scope. This decision allowed me to finish the project with meaningful depth in the selected features rather than leaving many features half-finished.

### 19.11 Summary

The project was developed through identifiable stages: topic selection, requirement analysis, technology choice, design, implementation, testing, refinement, and documentation. This stage-wise approach helped maintain clarity and supported the creation of a project that is both functional and academically presentable.
