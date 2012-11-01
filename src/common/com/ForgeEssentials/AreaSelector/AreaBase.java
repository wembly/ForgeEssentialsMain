package com.ForgeEssentials.AreaSelector;

public class AreaBase
{
	public Point start;
	public Point end;

	public AreaBase(Point start, Point end)
	{
		this.start = Point.copy(start);
		this.end = Point.copy(end);
		this.start.validate();
		this.end.validate();
	}

	public int[] getDimensions()
	{
		int[] array = new int[3];
		array[0] = Math.abs(start.x - end.x);
		array[1] = Math.abs(start.y - end.z);
		array[2] = Math.abs(start.z - end.z);
		return array;
	}

	public int getXLength()
	{
		return Math.abs(end.x - start.x) + 1;
	}

	public int getZLength()
	{
		return Math.abs(end.z - start.z) + 1;
	}

	public int getYLength()
	{
		return Math.abs(end.y - start.y) + 1;
	}
	
	/**
	 * just makes it so that the start is smaller than the end.
	 */
	public void alignPoints()
	{
		int diffx = start.x - end.x;
		int diffy = start.y - end.y;
		int diffz = start.z - end.z;
		
		int newX1 = start.x;
		int newX2 = end.x;
		int newY1 = start.y;
		int newY2 = end.y;
		int newZ1 = start.z;
		int newZ2 = end.z;
		
		if (diffx < 0)
		{
			newX1 = end.x;
			newX2 = start.x;
		}
		
		if (diffy < 0)
		{
			newY1 = end.y;
			newY2 = start.y;
		}
		
		if (diffx < 0)
		{
			newZ1 = end.z;
			newZ2 = start.z;
		}
		
		start.update(new Point(newX1, newY1, newZ1));
		end.update(new Point(newX2, newY2, newZ2));
	}
}