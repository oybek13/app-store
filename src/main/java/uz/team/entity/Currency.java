package uz.team.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.team.entity.template.AbsEntity;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Currency extends AbsEntity {

}
