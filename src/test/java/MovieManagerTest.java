import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    @Test
    public void shouldAddMovies() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Matrix");
        manager.addMovie("Matrix 2");
        manager.addMovie("WarCraft");
        String[] expected = { "Matrix", "Matrix 2", "WarCraft"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(actual, expected);
    }
    @Test
    public void shouldOverMaxAddMovies() {
            MovieManager manager = new MovieManager();
            manager.addMovie("Matrix");
            manager.addMovie("Matrix 2");
            manager.addMovie("WarCraft");
            manager.addMovie("Matrix1");
            manager.addMovie("Matrix 1");
            manager.addMovie("WarCraft1");
            String[] expected = { "Matrix", "Matrix 2", "WarCraft", "Matrix1", "Matrix 1", "WarCraft1"};
            String[] actual = manager.findAll();
            Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotMovies() {
        MovieManager manager = new MovieManager();
        String[] expected = {};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindLastWithDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Matrix");
        manager.addMovie("Matrix 2");
        manager.addMovie("Matrix 3");
        manager.addMovie("Avatar");
        manager.addMovie("Inception");
        manager.addMovie("Interstellar");
        String[] expected = {
                "Interstellar",
                "Inception",
                "Avatar",
                "Matrix 3",
                "Matrix 2"
        };
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindLastWhenExactLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Matrix");
        manager.addMovie("Matrix2");
        manager.addMovie("Matrix3");
        String[] expected = {"Matrix3", "Matrix2", "Matrix"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindLastOverLimit() {
        MovieManager manager = new MovieManager(2);
        manager.addMovie("Matrix");
        manager.addMovie("Matrix2");
        manager.addMovie("Matrix3");
        String[] expected = {"Matrix3", "Matrix2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindLastWhenLargeLimit() {
        MovieManager manager = new MovieManager(10);
        manager.addMovie("Matrix");
        manager.addMovie("Matrix2");
        manager.addMovie("Matrix3");
        String[] expected = {"Matrix3", "Matrix2", "Matrix"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}
