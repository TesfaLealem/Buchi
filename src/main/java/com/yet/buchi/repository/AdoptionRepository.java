package com.yet.buchi.repository;



import com.yet.buchi.models.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
    void deleteAdoptionById(Long id);

    @Query("select a from Adoption a  where a.id in :adoptionId")
    public Adoption findAdoptionById(@Param("adoptionId") Long adoptionId);

    @Query(value = "from Adoption a where requestDate BETWEEN :startDate AND :endDate")
    public List<Adoption> getAllBetweenDates(@Param("startDate") Date startDate, @Param("endDate")Date endDate);
}

