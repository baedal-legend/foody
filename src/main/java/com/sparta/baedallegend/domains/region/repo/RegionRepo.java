package com.sparta.baedallegend.domains.region.repo;

import com.sparta.baedallegend.domains.region.domain.Region;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepo extends JpaRepository<Region, UUID> {

}
