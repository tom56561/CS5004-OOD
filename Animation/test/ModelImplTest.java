

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import model.InterfaceModel;
import model.ModelImpl;
import model.ShapeType;

public class ModelImplTest {
  private InterfaceModel model;
  
  @Before
  public void setUp() {
    model = new ModelImpl();
    model.addShape("A", ShapeType.RECTANGLE, 0,0, 10, 20,
            1.0, 1.0, 1.0, 0,100);
    String name, ShapeType shapetype, double x, double y, Color color,
    double width, double height, int appearT, int disappearT
    model.addShape("B", ShapeType.OVAL, 0,0, 10, 20,
            1.0, 1.0, 1.0, 0,100);
  }

}
