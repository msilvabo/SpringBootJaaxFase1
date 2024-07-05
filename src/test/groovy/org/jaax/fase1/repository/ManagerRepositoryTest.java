package org.jaax.fase1.repository;

import org.jaax.fase1.entity.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManagerRepositoryTest {
    @Autowired
    private ManagerRepository managerRepository;

    @Test
    public void findAllManager(){
        List<Manager> managerList = managerRepository.findAll();
        System.out.println("managerList: " + managerList);
    }
}