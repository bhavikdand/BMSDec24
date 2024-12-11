package org.example.bmsdec24.repos;

import jakarta.persistence.LockModeType;
import org.example.bmsdec24.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    List<ShowSeat> findAllByIdInAndSeatStatus_Available(List<Integer> ids);
}
