package com.trading.app.demo.repository;

import com.trading.app.demo.model.Wire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WireRepository extends JpaRepository<Wire, Long> {
}
