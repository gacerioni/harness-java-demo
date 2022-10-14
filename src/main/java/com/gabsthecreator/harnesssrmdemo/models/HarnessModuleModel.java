package com.gabsthecreator.harnesssrmdemo.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_HARNESS_MODULE")
public class HarnessModuleModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String shortName;
    @Column(nullable = false)
    private String imagePath;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private String description;

}
