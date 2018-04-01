package br.com.game.of.thrones.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class AffilliateAccount extends Account {

    @NotNull(message = "The Parent Account cannot be Null")
    @ManyToOne
    private Account account;
}
