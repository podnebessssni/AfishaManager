package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class AfishaManagerTest {

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
    AfishaManager manager = new AfishaManager(8);
    manager.add(first);
    manager.add(second);
    manager.add(third);

    Film[] actual = manager.showAll();
    Film[] expected = new Film[]{third, second, first};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldShowMaxIfMore() {
    AfishaManager manager = new AfishaManager(11);

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

    Film[] actual = manager.showAll();
    Film[] expected = new Film[]{twelvth, eleventh,tenth,nineth,eight,seventh,sixth,fifth,fourth,third, second};

    assertArrayEquals(expected, actual);
  }
  @Test
  void shouldAdd() {
    AfishaManager manager = new AfishaManager(5);
    manager.add(first);
    manager.add(second);
    manager.add(third);

    Film[] actual = manager.showAll();
    Film[] expected = new Film[]{third, second, first};

    assertArrayEquals(expected, actual);
  }

  @Test
  void shouldShowEmpty() {
    AfishaManager manager = new AfishaManager(15);
    Film[] actual = manager.showAll();
    Film[] expected = new Film[]{};

    assertArrayEquals(expected, actual);
  }

  @Test
  void shouldShowNegative() {
    AfishaManager manager = new AfishaManager(-3);

    Film[] actual = manager.showAll();
    Film[] expected = new Film[]{};

    assertArrayEquals(expected, actual);
  }
}