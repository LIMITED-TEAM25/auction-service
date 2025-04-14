package com.sparta.limited.auction_service.auction.domain.model;

import com.sparta.limited.common_module.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "p_auction")
public class Auction extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Long userId;

    @Column(nullable = false)
    private UUID auctionProductId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuctionStatus status;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal startingBid;

    @Column(precision = 10, scale = 2, nullable = true)
    private BigDecimal finalBid;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    private Auction(UUID auctionProductId,
        BigDecimal startingBid,
        LocalDateTime startTime, LocalDateTime endTime) {
        this.auctionProductId = auctionProductId;
        this.status = AuctionStatus.PENDING;
        this.startingBid = startingBid;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static Auction of(UUID auctionProductId, BigDecimal startingBid,
        LocalDateTime startTime, LocalDateTime endTime) {
        return new Auction(auctionProductId,
            startingBid, startTime, endTime);
    }

}
