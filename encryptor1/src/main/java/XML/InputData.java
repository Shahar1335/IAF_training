//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.11 at 05:05:43 PM IST 
//

/**
 * I have changed some types from String to classes that apply to encryption,
 * and have added the appropriante adapters. 
 */

package XML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import Adapters.*;
import Algorithms.*;
import DirectoryProcessors.*;
import Encryptors.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="File_or_Dir" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Sync_or_Async" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Encryptor_Used" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Algorithm_Used" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Path_Given" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Encrypt_or_Decrypt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Path_to_Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fileOrDir",
    "syncOrAsync",
    "encryptorUsed",
    "algorithmUsed",
    "pathGiven",
    "encryptOrDecrypt",
    "pathToKey"
})
@XmlRootElement(name = "Input_Data")
public class InputData extends Data {

    @XmlElement(name = "File_or_Dir", required = true)
    protected String fileOrDir;
    @XmlElement(name = "Sync_or_Async", required = true)
	@XmlJavaTypeAdapter( DirectoryProcessorAdapter.class )
    protected DirectoryProcessor syncOrAsync;
    @XmlElement(name = "Encryptor_Used", required = true)
	@XmlJavaTypeAdapter( EncryptorAdapter.class )
    protected Encryptor encryptorUsed;
    @XmlElement(name = "Algorithm_Used", required = true)
	@XmlJavaTypeAdapter( EncryptionAlgorithmAdapter.class )
    protected EncryptionAlgorithm algorithmUsed;
    @XmlElement(name = "Path_Given", required = true)
    protected String pathGiven;
    @XmlElement(name = "Encrypt_or_Decrypt", required = true)
    protected String encryptOrDecrypt;
    @XmlElement(name = "Path_to_Key", required = true)
    protected String pathToKey;

    /**
     * Gets the value of the fileOrDir property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileOrDir() {
        return fileOrDir;
    }

    /**
     * Sets the value of the fileOrDir property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileOrDir(String value) {
        this.fileOrDir = value;
    }

    /**
     * Gets the value of the syncOrAsync property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public DirectoryProcessor getSyncOrAsync() {
        return syncOrAsync;
    }

    /**
     * Sets the value of the syncOrAsync property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSyncOrAsync(DirectoryProcessor value) {
        this.syncOrAsync = value;
    }

    /**
     * Gets the value of the encryptorUsed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Encryptor getEncryptorUsed() {
        return encryptorUsed;
    }

    /**
     * Sets the value of the encryptorUsed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncryptorUsed(Encryptor value) {
        this.encryptorUsed = value;
    }

    /**
     * Gets the value of the algorithmUsed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public EncryptionAlgorithm getAlgorithmUsed() {
        return algorithmUsed;
    }

    /**
     * Sets the value of the algorithmUsed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlgorithmUsed(EncryptionAlgorithm value) {
        this.algorithmUsed = value;
    }

    /**
     * Gets the value of the pathGiven property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathGiven() {
        return pathGiven;
    }

    /**
     * Sets the value of the pathGiven property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathGiven(String value) {
        this.pathGiven = value;
    }

    /**
     * Gets the value of the encryptOrDecrypt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncryptOrDecrypt() {
        return encryptOrDecrypt;
    }

    /**
     * Sets the value of the encryptOrDecrypt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncryptOrDecrypt(String value) {
        this.encryptOrDecrypt = value;
    }

    /**
     * Gets the value of the pathToKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathToKey() {
        return pathToKey;
    }

    /**
     * Sets the value of the pathToKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathToKey(String value) {
        this.pathToKey = value;
    }
    
    public String toString() {
		return "InputData";
	}

}
