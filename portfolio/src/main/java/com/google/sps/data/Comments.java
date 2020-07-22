package com.google.sps.data;

public final class Comments {

  private final String nickname;
  private final String comment;

  public Comments(String nickname, String comment) {
    this.nickname = nickname;
    this.comment = comment;
  }
  public String getNickname() {
    return nickname;
  }

  public String getComment() {
    return comment;
  }
}
