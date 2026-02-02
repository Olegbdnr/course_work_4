package com.lviv.iot.soportua.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class ServiceCRUD<T, ID> {

    protected JpaRepository<T, ID> repository;

    public T create(T entity) {
        return repository.save(entity);
    }

    public Optional<T> update(ID id, T newEntity) {
        return repository.findById(id).map(existing -> {
            updateFields(existing, newEntity);
            return repository.save(existing);
        });
    }

    public Optional<T> getById(ID id) {
        return repository.findById(id);
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public void delete(ID id) {
        repository.deleteById(id);
    }

    protected abstract void updateFields(T existing, T newEntity);
}