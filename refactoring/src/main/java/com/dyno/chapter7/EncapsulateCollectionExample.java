package com.dyno.chapter7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Team {
  private final List<String> members = new ArrayList<>();

  public void addMember(String member) {
    members.add(member);
  }

  public void removeMember(String member) {
    members.remove(member);
  }

  public List<String> getMembers() {
    return Collections.unmodifiableList(members); // Immutable collection
  }
}

// Usage
public class EncapsulateCollectionExample {
  public static void main(String[] args) {
    Team team = new Team();
    team.addMember("Alice");
    team.addMember("Bob");

    System.out.println("Team Members: " + team.getMembers());

    // Attempt to modify the collection will fail
    // team.getMembers().add("Charlie"); // Throws UnsupportedOperationException
  }
}
