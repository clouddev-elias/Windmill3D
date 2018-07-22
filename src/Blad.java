package vindmolle;

import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;

public class Blad extends Object 
{

	private static final float[] verts = 
	{

		// Part 1 Face front
		0,0,3,    30,-10,3,    30,10,3,    0,0,3,

		// Part 2 Face right
		30,10,3,  30,-10,3,    30,-10,0,   30,10,0,

		// Part 3 Face left up
		0,0,3,    30,10,3,     30,10,0,    0,0,0,

		// Part 4 Face left down
		0,0,3,    0,0,0,       30,-10,0,   30,-10,3,

		// Part 5 Face back
		0,0,0,    30,10,0,     30,-10,0,   0,0,0

	};

	private static final float[] colors = 
	{

		// Part 1 Face front
		0,1,0,   0,1,0,   0,1,0,   0,1,0,

		// Part 2 Face right
		1,1,0,   1,1,0,   1,1,0,   1,1,0,

		// Part 3 Face left up
		1,1,0,   1,1,0,   1,1,0,   1,1,0,

		// Part 4 Face left down
		1,1,0,   1,1,0,   1,1,0,   1,1,0,

		// Part 5 Face back
		0,1,0,   0,1,0,   0,1,0,   0,1,0

	};

	private Shape3D shape;

	public Blad() 
	{
		QuadArray blad = new QuadArray(20,QuadArray.COORDINATES | QuadArray.COLOR_3);
		blad.setCoordinates(0, verts);
		blad.setColors(0, colors);

		shape = new Shape3D(blad, new Appearance());
	}

	public Shape3D getShape() 
	{
		return shape;
	}

}