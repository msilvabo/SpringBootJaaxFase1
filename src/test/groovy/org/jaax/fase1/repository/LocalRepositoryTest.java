package org.jaax.fase1.repository;

import org.jaax.fase1.entity.Local;
import org.jaax.fase1.entity.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LocalRepositoryTest {

    @Autowired
    private LocalRepository localRepository;

    @Test
    public void saveLocal(){
        Manager manager = Manager.builder()
                .Firstname("Juan")
                .Lastname("Perez")
                .build();
        Local local = Local.builder()
                .name("PetShop")
                .floor("2do")
                .manager(manager)
                .build();
        localRepository.save(local);
    }

    @Test
    public void findAllLocals(){
        List<Local> locals = localRepository.findAll();
        System.out.println("locals: " + locals);
    }
}