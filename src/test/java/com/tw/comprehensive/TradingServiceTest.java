package com.tw.comprehensive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TradingServiceTest {
    @Test
    void should_log_new_trade_been_call_when_call_create_trade() {

        //given
        TradeRepository tradeRepository = mock(TradeRepository.class);
        AuditService auditService = mock(AuditService.class);
        Trade trade = mock(Trade.class);
        TradingService tradingService = new TradingService(tradeRepository, auditService);

        //when
        tradingService.createTrade(trade);

        //then
        verify(auditService, times(1)).logNewTrade(trade);
    }
}