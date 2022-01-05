//This function reads an XML document to define global settings
// Dependencies: javax.xml.xpath | org.w3c | org.xml
public static void setFramework(String file) {
    // 1. Prepare Xpath
    XPathFactory xpf = XPathFactory.newInstance();
    XPath xPath = xpf.newXPath();

    try {
        // 2. Create XML File
        InputSource inputSource = new InputSource(file);

        // 3. Use XPath location to find values
        System.out.println(xPath.evaluate("/TestFramework/Location/Projects", inputSource, XPathConstants.STRING));
        System.out.println(((Element) (xPath.evaluate("/TestFramework/Browser", inputSource, XPathConstants.NODE))).getAttribute("Type"));	        

  } catch (XPathExpressionException e) {
        System.out.println("ERROR: Could not read XPath Expression");
        System.out.println(e.toString());
    }
}