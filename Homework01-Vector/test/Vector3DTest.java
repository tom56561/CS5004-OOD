
import static org.junit.Assert.assertEquals;
import java.util.Random;
import org.junit.Test;

/**
 * A JUnit test class for the Vector3D class.
 */
public class Vector3DTest {

  @Test
  public void testGetX() {

    double expected;
    Vector3D x;
    Random random = new Random(12345);

    for (int test = 0; test < 5000; test++) {
      expected = random.nextDouble() * 200;

      x = new Vector3D(expected, 0, 0);

      double actual = x.getX();

      assertEquals(expected, actual, 0.009);
    }
  }

  @Test
  public void testGetY() {

    double expected;
    Vector3D y;
    Random random = new Random(12345);

    for (int test = 0; test < 5000; test++) {
      expected = random.nextDouble() * 200;

      y = new Vector3D(0, expected, 0);

      double actual = y.getY();

      assertEquals(expected, actual, 0.009);
    }
  }

  @Test
  public void testGetZ() {

    double expected;
    Vector3D z;
    Random random = new Random(12345);

    for (int test = 0; test < 5000; test++) {
      expected = random.nextDouble() * 200;

      z = new Vector3D(0, 0, expected);

      double actual = z.getZ();

      assertEquals(expected, actual, 0.009);
    }
  }

  @Test
  public void testToString() {

    Vector3D vector;
    String expected;
    Random random = new Random(12345);

    for (int test = 0; test < 5000; test++) {
      double x = random.nextDouble() * 200;
      double y = random.nextDouble() * 200;
      double z = random.nextDouble() * 200;
      vector = new Vector3D(x, y, z);
      expected = String.format("(%.2f,%.2f,%.2f)", x, y, z);
      assertEquals(expected, vector.toString());
    }
  }

  @Test
  public void testGetMagnitude() {

    Vector3D vector;
    double expected;
    Random random = new Random(12345);

    for (int test = 0; test < 5000; test++) {
      double x = random.nextDouble() * 200;
      double y = random.nextDouble() * 200;
      double z = random.nextDouble() * 200;
      vector = new Vector3D(x, y, z);
      double sum = x * x + y * y + z * z;
      expected = Math.sqrt(sum);
      assertEquals(expected, vector.getMagnitude(), 0.009);
    }
  }

  @Test
  public void testGetNormalize() {

    Vector3D vector;
    Vector3D expected;
    Random random = new Random(12345);

    for (int test = 0; test < 5000; test++) {
      double x = random.nextDouble() * 200;
      double y = random.nextDouble() * 200;
      double z = random.nextDouble() * 200;
      vector = new Vector3D(x, y, z);
      double mag = vector.getMagnitude();
      Vector3D actual = vector.normalize();
      x /= mag;
      y /= mag;
      z /= mag;
      expected = new Vector3D(x, y, z);
      assertEquals(expected.toString(), actual.toString());
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalGetNormalize() {
    double x = 0;
    double y = 0;
    double z = 0;
    Vector3D vector = new Vector3D(x, y, z);
    vector.normalize();
  }

  @Test
  public void testAdd() {

    Vector3D vector;
    Vector3D a;
    String expected;
    Random random = new Random(12345);
   
    for (int test = 0; test < 5000; test++) {
      double x = random.nextDouble() * 200;
      double y = random.nextDouble() * 200;
      double z = random.nextDouble() * 200;
      double ax = random.nextDouble() * 200;
      double ay = random.nextDouble() * 200;
      double az = random.nextDouble() * 200;
      vector = new Vector3D(x, y, z);
      a = new Vector3D(ax, ay, az);
      expected = String.format("(%.2f,%.2f,%.2f)", x + ax, y + ay, z + az);
      assertEquals(expected, vector.add(a).toString());
    }
  }

  @Test
  public void testMultiply() {

    Vector3D vector;
    Vector3D expected;
    Random random = new Random(12345);

    for (int test = 0; test < 5000; test++) {
      double x = random.nextDouble() * 200;
      double y = random.nextDouble() * 200;
      double z = random.nextDouble() * 200;
      double constant = random.nextDouble() * 200;

      vector = new Vector3D(x, y, z);
      expected = new Vector3D(x * constant, y * constant, z * constant);
      assertEquals(expected.toString(), vector.multiply(constant).toString());
    }
  }

  @Test
  public void testDotProduct() {

    Vector3D vector;
    Vector3D a;
    double expected;
    Random random = new Random(12345);

    for (int test = 0; test < 5000; test++) {
      double x = random.nextDouble() * 200;
      double y = random.nextDouble() * 200;
      double z = random.nextDouble() * 200;
      double ax = random.nextDouble() * 200;
      double ay = random.nextDouble() * 200;
      double az = random.nextDouble() * 200;
      vector = new Vector3D(x, y, z);
      a = new Vector3D(ax, ay, az);
      expected = (x * ax) + (y * ay) + (z * az);
      assertEquals(expected, vector.dotProduct(a), 0.09);
    }
  }

  @Test
  public void testGetAngleBetween() {

    Vector3D vector;
    Vector3D a;
    double expected;
    Random random = new Random(12345);

    for (int test = 0; test < 5000; test++) {
      double x = random.nextDouble() * 200;
      double y = random.nextDouble() * 200;
      double z = random.nextDouble() * 200;
      double ax = random.nextDouble() * 200;
      double ay = random.nextDouble() * 200;
      double az = random.nextDouble() * 200;
      vector = new Vector3D(x, y, z);
      a = new Vector3D(ax, ay, az);
      expected = Math.acos((x * ax + y * ay + z * az)
          / (Math.sqrt(x * x + y * y + z * z) * Math.sqrt(ax * ax + ay * ay + az * az)))
          * 180 / Math.PI;
      assertEquals(expected, vector.angleBetween(a), 0.09);
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalGetAngleBetween() {
    double x = 0;
    double y = 0;
    double z = 0;
    Vector3D vector = new Vector3D(5, 6, 7);
    Vector3D a = new Vector3D(x, y, z);
    vector.angleBetween(a);
  }
  

}
