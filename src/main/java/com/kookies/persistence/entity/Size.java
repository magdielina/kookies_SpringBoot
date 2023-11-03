package com.kookies.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Size {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20, unique = true)
    private String name;

    @OneToMany(mappedBy = "size", cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JsonIgnore
    private List<SubProduct> subProducts;

    @OneToMany(mappedBy = "size", cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JsonIgnore
    private List<Product> products;
}
