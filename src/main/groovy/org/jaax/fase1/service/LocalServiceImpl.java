package org.jaax.fase1.service;

import org.jaax.fase1.entity.Local;
import org.jaax.fase1.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LocalServiceImpl implements LocalService {

    @Autowired
    LocalRepository localRepository;

    public List<Local> findAllLocals() {
        return localRepository.findAll();
    }

    @Override
    public Local findById(Long id) {
        return localRepository.findById(id).get();
    }

    @Override
    public Local saveLocal(Local local) {
        return localRepository.save(local);
    }

    @Override
    public Local updateLocal(Long id, Local local) {
        Local localTemp = localRepository.findById(id).get();
        if(Objects.nonNull(local.getCode()) && !"".equals(local.getCode())){
            localTemp.setCode(local.getCode());
        }
        if(Objects.nonNull(local.getName()) && !"".equals(local.getName())){
            localTemp.setName(local.getName());
        }
        if(Objects.nonNull(local.getFloor()) && !"".equals(local.getFloor())){
            localTemp.setFloor(local.getFloor());
        }
        return localRepository.save(localTemp);
    }

    @Override
    public void deleteLocal(Long id) {
        localRepository.deleteById(id);
    }

    @Override
    public Optional<Local> findLocalByNameJPQL(String name) {
        return localRepository.findByNameJPQL(name);
    }

    public Optional<Local> findByName(String name){
        return localRepository.findByName(name);
    }

    @Override
    public Optional<Local> findByNameIgnoreCase(String name) {
        return localRepository.findByNameIgnoreCase(name);
    }
}
