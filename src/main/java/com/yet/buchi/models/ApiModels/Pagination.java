package com.yet.buchi.models.ApiModels;
import com.fasterxml.jackson.annotation.*;

public class Pagination {
    private long countPerPage;
    private long totalCount;
    private long currentPage;
    private long totalPages;
    private PaginationLinks links;

    @JsonProperty("count_per_page")
    public long getCountPerPage() { return countPerPage; }
    @JsonProperty("count_per_page")
    public void setCountPerPage(long value) { this.countPerPage = value; }

    @JsonProperty("total_count")
    public long getTotalCount() { return totalCount; }
    @JsonProperty("total_count")
    public void setTotalCount(long value) { this.totalCount = value; }

    @JsonProperty("current_page")
    public long getCurrentPage() { return currentPage; }
    @JsonProperty("current_page")
    public void setCurrentPage(long value) { this.currentPage = value; }

    @JsonProperty("total_pages")
    public long getTotalPages() { return totalPages; }
    @JsonProperty("total_pages")
    public void setTotalPages(long value) { this.totalPages = value; }

    @JsonProperty("_links")
    public PaginationLinks getLinks() { return links; }
    @JsonProperty("_links")
    public void setLinks(PaginationLinks value) { this.links = value; }
}
