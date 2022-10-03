package org.bullbet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(name = "TEAM_SEQ", initialValue = 50)
public class Team implements Serializable {

    @Id
    @GeneratedValue(generator = "TEAM_SEQ", strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String name;

    @OneToMany(fetch= FetchType.LAZY,mappedBy="team")
    private List<Player> players;
}
