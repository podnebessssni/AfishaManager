package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Afisha;


import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {

    AfishaRepository repository = new AfishaRepository();
    Afisha first = new Afisha(1, "http//pic1.ru", "Thor", "fantasy");
    Afisha second = new Afisha(2, "http//pic2.ru", "Armagedon", "fantasy");
    Afisha third = new Afisha(3, "http//pic3.ru", "Star wars", "fantasy");

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

        Afisha[] actual = repository.findAll();
        Afisha[] expected = new Afisha[]{ second, third,};

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

        Afisha[] actual = repository.findAll();
        Afisha[] expected = new Afisha[]{};

        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldShowAll() {

        Afisha[] actual = repository.findAll();
        Afisha[] expected = new Afisha[]{first, second, third};

        assertArrayEquals(expected, actual);
    }

//    @Test
//    public void shouldNotRemoveIfNotExists() {
//        int idToRemove = 4;
//
//        repository.removeById(idToRemove);
//
//        Afisha[] actual = repository.findAll();
//        Afisha[] expected = new Afisha[]{third, second, first};
//
//        assertArrayEquals(expected, actual);
//    }
}
