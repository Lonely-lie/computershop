package com.example.computershop.domain.vo;

import java.util.ArrayList;
import java.util.List;


public class PagingResult<T> {

  private int totalCount; //总数
  private int offset;     //第几页
  private int size;       //数量
  private List<T> items = new ArrayList<>();

  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }

  public int getOffset() {
    return offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public List<T> getItems() {
    return items;
  }

  public void setItems(List<T> items) {
    this.items = items;
  }
}