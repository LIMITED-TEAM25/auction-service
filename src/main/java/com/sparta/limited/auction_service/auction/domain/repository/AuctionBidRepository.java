package com.sparta.limited.auction_service.auction.domain.repository;

import com.sparta.limited.auction_service.auction.domain.model.AuctionUser;
import java.util.UUID;

public interface AuctionBidRepository {

    void save(AuctionUser auctionUser);

    boolean existsByAuctionIdAndUserId(UUID auctionId, Long userId);

    AuctionUser findFirstByAuctionIdOrderByBidDescCreatedAtAsc(UUID auctionId);
}
