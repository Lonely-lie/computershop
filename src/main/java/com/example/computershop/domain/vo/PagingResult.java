package com.example.computershop.domain.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Result类说明信息
 *
 * @author HeWenhai
 * Created On: 2020-2-23 17:12
 * @since 1.0.0
 */
public class PagingResult<T> {

  private int totalCount;
  private int offset;
  private int size;
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