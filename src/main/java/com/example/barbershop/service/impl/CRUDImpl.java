package com.example.barbershop.service.impl;

import java.util.List;

import com.example.barbershop.repo.IGenericRepo;
import com.example.barbershop.service.ICRUD;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {


    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t) {
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public void delete(ID id) {
        getRepo().deleteById(id);
    }
}
