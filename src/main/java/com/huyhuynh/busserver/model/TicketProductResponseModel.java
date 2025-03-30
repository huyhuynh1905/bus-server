package com.huyhuynh.busserver.model;

import com.huyhuynh.busserver.entity.TicketProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketProductResponseModel {
    private List<TicketProductEntity> ticketProducts;
}
