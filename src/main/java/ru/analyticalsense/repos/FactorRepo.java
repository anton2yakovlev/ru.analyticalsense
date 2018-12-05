package ru.analyticalsense.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.analyticalsense.domain.Factor;

import java.util.List;

public interface FactorRepo extends JpaRepository<Factor, Long> {

}
