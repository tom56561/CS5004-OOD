
/**
 * This class represents 3D vector The 3D vector has a x, y, and z.
 */
public class Vector3D {
  private double x;
  private double y;
  private double z;

  /**
   * Constructs a Vector3D object and initializes it to the given x, y, and z.
   *
   * @param x the components of the vector
   * @param y the components of the vector
   * @param z the components of the vector
   */
  public Vector3D(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Return the x of this Vector3D.
   * 
   * @return the x of this Vector3D as a double
   */
  public double getX() {
    return this.x;
  }

  /**
   * Return the y of this Vector3D.
   * 
   * @return the y of this Vector3D as a double
   */
  public double getY() {
    return this.y;
  }

  /**
   * Return the x of this Vector3D.
   * 
   * @return the x of this Vector3D as a double
   */
  public double getZ() {
    return this.z;
  }

  /**
   * The Vector3D toString is represented by the components of the Vector3D.
   */
  public String toString() {
    return String.format("(%.2f,%.2f,%.2f)", this.x, this.y, this.z);
  }

  /**
   * Return the magnitude of this Vector3D.
   * 
   * @return the magnitude of this Vector3D as a double
   */
  public double getMagnitude() {
    double res = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    return res;
  }

  /**
   * Return a normalized version of this vector.
   * 
   * @return a normalized version of this vector
   * @throws IllegalArgumentException if a negative or zero x,y,z are passed as an
   *                                  argument
   */
  public Vector3D normalize() {
    if (this.x <= 0 && this.y <= 0 && this.z <= 0) {
      throw new IllegalArgumentException("x,y,z cannot be negative or zero");
    }
    double mag = this.getMagnitude();
    x = this.x / mag;
    y = this.y / mag;
    z = this.z / mag;
    Vector3D result = new Vector3D(x, y, z);

    return result;
  }

  /**
   * Returns the result of adding this vector to another vector.
   * 
   * @return the result of adding this vector to another vector
   */
  public Vector3D add(Vector3D a) {
    Vector3D result = new Vector3D(this.x + a.x, this.y + a.y, this.z + a.z);
    return result;
  }

  /**
   * Returns the result of multiplying this vector by a constant of type double.
   * 
   * @return the result of multiplying this vector by a constant of type double
   */
  public Vector3D multiply(double constant) {
    Vector3D result = new Vector3D(this.x * constant, this.y * constant, this.z * constant);
    return result;
  }

  /**
   * Returns the dot product of this vector and another vector.
   * 
   * @return the dot product of this vector and another vector
   */
  public double dotProduct(Vector3D a) {
    double result = (this.x * a.x) + (this.y * a.y) + (this.z * a.z);
    return result;
  }

  /**
   * Returns the angle between two vectors in degrees of type double.
   * 
   * @return the angle between two vectors in degrees of type double
   */
  public double angleBetween(Vector3D a) {
    if (a.x <= 0 && a.y <= 0 && a.z <= 0) {
      throw new IllegalArgumentException("x,y,z cannot be negative or zero");
    }
    return Math.acos(this.dotProduct(a) / (this.getMagnitude() * a.getMagnitude())) * 180 / Math.PI;
  }

}
