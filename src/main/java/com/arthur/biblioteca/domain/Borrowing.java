package com.arthur.biblioteca.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "borrowings")
@Table(name = "borrowings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Book book;
}
