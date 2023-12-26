package com.bobocode.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "pictures")
@Entity
public class Picture {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
  @SequenceGenerator(name = "seq", sequenceName = "pictures_id_seq", allocationSize = 1)
  private Long id;

  @Setter
  @EqualsAndHashCode.Include
  private Long nasaId;

  @Setter
  private String imgSrc;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "camera_id")
  @Setter
  private Camera camera;

  @CreationTimestamp(source = SourceType.DB)
  private LocalDateTime createdAt;
}
