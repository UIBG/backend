package id.ac.ui.uibg.maintour.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Data
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class University extends School {

}
