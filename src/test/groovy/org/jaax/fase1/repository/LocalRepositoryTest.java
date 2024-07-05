package org.jaax.fase1.repository;

import org.jaax.fase1.entity.Local;
import org.jaax.fase1.entity.Manager;
import org.jaax.fase1.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
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

    @Test
    public void saveLocalWithOrders(){
        Manager manager = Manager.builder().Firstname("Juana").Lastname("Lopez").build();
        Order order1 = Order.builder().description("Pelicula10 sala11").price(12).build();
        Order order2 = Order.builder().description("Pelicula20 sala21").price(8.50).build();

        Local local = Local.builder()
                .name("Cine 4D")
                .floor("Piso 4")
                .code("Code4001")
                .manager(manager)
                .orders(List.of(order1, order2))
                .build();
        localRepository.save(local);
    }

    @Test
    public void findAllLocalsWithOrders(){
        List<Local> locals = localRepository.findAll();
        System.out.println(locals);
    }
}