import java.util.LinkedList;

class JosephusSurvivor {
  public static int josephusSurvivor(final int n, final int k) {
    int index = 0;

    LinkedList<Integer> listNumbs = new LinkedList<>();
    for (int i = 0; i < n; i++)
      listNumbs.add(i + 1);

    while (listNumbs.size() > 1) {
      index = (index + k - 1) % listNumbs.size();
      listNumbs.remove(index);
    }

    return listNumbs.get(0);
  }

  public static void main(String[] args) {
    System.out.println(josephusSurvivor(7, 3)); // 4
  }
}
