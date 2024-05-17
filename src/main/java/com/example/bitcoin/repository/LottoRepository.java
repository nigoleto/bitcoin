package com.example.bitcoin.repository;


import com.example.bitcoin.entity.Lotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LottoRepository extends JpaRepository<Lotto, Long> {

    List<Lotto> findByOrderByRoundNumberDesc();

    @Query(value = "SELECT number, COUNT(number) AS count FROM (" +
            "SELECT l.number1 AS number FROM Lotto l UNION ALL " +
            "SELECT l.number2 FROM Lotto l UNION ALL " +
            "SELECT l.number3 FROM Lotto l UNION ALL " +
            "SELECT l.number4 FROM Lotto l UNION ALL " +
            "SELECT l.number5 FROM Lotto l UNION ALL " +
            "SELECT l.number6 FROM Lotto l) AS allNumbers " +
            "GROUP BY number ORDER BY count DESC", nativeQuery = true)
    List<Object[]> findNumberFrequencies();
}