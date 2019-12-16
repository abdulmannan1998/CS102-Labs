/**
 * This class extends the SimpleURLReader class, it has a method that overrides
 * a method named getPageContents() from SimpleURLReader
 * @author Abdul Mannan
 * @version 1.0, 06 03 2019
 */

import cs1.SimpleURLReader;

public class MySimpleURLReader extends SimpleURLReader {
   
   //properties
   String url;
   
   //constructor
   public MySimpleURLReader (String Url) {
      super(Url);
      url = Url;
   }
   
   //methods
   
   /**
    * this method just gives us the url that is being accessed
    * @return - URL that is being processed
    */
   public String getURL() {
      return url;
   }
   
   /**
    * this method gets the name of the file that the url leads to
    * @return - Name of the file at the specified link
    */
   public String getName() {
      for( int x = url.length() - 1; x >= 0; x--) {//starts from last index so it gets filename only
         if( url.charAt(x) == '/') {
            return url.substring( x + 1);
         }
      }
      return "";
   }
   
   @Override
   /**
    * this method solves the problem of parent class where null is being 
    * output before the String.
    * @return - The text of the file without null at the start
    */
   public String getPageContents() {
      return super.getPageContents().substring(4);
   }
}