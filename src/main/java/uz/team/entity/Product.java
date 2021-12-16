package uz.team.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.team.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Product extends AbsEntity {

    @ManyToOne
    private Category category;

    @OneToOne
    private Attachment photo;

    private String code;

    @ManyToOne
    private Measurement measurement;
}