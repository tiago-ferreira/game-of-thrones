package br.com.game.of.thrones.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AffilliateAccount extends Account {

    @NotNull(message = "The Parent Account cannot be Null")
    @ManyToOne
    private Account account;
}
