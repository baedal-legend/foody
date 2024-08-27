package com.sparta.baedallegend.region.repo;

import com.sparta.baedallegend.region.domain.Region;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepo extends JpaRepository<Region, UUID> {

}
