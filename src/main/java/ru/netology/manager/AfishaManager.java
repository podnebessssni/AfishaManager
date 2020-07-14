package ru.netology.manager;

import ru.netology.domain.Film;

public class AfishaManager {
  private Film[] items = new Film[0];
  int moviesToReturn ;

  public AfishaManager(int moviesToReturn) {
    this.moviesToReturn = moviesToReturn;
  }

  public void add(Film item) {
    int length = items.length + 1;
    Film[] tmp = new Film[length];
    System.arraycopy(items, 0, tmp, 0, items.length);
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = item;
    items = tmp;
  }

  public Film[] showAll() {
    int length = moviesToReturn;
    if (length > items.length) {
        length = items.length;
    }
    if (moviesToReturn <= 0) {
      length = items.length;
    }
    Film[] result = new Film[length];
    for (int i = 0; i < length; i++) {
      int index = items.length - i - 1;
      result[i] = items[index];
    }
    return result;
  }

}


