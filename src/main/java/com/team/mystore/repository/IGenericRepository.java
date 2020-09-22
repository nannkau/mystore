package com.team.mystore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface IGenericRepository<T extends Serializable> extends JpaRepository<T, Long> {
    T findOne(final Long id);

    List<T> findAll();

    void create(final T entity);

    void update(final T entity);

    void delete(final T entity);

    void deleteById(final Long entityId);
}
