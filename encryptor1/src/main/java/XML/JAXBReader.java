package XML;

import java.io.File;

import javax.xml.bind.*;

public class JAXBReader implements IXMLReadWrite {
	
	public InputData XMLRead(String xmlfile_path) throws Exception {
		File xmlfile = new File(xmlfile_path); //This is the XML input file.
		JAXBContext jaxbContext = JAXBContext.newInstance(InputData.class);
		
		//Read from the input file into "data".
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		InputData data = (InputData)jaxbUnmarshaller.unmarshal(xmlfile);
		
		//Validate.
		validate(data);
		
		return data;
	}

	//Use XMLMethods's validator (as it is used for validating the results too)
	public void validate(InputData data) throws Exception {
		XMLMethods.JAXBValidate(data);
	}
	
}
