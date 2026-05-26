# Gestione Biblioteca — Progetto Fullstack

Il dominio è una semplice gestione di una biblioteca con **4 entità**:

- **Categoria** — categoria del libro
- **Autore** — autore del libro
- **Libro** — il libro (ManyToOne → Autore, ManyToOne → Categoria)
- **Prestito** — prestito di un libro (ManyToOne → Libro)
---

## Struttura del progetto

```
biblioteca-fullstack/
├── backend/                       # Spring Boot 4.0.5
│   ├── pom.xml
│   └── src/main/
│       ├── java/com/example/biblioteca/
│       │   ├── BibliotecaApplication.java
│       │   ├── config/            # CORS
│       │   ├── controller/        # REST controller
│       │   ├── exception/         # gestione errori globale
│       │   ├── mapper/            # MapStruct
│       │   ├── model/entity/      # entità JPA
│       │   ├── model/dto/         # DTO
│       │   ├── repository/        # Spring Data JPA
│       │   └── service/           # logica di business
│       └── resources/
│           ├── application.properties
│           └── data.sql           # dati di esempio
└── frontend/                      # Angular 21
    └── src/app/
        ├── components/            # componenti standalone
        ├── models/                # interfacce TypeScript
        ├── services/              # client HTTP REST
        ├── core/                  # configurazione (URL API)
        ├── app.config.ts
        ├── app.routes.ts
        └── app.ts
```

### Architettura backend (a strati)

`Controller REST` → `Service` → `Repository (Spring Data JPA)` → `Database H2`

`Mapper MapStruct` converte tra **Entity** e **DTO**. I controller espongono e ricevono
solo DTO; le relazioni nei DTO sono "appiattite" (es. `autoreId`, `categoriaNome`).

---

## Avvio del backend

Requisiti: **JDK 21** e **Maven 3.9+**.

```bash
cd backend
mvn spring-boot:run
```

Il backend parte su **http://localhost:8080**.

### Console H2

Disponibile su **http://localhost:8080/h2-console**

- JDBC URL: `jdbc:h2:mem:bibliotecadb`
- Utente: `sa`
- Password: *(vuota)*

Il database viene ricreato a ogni avvio (`ddl-auto=create-drop`) e popolato
automaticamente da `data.sql`.

---

## Avvio del frontend

Requisiti: **Node.js 20+** e **npm**.

```bash
cd frontend
npm install
npm start
```

Il frontend parte su **http://localhost:4200** e consuma le API del backend.
Lo stile è realizzato con classi **Bootstrap 5.3** inline nei template dei componenti.

> Avviare prima il backend, poi il frontend.

---

## Endpoint REST

Tutte le risorse espongono un CRUD completo. Base URL: `http://localhost:8080/api`

| Metodo | Endpoint              | Descrizione                  |
|--------|-----------------------|------------------------------|
| GET    | `/api/categorie`      | elenco categorie             |
| GET    | `/api/categorie/{id}` | categoria per id             |
| POST   | `/api/categorie`      | crea categoria               |
| PUT    | `/api/categorie/{id}` | aggiorna categoria           |
| DELETE | `/api/categorie/{id}` | elimina categoria            |

Gli stessi 5 endpoint sono disponibili per `/api/autori`, `/api/libri`,
`/api/prestiti`.

---

## Tecnologie

**Backend**: Spring Boot 4.0.5, Spring Data JPA, Hibernate, H2, Lombok,
MapStruct 1.6.3

**Frontend**: Angular 21 e Bootstrap 5.3.
