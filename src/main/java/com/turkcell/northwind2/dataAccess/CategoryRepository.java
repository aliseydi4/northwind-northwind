package com.turkcell.northwind2.dataAccess;

import com.turkcell.northwind2.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    boolean existsByName(String name);
    boolean existsById(int id);

    @Modifying
    @Query("update Category c set c.name=:name,c.description=:description where c.id=:id")
    void update(String name,String description,int id);
}
