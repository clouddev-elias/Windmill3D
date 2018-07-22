package vindmolle;

import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;

public class Fundament extends Object 
{

	private static final float[] verts = 
	{

		// Part 2 Face left
		-5.0f,  5.0f,  -5.0f,                         -5.0f,  5.0f, -35.0f,
		-5.0f, -5.0f, -35.0f,                         -5.0f, -5.0f,  -5.0f,

		// Part 2 Face right
		5.0f,  5.0f,  -5.0f,                          5.0f, -5.0f,  -5.0f,
		5.0f, -5.0f, -35.0f,                          5.0f,  5.0f, -35.0f,

		// Part 2 Face down
		5.0f, -5.0f,  -5.0f,                         -5.0f, -5.0f,  -5.0f,
		-5.0f, -5.0f, -35.0f,                          5.0f, -5.0f,  -5.0f,

		// Part 2 Face up
		-5.0f,  5.0f,  -5.0f,                          5.0f,  5.0f,  -5.0f,
		5.0f,  5.0f, -35.0f,                         -5.0f,  5.0f, -35.0f,

		// Part 2 Face back
		5.0f,  5.0f, -35.0f,                          5.0f, -5.0f, -35.0f,
		-5.0f, -5.0f, -35.0f,                         -5.0f,  5.0f, -35.0f,


		// Part 3 Face left
		-5.0f,  -5.0f, -35.0f,                       -5.0f, -95.0f, -35.0f,
		-5.0f, -95.0f, -25.0f,                       -5.0f,  -5.0f, -25.0f,

		// Part 3 Face right
		5.0f,  -5.0f, -35.0f,                        5.0f,  -5.0f, -25.0f,
		5.0f, -95.0f, -25.0f,                        5.0f, -95.0f, -35.0f,

		// Part 3 Face up
		5.0f,  -5.0f, -25.0f,                       -5.0f,  -5.0f, -25.0f,
		-5.0f, -95.0f, -25.0f,                        5.0f, -95.0f, -25.0f,

		// Part 3 Face down
		-5.0f,  -5.0f, -35.0f,                        5.0f,  -5.0f, -35.0f,
		5.0f, -95.0f, -35.0f,                       -5.0f, -95.0f, -35.0f,

		// Part 3 Face bottom
		5.0f, -95.0f, -25.0f,                       -5.0f, -95.0f, -25.0f,
		-5.0f, -95.0f, -35.0f,                        5.0f, -95.0f, -35.0f,
	};


	private static final float[] colors = 
	{

		// Part 2 Face left
		1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,
		1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,

		// Part 2 Face right
		1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,
		1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,

		// Part 2 Face down
		1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,
		1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,

		// Part 2 Face up
		1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,
		1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,


		// Part 2 Face back
		1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,
		1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,

		// Part 3 Face left
		1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,
		1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,

		// Part 3 Face right
		1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,
		1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,

		// Part 3 Face up
		1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,
		1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,

		// Part 3 Face down
		1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,
		1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,

		// Part 3 Face bottom
		1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,
		1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,

	};

	private Shape3D shape;

	public Fundament() 
	{
		QuadArray fundament = new QuadArray(40,
				QuadArray.COORDINATES | QuadArray.COLOR_3);

		fundament.setCoordinates(0, verts);
		fundament.setColors(0, colors);

		shape = new Shape3D(fundament, new Appearance());
	}

	public Shape3D getShape() 
	{
		return shape;
	}

}