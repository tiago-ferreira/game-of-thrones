package br.com.game.of.thrones.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(exclude = "affilliateAccounts")
@ToString(exclude = "affilliateAccounts")
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "Name cannot be Null")
    @NotBlank(message = "Name cannot be only whitespace")
    @NotEmpty(message = "Name cannot be Null or Empty")
    @Size(min = 3, message = "Name must be have atleast 3 characteres")
    private String name;
    private LocalDateTime createdDate;
    @OneToMany
    private List<AffilliateAccount> affilliateAccounts;

}
