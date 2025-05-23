package com.sparta.limited.auction_service.auction.domain.model;

import com.sparta.limited.auction_service.auction.domain.exception.AuctionErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuctionStatus {
    PENDING("경매대기중"),
    ACTIVE("경매진행중"),
    CLOSED("경매종료");

    private final String description;

    public static AuctionStatus from(String status) {
        return AuctionStatus.valueOf(status);
    }

    public static void validateClosedStatus(AuctionStatus status) {
        if (status == CLOSED) {
            throw AuctionErrorCode.AUCTION_ALREADY_CLOSED.toException();
        }
    }
}
