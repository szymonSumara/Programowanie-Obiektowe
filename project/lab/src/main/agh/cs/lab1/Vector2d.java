package agh.cs.lab1;

import java.util.Objects;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public boolean precedes(Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2d other) {
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(this.x,other.x), Math.max(this.y,other.y));
    }

    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(this.x,other.x),Math.min(this.y,other.y));
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    public Vector2d opposite() {
        return new Vector2d(-1 * this.x, -1 * this.y);
    }

    public Vector2d convertToBounds(Vector2d northEastCorner,Vector2d southWestCorner ){
        int newX = this.x;
        int newY = this.y;

        if(this.x > northEastCorner.x)
            newX=southWestCorner.x;
        if(this.y > northEastCorner.y)
            newY=southWestCorner.y;


        if(this.x < southWestCorner.x)
            newX=northEastCorner.x;
        if(this.y < southWestCorner.y)
            newY=northEastCorner.y;

        return new Vector2d(newX,newY);
    }


}
