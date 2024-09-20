public class Main {
    public static void main(String[] args) {
//        Location p1 = new Location(1, 0);
//        Shape s1 = new Circle(p1, '*', 5);
//        char[][] grids = s1.getGrids();
//        for (char[] grid : grids) {
//            System.out.println(grid);
//        }
//        System.out.printf("Grids: height = %d, width = %d\n", grids.length,
//                grids[0].length);
//        System.out.println(s1);
//        s1.shrink();
//        grids = s1.getGrids();
//        for (char[] grid : grids) {
//            System.out.println(grid);
//        }
//        System.out.printf("Grids: height = %d, width = %d\n", grids.length,
//                grids[0].length);
//        System.out.println(s1);



//        Location p1 = new Location(0, 1);
//        Shape s1 = new RightTriangle(p1, 'X', 7, 3, Direction.RIGHT_DOWN);
//        char[][] grids = s1.getGrids();
//        for (char[] line : grids) {
//            System.out.println(line);
//        }
//        System.out.printf("Grids height = %d, width = %d\n", grids.length,
//                grids[0].length);
//        System.out.println(s1);
//        s1.enlarge();
//        grids = s1.getGrids();
//        for (char[] line : grids) {
//            System.out.println(line);
//        }
//        System.out.printf("Grids height = %d, width = %d\n", grids.length,
//                grids[0].length);
//        System.out.println(s1);

//        ShapeCanvas shapeCanvas = new AvoidConflictShapeCanvas(20, 20);
//        System.out.println(shapeCanvas.addShape(0, 2, 'A', 5, 3,1));
//        System.out.println(shapeCanvas.addShape(6, 8, 'B', 5, 7, 2));
//        System.out.println(shapeCanvas.addShape(8, 12, 'C', 5));
//        System.out.println(shapeCanvas.addShape(6,6,'D',5,7,1));
//        System.out.println(shapeCanvas.addShape(0,8,'E',3));
//
//        shapeCanvas.getShapesByArea().forEach(System.out::println);
//        shapeCanvas.getShapesByLocation().forEach(System.out::println);
//
//        for (char[] line:shapeCanvas.getCanvas()) {
//            System.out.println(line);
//        }

        ShapeCanvas canvas1 = new OverLapShapeCanvas(15, 15);
        canvas1.addShape(0, 0, 'A', 6);
        canvas1.addShape(1, 1, 'B', 5);
        canvas1.addShape(2, 2, 'C', 4);
        canvas1.addShape(3, 3, 'D', 3);
        canvas1.addShape(10, 5, 'E', 4, 6, 2);
        canvas1.addShape(14, 14, 'F', 4, 6, 3);
        canvas1.addShape(10, 5, '0', 3, 2, 1);
        canvas1.addShape(10, 5, '1', 1, 1, 2);
        for (char[] line : canvas1.getCanvas()) {
            System.out.println(line);
        }
        System.out.println(canvas1.getShapeCount());
        System.out.println(canvas1.getSpaceGridCount());
        canvas1.getShapesByArea().forEach(System.out::println);
        canvas1.getShapesByLocation().forEach(System.out::println);
    }
}