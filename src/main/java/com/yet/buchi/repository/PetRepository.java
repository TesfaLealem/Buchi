package com.yet.buchi.repository;



import com.yet.buchi.DTOs.RequestDTOs.PetListIn;
import com.yet.buchi.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    void deletePetById(Long id);

    @Query("select p from Pet p  where p.id in :petId")
    public Pet findPetById(@Param("petId") Long petId);

    @Query("select p from Pet p  where p.type in :petType")
    public Pet findPetByType(@Param("petType") String petType);


   /* @Query(value = "select * from persons limit 50", nativeQuery = true)
    List<Person> getFirst50();
*/
    @Query("select p from Pet p where lower(p.type) like lower(concat('%', :type, '%')) " +
            "or lower(p.gender) like lower(concat('%', :gender, '%'))"+
            "or lower(p.size) like lower(concat('%', :size, '%'))"+
            "or lower(p.age) like lower(concat('%', :age, '%'))"
           // "or lower(p.goodWithChildren) like lower(concat('%', :isGoodWithChildren, '%'))" +
    )
    List<Pet> searchPets(@Param("type") String type,@Param("gender") String gender,
                         @Param("size") String size, @Param("age") String age);



       // petListIn.getLimit();






}

