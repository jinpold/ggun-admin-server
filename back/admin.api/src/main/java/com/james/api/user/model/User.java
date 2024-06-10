package com.james.api.user.model;
import com.james.api.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@ToString(exclude = {"id"})
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String age;
    private String sex;
    private String email;
    private String address;
    private String phone;
    private Long asset;
    private String color;
    @Column(name = "Investment_propensity")
    private String InvestmentPropensity;
    private String token;
    private String role;


    public void setPassword(String password) {
        this.password = password;
    }
}