package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Afisha;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
  public class AfishaManagerTest {
  @Mock
  private AfishaRepository repository;
  @InjectMocks
  private AfishaManager manager ;

  Afisha first = new Afisha(1, "http//pic1.ru", "Thor", "fantasy");
  Afisha second = new Afisha(2, "http//pic2.ru", "Armagedon", "fantasy");
  Afisha third = new Afisha(3, "http//pic3.ru", "Star wars", "fantasy");
  Afisha fourth = new Afisha(4, "http//pic4.ru", "Cinderella", "musical");
  Afisha fifth = new Afisha(5, "http//pic5.ru", "Spiderman", "comics");
  Afisha sixth = new Afisha(6, "http//pic6.ru", "Leon killer", "action");
  Afisha seventh = new Afisha(7, "http//pic7.ru", "Red hat", "story");
  Afisha eight = new Afisha(8, "http//pic8.ru", "Sherlok Holms", "comedy");
  Afisha nineth = new Afisha(9, "http//pic9.ru", "Wonderwoman", "action");
  Afisha tenth = new Afisha(10, "http//pic10.ru", "Harry Potter","fantasy");
  Afisha eleventh = new Afisha(11, "http//pic11.ru", "Hobbit", "fantasy");
  Afisha twelvth = new Afisha(12, "http//pic12.ru", "Hobbit", "fantasy");

  @Test
  public void shouldShowMovies() {

    manager.add(first);
    manager.add(second);
    manager.add(third);

    Afisha[] returned = new Afisha[]{first, second, third};
    doReturn(returned).when(repository).findAll();

    Afisha[] actual = manager.showAll();
    Afisha[] expected = new Afisha[]{ third, second, first};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldShowMaxIfMore() {


    manager.add(first);
    manager.add(second);
    manager.add(third);
    manager.add(fourth);
    manager.add(fifth);
    manager.add(sixth);
    manager.add(seventh);
    manager.add(eight);
    manager.add(nineth);
    manager.add(tenth);
    manager.add(eleventh);
    manager.add(twelvth);

    Afisha[] returned = new Afisha[]{first, second, third, fourth, fifth, sixth, seventh, eight, nineth,tenth};
    doReturn(returned).when(repository).findAll();
    doNothing().when(repository).save(eleventh);

    manager.add(eleventh);

    Afisha[] actual = manager.showAll();
    Afisha[] expected = new Afisha[]{ tenth, nineth, eight, seventh, sixth, fifth, fourth, third, second, first};
    assertArrayEquals(expected, actual);
  }
  @Test
  void shouldAdd() {

    manager.add(first);
    manager.add(second);
    manager.add(third);

    Afisha[] returned = new Afisha[]{first, second, third};
    doReturn(returned).when(repository).findAll();
    doNothing().when(repository).save(fourth);

    manager.add(fourth);

    Afisha[] actual = manager.showAll();
    Afisha[] expected = new Afisha[]{third, second, first};

    assertArrayEquals(expected, actual);
  }

  @Test
  void shouldShowEmpty() {
    Afisha[] returned = new Afisha[]{};
    doReturn(returned).when(repository).findAll();
    doNothing().when(repository).save(eleventh);

    manager.add(eleventh);

    Afisha[] actual = manager.showAll();
    Afisha[] expected = new Afisha[]{};

    assertArrayEquals(expected, actual);
  }
}