/*一个密室游戏，给你一堆房间，有些房间里面有钥匙，有些房间需要特定的钥匙打开，还有一个房间里面有宝藏，
还会给你这些房间之间相连的关系，问你能不能从给定的某一个房间找到最后的宝藏，就返回0或1*/

class Room {
  int id, keyToOpen, hasKey; //the key needed and the key the room has
  boolean hasTreasure;
  Room[] neghbors; //connected rooms
  public room (int id, int keyToOpen, int hasKey, boolean hasTreasure){
    this.id = id;
    this.keyToOpen = keyToOpen;
    this.hasKey = hasKey;
    this.hasTreasure = hasTreasure;
  }
}

class Solution {
  Set<Integer> visited = new HashSet<>(); //collection of room we visited
  Set<Integer> keyHad = new HashSet<>(); //collection of keys we had
  Queue<Room> needKey = new LinkedList<>(); //collection of room need to visited
  booolean found;
  
  public boolean findTreasure(Room room) {
    dfs(room);
    while (!needKey.isEmpty()) {
      if (keyHad.contains(needKey.peek())) {
        dfs(needkey.peek());
        needKey.pop();
      }
    }
    return found;
  }
  
  public void dfs(Room room) {
    if (visited.contains(room.id)) return;
    if (room.keyToOpen != -1 && !keyHad.contains(room.keyToOpen)) {
      needKey.push(room);
      return;
    }
    visited.add(room.id);
    if (room.hasTreasure) {
      found = true;
      return;
    }
    if (room.hasKey != -1) keyHad.add(roo.hasKey);
    for (Room neighbot : room.neighbors) dfs(room.neighbors);
  }
}
