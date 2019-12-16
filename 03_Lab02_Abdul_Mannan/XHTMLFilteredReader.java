/**
 * This class extends the HTMLFilteredReader class, it has a method calculate
 * overhead from a HTML file, and a method that can extract links from html code
 * @author Abdul Mannan
 * @version 1.0, 06 03 2019
 */

import cs1.SimpleURLReader;
import java.util.ArrayList;

public class XHTMLFilteredReader extends HTMLFilteredReader {
   
   //constructors
   public XHTMLFilteredReader( String url) {
      super(url);
   }
   
   //methods
   
   /**
    * this method calculates the increase in size with the HTML code included
    * @return - Overhead caused by including HTML code
    */
   public double overhead() {
      double overhead;
      overhead = ((double)(super.getUnfilteredPageContents().length() - super.getPageContents().length()) / 
                 super.getPageContents().length()) * 100;
      return overhead;
   }
   
   /**
    * this method collects all the links in the HTML code of a given file
    * @return - All the links in the HTML file
    */
   public ArrayList getLinks() {
      ArrayList<String> links = new ArrayList<String>();
      String contents = super.getUnfilteredPageContents(), link = "";
      int linkAt = 0, x = 0;
      
      while( contents.indexOf("href=", linkAt) > 0) {
         linkAt = contents.indexOf("href=", linkAt);//Start: finds "href=" and starts adding chars to string
         linkAt = linkAt + 6;
         do {
            link = link + contents.charAt(linkAt);
            linkAt++;
         }while( contents.charAt(linkAt) != '"');//End: stops when the end quotation mark is found
         link = link + "\n";
         links.add(link);// link added to collection
         link = "";
         x = linkAt;
         x++;
      }
      
      return links;
   }
   
}