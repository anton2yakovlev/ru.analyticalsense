package ru.analyticalsense.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;
import ru.analyticalsense.domain.Factor;

import java.util.List;
import java.util.Map;

public interface FactorRepo extends JpaRepository<Factor, Long> {

}
