package au.com.codeka.warworlds.client.game.world;

import au.com.codeka.warworlds.common.proto.Star;
import java.util.ArrayList;

/**
 * A {@link StarCollection} that's backed by a simple {@link ArrayList} of stars.
 */
public class ArrayListStarCollection implements StarCollection {
  private ArrayList<Star> stars;

  public ArrayListStarCollection() {
    stars = new ArrayList<>();
  }

  @Override
  public int size() {
    return stars.size();
  }

  @Override
  public Star get(int index) {
    return stars.get(index);
  }

  @Override
  public int indexOf(long starId) {
    for (int i = 0; i < stars.size(); i++) {
      if (stars.get(i).id.equals(starId)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public boolean notifyStarModified(Star star) {
    int index = indexOf(star.id);
    if (index >= 0) {
      stars.set(index, star);
      return true;
    }
    return false;
  }

  public ArrayList<Star> getStars() {
    return stars;
  }
}
