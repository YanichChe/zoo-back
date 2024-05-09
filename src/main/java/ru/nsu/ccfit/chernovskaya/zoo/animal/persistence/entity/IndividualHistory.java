package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.Zoo;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "individual_history")
public class IndividualHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "receipt_date", nullable = false)
    private LocalDate receiptDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "individual_id")
    private Individual individual;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "individual_status")
    private IndividualReceiptStatus individualStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "zoo_id")
    private Zoo zoo;

}