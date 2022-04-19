package com.yet.buchi.repository;



import com.yet.buchi.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    void deletePetById(Long id);

    @Query("select p from Pet p  where p.id in :petId")
    public Pet findPetById(@Param("petId") Long petId);

    @Query("select p from Pet p  where p.type in :petType")
    public Pet findPetByType(@Param("petType") String petType);

   @Query("SELECT p FROM Pet p WHERE CONCAT(p.type, p.gender, p.size, p.age, p.goodWithChildren) LIKE %?1%")
   List<Pet> searchPets(String keyword, Pageable pageable);





}

