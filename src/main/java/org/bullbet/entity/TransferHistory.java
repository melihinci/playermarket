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
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private Long fromTeamId;
    @Column
    private Long toTeamId;
    @Column
    private Long price;
    @Column
    private Date transferDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamFromId", insertable = false, updatable = false)
    private Team fromTeam;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamToId", insertable = false, updatable = false)
    private Team toTeam;

}
