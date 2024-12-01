package com.example.verodegit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pagination {
    private int total;
    private int limit;
    private int offset;
    private int totalPages;
    private int currentPage;
    private String nextUrl;

    // Getters et setters
    @JsonProperty("total_pages")
    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @JsonProperty("current_page")
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @JsonProperty("next_url")
    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }
    // Autres getters et setters (total, limit, offset)
}

