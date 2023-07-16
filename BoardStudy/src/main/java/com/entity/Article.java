package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Article {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long no;
  private String title;
  private String content;
  private Date writeDate;
  private String id;
  private String name;

  public Article() {

  }

  public Long getNo() {
    return no;
  }

  public void setNo(Long no) {
    this.no = no;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getWriteDate() {
    return writeDate;
  }

  public void setWriteDate(Date writeDate) {
    this.writeDate = writeDate;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Board [no=" + no + ", title=" + title + ", content=" + content + ", writeDate="
        + writeDate + ", id="
        + id + ", name=" + name + "]";
  }
}
