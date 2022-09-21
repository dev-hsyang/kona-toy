package com.konai.hsyang.konatoy.location.repository;

import com.konai.hsyang.konatoy.location.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
