package uz.team.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.team.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Warehouse extends AbsEntity {

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH,
                    CascadeType.MERGE, CascadeType.REFRESH })
    @JoinTable(
            name = "users_warehouses",
            joinColumns = @JoinColumn(name = "warehouses_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id")
    )
    private Set<User> users;
}
