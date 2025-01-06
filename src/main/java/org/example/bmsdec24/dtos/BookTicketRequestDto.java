package org.example.bmsdec24.dtos;

import java.util.List;


public class BookTicketRequestDto {
    private int userId;
    private List<Integer> showSeatIds;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Integer> getShowSeatIds() {
        return showSeatIds;
    }

    public void setShowSeatIds(List<Integer> showSeatIds) {
        this.showSeatIds = showSeatIds;
    }
}
