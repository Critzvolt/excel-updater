package com.excelupdater.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Substance {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter private Integer id;
    @Column (name = "index") @Getter @Setter private String index;
    @Column (name = "ice") @Getter @Setter private String ice;
    @Column (name = "ec") @Getter @Setter private String ec;
    @Column (name = "cas") @Getter @Setter private String cas;
    @Column (name = "hsc") @Getter @Setter private String hsc;

}
