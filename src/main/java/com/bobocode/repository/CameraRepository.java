package com.bobocode.repository;

import com.bobocode.model.entity.Camera;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CameraRepository extends JpaRepository<Camera, Long> {

  @Query("""
      select distinct c
      from com.bobocode.model.entity.Camera c
      left join fetch c.pictures
      where c.nasaId = :nasaId
      """)
  Optional<Camera> findByNasaId(Long nasaId);

  @Query(value = """
        select 
        case  when exists(select 1 from cameras p where p.nasa_id = :nasaId) 
        then 'true' 
        else 'false'
      end 
        """, nativeQuery = true)
  boolean existsByNasaId(Long nasaId);
}
