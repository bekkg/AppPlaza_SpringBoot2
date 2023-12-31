package peaksoft.appplaza_springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
    public class Role  implements GrantedAuthority{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;
    @ManyToMany(cascade = {CascadeType.DETACH,
                      CascadeType.MERGE,
                      CascadeType.PERSIST,
                     CascadeType.REFRESH}, mappedBy = "roles")
    private List<User> users = new ArrayList<>();

    public Role (String roleName){
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return roleName;
    }

}
