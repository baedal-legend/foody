package com.sparta.baedallegend.region.repo;

import com.sparta.baedallegend.region.domain.Region;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, UUID> {

}
