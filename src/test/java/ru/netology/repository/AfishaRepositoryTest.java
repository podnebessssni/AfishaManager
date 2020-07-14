package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;


import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {

    private AfishaRepository repository = new AfishaRepository();
    private Film first = new Film(1, "http//pic1.ru", "Thor", "fantasy");
    private Film second = new Film(2, "http//pic2.ru", "Armagedon", "fantasy");
    private Film third = new Film(3, "http//pic3.ru", "Star wars", "fantasy");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        repository.removeById(idToRemove);

        Film[] actual = repository.findAll();
        Film[] expected = new Film[]{ second, third,};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        assertEquals(second, repository.findById(2));
        assertNull(repository.findById(7));
    }

    @Test
    public void shouldRemoveAll() {
        repository.removeAll();

        Film[] actual = repository.findAll();
        Film[] expected = new Film[]{};

        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldShowAll() {

        Film[] actual = repository.findAll();
        Film[] expected = new Film[]{first, second, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;

        repository.removeById(idToRemove);

        Film[] actual = repository.findAll();
        Film[] expected = new Film[]{third, second, first};

        assertArrayEquals(expected, actual);
    }
}
