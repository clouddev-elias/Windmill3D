package vindmolle;

import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;

public class Base extends Object 
{

	private static final float[] verts = 
	{

		// Part 1 Face left
		-5.0f, -5.0f, -5.0f,      0.0f, 0.0f, 0.0f,
		-5.0f,  5.0f, -5.0f,

		// Part 2 Face right
		5.0f,  5.0f, -5.0f,      0.0f, 0.0f, 0.0f,
		5.0f, -5.0f, -5.0f,

		// Part 3 Face up
		-5.0f,  5.0f, -5.0f,      0.0f, 0.0f, 0.0f,
		5.0f,  5.0f, -5.0f,

		// Part 4 Face down
		5.0f, -5.0f, -5.0f,      0.0f, 0.0f, 0.0f,
		-5.0f, -5.0f, -5.0f,

	};
	private static final float[] colors = 
	{

		// Part 1 Face left
		0.0f, 1.0f, 1.0f,                            0.0f, 1.0f, 1.0f,
		0.0f, 1.0f, 1.0f,

		// Part 2 Face right
		0.0f, 1.0f, 1.0f,                            0.0f, 1.0f, 1.0f,
		0.0f, 1.0f, 1.0f,

		// Part 3 Face up
		1.0f, 0.0f, 1.0f,                            1.0f, 0.0f, 1.0f,
		1.0f, 0.0f, 1.0f,

		// Part 4 Face down
		1.0f, 0.0f, 1.0f,                            1.0f, 0.0f, 1.0f,
		1.0f, 0.0f, 1.0f,

	};

	private Shape3D shape;

	public Base() 
	{
		TriangleArray base = new TriangleArray(12,TriangleArray.COORDINATES | TriangleArray.COLOR_3);

		base.setCoordinates(0, verts);
		base.setColors(0, colors);

		shape = new Shape3D(base, new Appearance());
	}

	public Shape3D getShape() 
	{
		return shape;
	}

}
