package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Film;
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

  private Film first = new Film(1, "http//pic1.ru", "Thor", "fantasy");
  private Film second = new Film(2, "http//pic2.ru", "Armagedon", "fantasy");
  private Film third = new Film(3, "http//pic3.ru", "Star wars", "fantasy");
  private Film fourth = new Film(4, "http//pic4.ru", "Cinderella", "musical");
  private Film fifth = new Film(5, "http//pic5.ru", "Spiderman", "comics");
  private Film sixth = new Film(6, "http//pic6.ru", "Leon killer", "action");
  private Film seventh = new Film(7, "http//pic7.ru", "Red hat", "story");
  private Film eight = new Film(8, "http//pic8.ru", "Sherlok Holms", "comedy");
  private Film nineth = new Film(9, "http//pic9.ru", "Wonderwoman", "action");
  private Film tenth = new Film(10, "http//pic10.ru", "Harry Potter","fantasy");
  private Film eleventh = new Film(11, "http//pic11.ru", "Hobbit", "fantasy");
  private Film twelvth = new Film(12, "http//pic12.ru", "Hobbit", "fantasy");

  @Test
  public void shouldShowMovies() {

    manager.add(first);
    manager.add(second);
    manager.add(third);

    Film[] returned = new Film[]{first, second, third};
    doReturn(returned).when(repository).findAll();

    Film[] actual = manager.showAll();
    Film[] expected = new Film[]{ third, second, first};
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

    Film[] returned = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eight, nineth,tenth};
    doReturn(returned).when(repository).findAll();
    doNothing().when(repository).save(eleventh);

    manager.add(eleventh);

    Film[] actual = manager.showAll();
    Film[] expected = new Film[]{ tenth, nineth, eight, seventh, sixth, fifth, fourth, third, second, first};
    assertArrayEquals(expected, actual);
  }
  @Test
  void shouldAdd() {

    manager.add(first);
    manager.add(second);
    manager.add(third);

    Film[] returned = new Film[]{first, second, third};
    doReturn(returned).when(repository).findAll();
    doNothing().when(repository).save(fourth);

    manager.add(fourth);

    Film[] actual = manager.showAll();
    Film[] expected = new Film[]{third, second, first};

    assertArrayEquals(expected, actual);
  }

  @Test
  void shouldShowEmpty() {
    Film[] returned = new Film[]{};
    doReturn(returned).when(repository).findAll();
    doNothing().when(repository).save(eleventh);

    manager.add(eleventh);

    Film[] actual = manager.showAll();
    Film[] expected = new Film[]{};

    assertArrayEquals(expected, actual);
  }


}