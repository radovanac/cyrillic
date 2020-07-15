package com.example.demo.mapper;

import com.example.demo.domain.AbstractJpa;
import java.util.List;
import java.util.stream.Collectors;
import lombok.NonNull;

public interface DtoMapper<D, E extends AbstractJpa> {

  D mapDto(E e);

  default List<D> mapDto(@NonNull List<E> list) {
    return list.stream().map(this::mapDto).collect(Collectors.toList());
  }
}
