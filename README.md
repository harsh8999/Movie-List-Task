### Movie-List-Task
Call a external API Server and make a GET request and store all the recived details in DB ( Website: https://developer.themoviedb.org/reference/intro/getting-started )


### Prerequisites

Make sure you have Java, MongoDB and Maven installed on your machine.

### Running the Application

1. Clone the repository:

    ```bash
    git clone https://github.com/harsh8999/Movie-List-Task.git
    ```

2. Build and run the application:

    ```bash
    ./mvnw spring-boot:run
    ```

    The application will be accessible at [http://localhost:8080](http://localhost:8080).

## API Endpoints

### Call the service

- **Endpoint:** `GET /movie`
- **Response:**
  ```json
  [
    {
        "id": "76600",
        "original_language": "en",
        "original_title": "Avatar: The Way of Water",
        "overview": "Set more than a decade after the events of the first film, learn the story of the Sully family (Jake, Neytiri, and their kids), the trouble that follows them, the lengths they go to keep each other safe, the battles they fight to stay alive, and the tragedies they endure.",
        "title": "Avatar: The Way of Water",
        "adult": false
    },
    {
        "id": "572802",
        "original_language": "en",
        "original_title": "Aquaman and the Lost Kingdom",
        "overview": "Black Manta, still driven by the need to avenge his father's death and wielding the power of the mythic Black Trident, will stop at nothing to take Aquaman down once and for all. To defeat him, Aquaman must turn to his imprisoned brother Orm, the former King of Atlantis, to forge an unlikely alliance in order to save the world from irreversible destruction.",
        "title": "Aquaman and the Lost Kingdom",
        "adult": false
    },
    {
        "id": "940551",
        "original_language": "en",
        "original_title": "Migration",
        "overview": "After a migrating duck family alights on their pond with thrilling tales of far-flung places, the Mallard family embarks on a family road trip, from New England, to New York City, to tropical Jamaica.",
        "title": "Migration",
        "adult": false
    }
  ]
