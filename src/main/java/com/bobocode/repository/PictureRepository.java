package com.bobocode.repository;

import com.bobocode.model.entity.Picture;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PictureRepository extends JpaRepository<Picture, Long> {

  @Query("select p from Picture p where p.nasaId = :nasaId")
  Optional<Picture> findPictureByNasaId(Long nasaId);


}
