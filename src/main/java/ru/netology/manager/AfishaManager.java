package ru.netology.manager;

import ru.netology.domain.Afisha;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
  private AfishaRepository repository;

  int moviesToReturn = 10;

  public AfishaManager(AfishaRepository repository) {
    this.repository = repository;

  }

  public AfishaManager(int moviesToReturn) {
    this.moviesToReturn = moviesToReturn;
  }

  public void add(Afisha item) {
    repository.save(item);
  }

  public Afisha[] showAll() {
    int length = moviesToReturn;
    Afisha[] items = repository.findAll();
    if (length > items.length) {
      length = items.length;
    }
    Afisha[] result = new Afisha[length];
    for (int i = 0; i < result.length; i++) {
      int index = items.length - i - 1;
      result[i] = items[index];
    }
    return result;
  }

}


