// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.google.gson.Gson;



/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/quote")
public class DataServlet extends HttpServlet {
private ArrayList<String> quotes = new ArrayList<String>();
  @Override
  public void init(){
    quotes.add("The purpose of our lives is to be happy. --Dalai Lama");
    quotes.add("Life is what happens when you're busy making other plans. --John Lennon");
    quotes.add("Get busy living or get busy dying. --Stephen King");
    quotes.add("You only live once, but if you do it right, once is enough. --Mae West");
    quotes.add("Many of life's failures are people who did not realize how close they were to success when they gave up. --Thomas A. Edison");
    quotes.add("If you want to live a happy life, tie it to a goal, not to people or things. --Albert Einstein");
    quotes.add("Change your thoughts and you change your world. --Norman Vincent Peale");
    quotes.add("Three things in life -your health, your mission, and the people you love. That’s it. --Naval Ravikant");
    quotes.add("Those who realize their folly are not true fools. --Zhuangzi");
    quotes.add("It’s better to be a lion for a day than a sheep all your life. --Elizabeth Kenny");
  }
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String json = convertToJsonUsingGson(quotes);

    response.setContentType("application/json;");
    response.getWriter().println(json);
  }
   private String convertToJsonUsingGson(ArrayList<String> str) {
    Gson gson = new Gson();
    String json = gson.toJson(str);
    return json;
  }
}
