package com.arthur.biblioteca.domain;

import com.arthur.biblioteca.dto.BookDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "books")
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private int releaseYear;

    public Book(BookDTO data) {
        this.id = data.id();
        this.title = data.title();
        this.author = data.author();
        this.releaseYear = data.releaseYear();
    }
}
