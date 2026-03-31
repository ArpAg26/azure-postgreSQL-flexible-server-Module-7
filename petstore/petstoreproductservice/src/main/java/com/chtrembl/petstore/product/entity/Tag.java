package com.chtrembl.petstore.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tag", schema = "public")
public class Tag {

    @Id
    private Long id;
    @Column(nullable = false, unique = true, length = 64)
    private String name;
}

