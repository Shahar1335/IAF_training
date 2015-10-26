package Encryptors;

import java.io.File;
import java.io.IOException;

import Algorithms.*;
import ExecutionAids.*;
import Keys.*;
import Logging.*;
import XML.*;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class DoubleEncryption extends Encryptor {
   
	
	public DoubleEncryption(EncryptionAlgorithm enc_algo) {
      super(enc_algo);
   }
	
   @Inject
   public DoubleEncryption(EncryptionAlgorithm enc_algo, FileOperations fo) {
      super(enc_algo, fo);
   }
   
   @SuppressWarnings("unchecked")
   public <T> void operation(String filepath, Key<T> key, String keypath, 
			String outpath, String action) throws Exception {
	   int [] keys_arr = new int[2]; //These are the keys in an array.
	   String text; //This is where the original text is stored.
	   String text_post; //This is the text after the en/decryption.
	   String keyfilepath = ""; //This is where the path to the keys are stored.
	   String postfilepath; //This is the path to the post-operation file.
	   File f = new File(filepath); //This will be used to get the file's name.
	   File f_post; //We will use this to get the en/decrypted file's name.
		  
	   //Check whether we only operate a single file or a whole directory.
	   checkSoloFile(key);
	      
	   //Announce that the operation has begun.
	   if (action.equals("encryption")) {
		   EncryptionStarted(f.getName());
	   }
	   else {
		   DecryptionStarted(f.getName());
	   }
	      
	   //If necessary, get a key.
	   if (key == null) {
		   key = (Key<T>) readKey(keypath, action);
	   }
	      
	   EncryptionLog4JLogger.debug("The keys are " + keys_arr[0] + 
	      								" and " + keys_arr[1]);
	   
	   //If we encrypt a single file, save the key.
	   if (this.soloFile && action.equals("encryption")) {
		   keyfilepath = this.fo.createNewFileName(filepath, "key");
		   this.fo.writeIntoFile(keyfilepath, key.toString());
	   }
	      
	   //Read the text from the file and en/decrypt it with the two keys. 
	   text = this.fo.readTextFromFile(filepath);
	   text_post = this.enc_algo.enc_dec_alg(text, key, action);
	      
	   EncryptionLog4JLogger.debug("The original text is \"" + text +
					"\" and the text after " + action + " is " + text_post);
	      
	   //Create a path to the file with the en/decryption.
	   if (outpath.equals("")) {
		   postfilepath = this.fo.createNewFileName(filepath, action);
	   }
	   else {
		   postfilepath = outpath;
	   }
	   f_post = new File(postfilepath);
	      
	   //Save the result of the en/decryption.
	   this.fo.writeIntoFile(postfilepath, text_post);
	   
	   //Announce that the operation is over.
	   if (action.equals("encryption")) {
		   EncryptionEnded(f.getName(), f_post.getName());
	   }
	   else {
		   DecryptionEnded(f.getName(), f_post.getName());
	   }
	   
	   //Increment the number of files we are finished with.
	   EncryptionLogEventsArgs.incrementNumOfFilesDone();
	   
	   /* If we operate a single file, we can write the results into an XML
	      file right away. */
	   if (this.soloFile) {
		   XMLMethods.XMLWrite(filepath, action, this, this.enc_algo,
													keyfilepath, postfilepath);
	   }
   }
   
   @SuppressWarnings("unchecked")
   public KeyDouble readKey(String keypath, String action) 
	         throws IOException, InvalidEncryptionKeyException {
	      //Read two keys and store them in an array.
	      String [] keys = this.fo.readKeys(keypath, 2, action, this);
	      String fat_msg;
	      int [] keys_nums = new int[2]; //This will be used to store the keys.
	      
	      /* Try to parse the keys into numbers. If a key is invalid, throw
	         an exception. */
	      
	      try {
	         keys_nums[0] = Integer.parseInt(keys[0]);
	         keys_nums[1] = Integer.parseInt(keys[1]);
	         return new KeyDouble(keys_nums[0], keys_nums[1]);
	      }
	      
	      catch (Exception nfe) {
	    	 fat_msg = "The file has (an) invalid key/s.";
	         throw new InvalidEncryptionKeyException(fat_msg, "fatal");
	      }
	      
   }
   
   public FileOperations getFO() {
      return this.fo;
   }
   
   public String toString() {
	  return "DoubleEncryption";
   }

}
