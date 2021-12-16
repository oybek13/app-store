package uz.team.entity.template;

import lombok.Data;
import uz.team.entity.Category;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class AbsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    private Category parentCategory;

    private boolean active;

}
