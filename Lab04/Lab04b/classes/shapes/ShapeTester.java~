import java.util.Scanner;

public class ShapeTester {
   public static void main( String[] args) {
      Scanner scan = new Scanner( System.in);
      
      //variables
      int option, radius, height, width, x, y;
      Circle c;
      Rectangle r;
      ShapeContainer collection = new ShapeContainer();
      
      System.out.println("Welcome to the Shape Tester");
      
      do {
         System.out.println("\nPress (1) to add a circle to the collection");
         System.out.println("Press (2) to add a rectangle to the collection");
         System.out.println("Press (3) to compute total Surface Area of the collection");
         System.out.println("Press (4) to print details of all the shapes in the collection");
         System.out.println("Press (5) to find shapes at a certain location");
         System.out.println("Press (6) to remove all the selected shapes in the collection");
         System.out.println("Press (0) to quit menu");
         
         option = scan.nextInt();
         
         if(option == 1) {
            System.out.println("Enter the radius of the circle:");
            radius = scan.nextInt();
            System.out.println("Enter location x for the circle:");
            x = scan.nextInt();
            System.out.println("Enter location y for the circle:");
            y = scan.nextInt();
            c = new Circle(radius, x, y);
            collection.add(c);
         }
         
         if(option == 2) {
            System.out.println("Enter the height of the rectangle:");
            height = scan.nextInt();
            System.out.println("Enter the width of the rectangle:");
            width = scan.nextInt();
            System.out.println("Enter location x for the rectangle:");
            x = scan.nextInt();
            System.out.println("Enter location y for the rectangle:");
            y = scan.nextInt();
            if(height == width) {
               r = new Square(width, x, y);
            }
            else {
               r = new Rectangle(width, height, x, y);
            }
            collection.add(r);
         }
         
         if(option == 3) {
            System.out.println("\n" + collection.getArea());
         }
         
         if(option == 4) {
            System.out.println("\n" + collection.toString());
         }
         
         if(option == 5) {
            System.out.println("Enter x-coordinate:");
            x = scan.nextInt();
            System.out.println("Enter y-coordinate:");
            y = scan.nextInt();
            if(collection.findContaining(x, y) == null) {
               System.out.println("No shape contains these coordinates");
            }
            else {
               System.out.println("\n" + collection.findContaining(x, y).toString());
               System.out.println("\nDo you want to select this shape? (1 = Yes, 0 = No)");
               option = scan.nextInt();
               if(option == 1) {
                  collection.findContaining(x, y).setSelected(true);
               }
               else {
                  collection.findContaining(x, y).setSelected(false);
               }
            }
         }
         
         if(option == 6) {
            collection.removeSelected();
         }
         
         if(option > 6 || option < 0) {
            System.out.println("\nInvalid Selection!");
         }
         
      }while(option != 0);
         
      System.out.println("\nGoodBye!");
   }
}