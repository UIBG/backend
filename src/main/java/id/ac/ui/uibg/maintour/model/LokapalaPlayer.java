package id.ac.ui.uibg.maintour.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class LokapalaPlayer extends Player{
    private String lokapalaId;
    private String nickname;
}
