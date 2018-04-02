package br.com.game.of.thrones.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Transfer {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private AffilliateAccount origin;
    @NotNull
    private AffilliateAccount destiny;
    @NotNull
    private BigDecimal value;
    @NotNull
    private LocalDateTime transferDate;
}
