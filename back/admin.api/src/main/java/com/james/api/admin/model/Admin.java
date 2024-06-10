package com.james.api.admin.model;
import com.james.api.article.model.Article;
import com.james.api.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Entity(name = "admins")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@ToString(exclude = {"article", "id"})
@AllArgsConstructor
public class Admin extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Column(name = "enp_name")
    private String enpName; //사원 이름 Employee name 약어
    @Column(name = "enp_num")
    private String enpNum; // 사원번호
    private String department; // 부서
    private String position; // 직책
    private String job; // 직무
    @Column(name = "enp_email")
    private String enpEmail;
    private String phone;
    private String role; // 권한
    private String token;


    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Article> article;

    public void setPassword(String password) {
        this.password = password;
    }
}