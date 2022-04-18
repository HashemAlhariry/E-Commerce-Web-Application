package com.ecommerce.repositories.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mail_code")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "findByCode", query = "select  c from CodeEntity c where c.code= :code")
})

public class CodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Enumerated(EnumType.STRING)
    CodeState state;
    String code;
    @OneToOne
//    @JoinColumn(name = "user_id")
    UserEntity user;

    public CodeEntity() {
    }

    public CodeEntity(CodeState state, String code, UserEntity user) {
        this.state = state;
        this.user = user;
        this.code = code;
    }
}
