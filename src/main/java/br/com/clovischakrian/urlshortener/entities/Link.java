package br.com.clovischakrian.urlshortener.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "links")
@Table(name = "links")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "linkId")
public class Link {
    @Id()
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int linkId;
    private String redirectLink;
    private Date createdAt;
    private Date updatedAt;

    @PrePersist
    public void onPrePersist() {
        Date date = new Date();
        this.createdAt = date;
        this.updatedAt = date;
    }

    @PreUpdate
    public void onPreUpdate() {
        this.updatedAt = new Date();
    }
}
