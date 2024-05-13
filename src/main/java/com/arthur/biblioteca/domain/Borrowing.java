package com.arthur.biblioteca.domain;

import com.arthur.biblioteca.dto.BorrowingDTO;
import com.arthur.biblioteca.repository.BorrowingRepository;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

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
    private LocalDateTime timestamp;
    

    public Borrowing(BorrowingDTO data) {

        this.id = data.id();
        this.user = data.user();
        this.book = data.book();
        this.timestamp = LocalDateTime.now();
    }
}
