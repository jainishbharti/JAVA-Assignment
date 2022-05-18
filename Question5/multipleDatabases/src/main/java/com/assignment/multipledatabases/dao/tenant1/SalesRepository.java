package com.assignment.multipledatabases.dao.tenant1;

import com.assignment.multipledatabases.entity.tenant1.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer> {
}
