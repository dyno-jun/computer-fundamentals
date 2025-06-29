public class GCD {
  public static void main(String[] args) {
    SYstem.out.println("")
  }

  public static int gcd(int a, int b) {
    return gcd(b, a % b);
  }

  public void array() {
    int [] arr = new int[5];
    int[] nums = {1, 2, 3};
    List<Inteber> items = new ArrayList();
    items.add(1);

    for (int num : items) {
      System.out.println(num);
    }
  }

  public void handleString() {
    String s = "";
    int length = s.length();

    char c = s.charAt(2);
    String cStr = String.valueOf(c);
    char[] chars = s.toCharArray();
    Arrays.sort(chars);

    StringBuilder sb = new StringBuilder();
  }

  public void list() {
    int[] nums = {1, 2, 3};
    Arrays.sort(nums);

    List<Integer> list = Arrays.asList(nums);
    Collection.sort(list);

    list.sort((a, b) -> b - a);
  }

  public void handleSet() {
    Map<String, Integer> map = new HashMap();
    map.put("a", 1);
    map.get("a");

    Set<Integer> set = new HashSet();
    set.add(5);
  }

}
