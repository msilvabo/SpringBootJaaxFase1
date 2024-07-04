package org.jaax.fase1.service;

import org.jaax.fase1.entity.Local;

import java.util.List;
import java.util.Optional;

public interface LocalService {
    List<Local> findAllLocals();
    Local findById(Long id);
    Local saveLocal(Local local);
    Local updateLocal(Long id, Local local);
    void deleteLocal(Long id);
    Optional<Local> findLocalByNameJPQL(String name);
    Optional<Local> findByName(String name);
    Optional<Local> findByNameIgnoreCase(String name);
}
