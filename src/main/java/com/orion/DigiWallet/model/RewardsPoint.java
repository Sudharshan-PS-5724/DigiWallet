package com.orion.DigiWallet.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rewards_point")
public class RewardsPoint {

    // 3.3.1: Primary key with auto-generation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 3.3.2: Points field
    @Column(name = "points", nullable = true)
    private Integer points;

    // 3.3.3: Many-to-one relationship with Wallet
    @ManyToOne
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;

    // 3.3.4: Timestamp of last update
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // Automatically update timestamp before persisting/updating
    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        updatedAt = LocalDateTime.now();
    }

    // 3.3.5: Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}