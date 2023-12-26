package com.bobocode.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table
@Entity(name = "cameras")
public class Camera {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
  @SequenceGenerator(name = "seq", sequenceName = "cameras_id_seq", allocationSize = 1)
  private Long id;

  @Getter
  @Setter
  @EqualsAndHashCode.Include
  private Long nasaId;

  @Setter
  private String name;

  @CreationTimestamp(source = SourceType.DB)
  private LocalDateTime createdAt;

  @ToString.Exclude
  @OneToMany(mappedBy = "camera", cascade = CascadeType.ALL, orphanRemoval = true)
  @Setter(value = AccessLevel.PRIVATE)
  private Set<Picture> pictures = new HashSet<>();

  public void addPicture(Picture picture) {
    pictures.add(picture);
    picture.setCamera(this);
  }

  public void removePicture(Picture picture) {
    pictures.remove(picture);
    picture.setCamera(null);
  }
}
