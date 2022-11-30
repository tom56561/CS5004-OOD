
import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import model.InterfaceModel;
import model.ModelImpl;
import model.ShapeType;

public class ModelImplTest {
  private InterfaceModel model;

  @Before
  public void setUp() {

    model = new ModelImpl();
    model.addShape("A", ShapeType.RECTANGLE, 0, 0, 1, 1, 1, 10, 20, 0, 100);
    model.addShape("B", ShapeType.OVAL, 0, 0, 1, 1, 1, 10, 20, 0, 100);
  }

  @Test
  public void testGetShape() {
    assertEquals(
        "Name: A\n" + "Type: RECTANGLE\n"
            + "Min corner: (0.0,0.0), Width: 10.0, Height: 20.0, Color: (1, 1, 1)\n",
        model.getShape("A").toString());
    assertEquals(
        "Name: B\n" + "Type: OVAL\n"
            + "Min corner: (0.0,0.0), Width: 10.0, Height: 20.0, Color: (1, 1, 1)\n",
        model.getShape("B").toString());
  }

  @Test
  public void testChangeColor() {
    model.changeColor("A", 10, 20, 1, 1, 1, 20, 20, 20);
    model.changeColor("B", 10, 20, 1, 1, 1, 15, 35, 65);
    assertEquals(
        "Name: A\n" + "Type: RECTANGLE\n"
            + "Min corner: (0.0,0.0), Width: 10.0, Height: 20.0, Color: (20, 20, 20)\n",
        model.getShape("A").toString());
    assertEquals(
        "Name: B\n" + "Type: OVAL\n"
            + "Min corner: (0.0,0.0), Width: 10.0, Height: 20.0, Color: (15, 35, 65)\n",
        model.getShape("B").toString());
  }

  @Test
  public void testChangeScale() {
    model.changeScale("A", 40, 50, 10, 20, 12, 22);
    model.changeScale("B", 40, 50, 10, 20, 50, 60);
    assertEquals(
        "Name: A\n" + "Type: RECTANGLE\n"
            + "Min corner: (0.0,0.0), Width: 12.0, Height: 22.0, Color: (1, 1, 1)\n",
        model.getShape("A").toString());
    assertEquals(
        "Name: B\n" + "Type: OVAL\n"
            + "Min corner: (0.0,0.0), Width: 50.0, Height: 60.0, Color: (1, 1, 1)\n",
        model.getShape("B").toString());
  }

  @Test
  public void testMove() {
    model.move("A", 10, 20, 5, 5, 10, 10);
    model.move("B", 20, 40, 10, 10, 10, 21);
    assertEquals(
        "[Shape A moves from (5.0,10.0) to (5.0,10.0)]",
        model.getAnimation("A").toString());
    assertEquals(
        "[Shape B moves from (10.0,10.0) to (10.0,21.0)]",
        model.getAnimation("B").toString());
  }

}
