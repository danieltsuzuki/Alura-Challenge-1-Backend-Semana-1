package br.com.estudo.alurachallengebackendsemana1.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Video")
@Table(name = "videos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String url;
}
