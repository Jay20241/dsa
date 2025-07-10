// TreeMap<K,V> => sorted order
// Red and black tree, BFS, DFS

//ammortize constant time
class MapUsingHash {

  private Entity[] entities;
  
  public MapUsingHash() {
    entities = new Entity[100];
  }

  public void put(String key, String value) {
    int hash = Math.abs(key.hashCode() % entities.length);
    entities[hash] = new Entity(key, value); // overriding, no chaining, no open addressing
  }

  public String get(String key) {
    int hash = Math.abs(key.hashCode() % entities.length);
    if(entities[hash] != null && entities[hash].key.equals(key)) {
        return entities[hash].value;
    }
    return null;
  }

  public void remove(String key) {
    int hash = Math.abs(key.hashCode() % entities.length);
    if(entities[hash] != null && entities[hash].key.equals(key)) {
        entities[hash] = null;
    }
  }

  private class Entity {
    String key;
    String value;

    public Entity(String key, String value) {
      this.key = key;
      this.value = value;
    }
  }
}


class Main {
    psvm(){
        // hashDemo();
        HashMapFinal<String, String> map = new HashMapFinal<>();
        
        map.put("Mango", "King of fruits");
        map.put("Apple", "A sweet red fruit");
        map.put("Litchi", "Jay's fav fruit");

        //map.get("Litchi");
        System.out.println(map);
    }

    public static void hashDemo() {
        // String name = "Rahul";
        // Integer a = 4235678;
        // int code = a.hashCode(); // or name.hashCode()
        // System.out.println(code);

        HashMap<String, Integer> map = new HashMap<>();

        map.put("Kunal", 89);
        map.put("Karan", 99);
        map.put("Rahul", 94);

        // System.out.println(map.get("Karan"));
        // System.out.println(map.getOrDefault("Apoorv", 78));
        System.out.println(map.containsKey("Karan"));

        HashSet<Integer> set = new HashSet<>();
        set.add(56);
        set.add(9);
        set.add(12);
        set.add(43);
        set.add(56); //no duplicate will be added
        set.add(2);

        System.out.println(set);
    }
}

//HashMap is not synchonize. Not thread safe.
//HashTable is synchonize. thread safe.