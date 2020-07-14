package ru.netology.manager;

import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
  private AfishaRepository repository;

  int moviesToReturn;

  public AfishaManager(AfishaRepository repository) {
    this.repository = repository;
    this.moviesToReturn = 10;
  }

  public AfishaManager(int moviesToReturn) {
    this.moviesToReturn = moviesToReturn;
    this.repository = repository;
  }

  public void add(Film item) {
    repository.save(item);
  }

  public Film[] showAll() {
    int length = moviesToReturn;
    Film[] items = repository.findAll();
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


