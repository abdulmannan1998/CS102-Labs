/**
 * This class extends the MySimpleURLReader class, it has a method that can
 * extract comments from an html file
 * @author Abdul Mannan
 * @version 1.0, 06 03 2019
 */

import cs1.SimpleURLReader;

public class HTMLFilteredReader extends MySimpleURLReader {
   
   //properties
   private String filter = super.getPageContents();
   
   //constructors
   public HTMLFilteredReader( String url) {
      super(url);
   }
   
   //methods
   
   /**
    * this method returns the text from an HTML file by removing 
    * all HTML code.
    * @return - Text from the HTML file
    */
   public String getPageContents() {
      String output = "";
      int x = 0;
      while ( x < filter.length()) {
         while( filter.charAt(x) == '<' || filter.charAt(x) == '&') {//so that loop runs again if another tag (<....>) starts after one ends
            if( filter.charAt(x) == '<') {//Start: will increment x
               do {
                  x++;
               }while( filter.charAt(x) != '>');//End: untill closing tag is found
            }
            else if( filter.charAt(x) == '&') {//Start: will increment x
               do {
                  x++;
               }while( filter.charAt(x) != ';'); //End: untill ";" is found
            }
            x++;
         }
         output = output + filter.charAt(x);
         x++;
      }
      return output;
   }
   
   /**
    * this method will gives the HTML code and text both in a file
    * @return - Unfiltered HTML code
    */
   public String getUnfilteredPageContents() {
      return filter;
   }
   
}