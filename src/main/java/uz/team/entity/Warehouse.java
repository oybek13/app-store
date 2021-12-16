package uz.team.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.team.entity.template.AbsEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Warehouse extends AbsEntity {
}
