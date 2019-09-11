# SHAPES-Modulation-Abstraction-
The initial Minimal version of the Shapes class library is extended to include triangles, squares, rectangles, and ellipses by following the principles of abstraction and modularity.
1. General Requirements:-

1.1. All components in Shapes should be usable in a 2-dimensional space with X and Y axes. There is
no constraint on direction or meaning of axes.
1.2. The library needs to support Points, Lines, Ellipses, Circles, Rectangles, and Squares.
1.3. All classes need to encapsulate the states of their objects, such that an object’s state cannot be
changed except by executing method on that object.

2. Points

2.1. Shapes should not allow the construction of a bad point, e.g., one with an infinite x or y
coordinate.
2.2. A user should be able to access the x and y coordinates that define the point’s position.
2.3. A user should be able to move a point relative to either axis or both axes at the same time.
2.4. A user should be to clone a point.

3. Line

3.1. Shapes should not allow the construction of a bad line, i.e., one with a bad point for either
terminus. A line cannot have a zero length.
3.2. A user should be able to access the points that define the termini of a line.
3.3. A user should be able to move a line.
3.4. A user should be able to compute the length of a line.
3.5. A user should be able to compute the slope of a line.

4. Triangle

4.1. Shapes should not allow the construction of a bad triangle: no edge of the triangle should have
a zero length, the vertices cannot all be in the same line, and the length of an edge cannot be
greater than the sum of the other two.
4.2. A user should be able to access the attributes that comprise the definition of a triangle, e.g.,
the vertices.
4.3. A user should be able to move a triangle.
4.4. A user should be able to compute the area of a triangle.
4.5. Optional: a user should be able to rotate a triangle.

5. Ellipse

5.1. Shapes should not allow the construction of a bad ellipse. For example, its area cannot be zero.
5.2. A user should be able to access the attributes that comprise the definition of an ellipse, e.g.,
the foci.
5.3. A user should be able to move an ellipse.
5.4. A user should be able to compute its area.
5.5. Optional: A user should be able to rotate an ellipse.

6. Circle

6.1. A circle in Shapes should behave similar to an Ellipse, except that two foci must be the same
and rotation (if implemented) has not affect.

7. Rectangle

7.1. Shapes should not allow the construction of a bad rectangle: no edge can have a zero length
and adjacent edges must form right angle.
7.2. A user should be able to access the attributes of the define the rectangle, e.g., vertices, height,
width, etc.
7.3. A user should be able to move a rectangle
7.4. A user should be able to compute its area
7.5. Optional: A user should be able to rotate a rectangle

8. Square

8.1. A square in Shapes should behave similar to a rectangle, except all its sides must be the same
length.
