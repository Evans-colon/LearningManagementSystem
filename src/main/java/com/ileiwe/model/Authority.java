package com.ileiwe.model;



import lombok.Data;

import javax.persistence.*;
import java.util.UUID;


@Data
@Entity
public class Authority {


    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated(EnumType.STRING)
    private Role Authority;
}
