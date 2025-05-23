package com.sparta.limited.auction_service.auction.infrastructure.repository;

import com.sparta.limited.auction_service.auction.domain.model.Auction;
import com.sparta.limited.auction_service.auction.domain.model.AuctionStatus;
import com.sparta.limited.auction_service.auction.domain.repository.AuctionRepository;
import com.sparta.limited.auction_service.auction.infrastructure.persistence.JpaAuctionRepository;
import com.sparta.limited.common_module.exception.BusinessException;
import com.sparta.limited.common_module.exception.ErrorCode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AuctionRepositoryImpl implements AuctionRepository {

    private final JpaAuctionRepository jpaAuctionRepository;

    @Override
    public void save(Auction auction) {
        jpaAuctionRepository.save(auction);
    }

    @Override
    public Auction findById(UUID auctionId) {
        return jpaAuctionRepository.findById(auctionId)
            .orElseThrow(() -> new BusinessException(ErrorCode.RESOURCES_NOT_FOUND, "존재하지 않는 경매입니다."));
    }

    @Override
    public boolean existsByIdAndUserId(UUID auctionId, Long userId) {
        return jpaAuctionRepository.existsByIdAndUserId(auctionId, userId);
    }

    @Override
    public List<Auction> findByStatusAndStartTimeBefore(AuctionStatus status, LocalDateTime currentTime) {
        return jpaAuctionRepository.findByStatusAndStartTimeBefore(status, currentTime);
    }

    @Override
    public List<Auction> findByStatusAndEndTimeBefore(AuctionStatus status, LocalDateTime currentTime) {
        return jpaAuctionRepository.findByStatusAndEndTimeBefore(status, currentTime);
    }
}
